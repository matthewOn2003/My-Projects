import pool from '../db/db.config'; // 确保你的数据库连接配置正确导出

// 用户数据接口
import User from '../model/User';


// 查询所有用户
const readAll = async (query: Record<string, any>): Promise<User[]> => {
  let queryString = 'SELECT * FROM users';
  const filterAttributes: Array<keyof User> = ['permissions', 'status'];

  const queryParams: any[] = [];
  const filters: string[] = [];
  let paramIndex = 1; // SQL 参数索引从 1 开始

  // 动态添加过滤条件
  filterAttributes.forEach(attr => {
    if (query[attr]) {
      filters.push(`${attr} = $${paramIndex++}`);
      queryParams.push(query[attr]);
    }
  });

  // 如果有过滤条件，添加到查询字符串中
  if (filters.length > 0) {
    queryString += ' WHERE ' + filters.join(' AND ');
  }
  const finalQuery = `${queryString} ORDER BY user_id`;

  try {
    const result = await pool.query(finalQuery, queryParams);
    return result.rows; // 返回所有行数据
  } catch (err) {
    throw err; // 查询失败，抛出错误
  }
};

// 查询单个用户
const readOne = async (userId: string): Promise<User | null> => {
  try {
    const result = await pool.query('SELECT * FROM users WHERE user_id = $1', [userId]);
    if (result.rows.length > 0) {
      return result.rows[0]; // 成功时返回用户数据
    } else {
      throw new Error('User not found'); // 若找不到用户，抛出错误
    }
  } catch (error) {
    throw error;
  }
};

// 创建新用户
const createOne = async (userData: User): Promise<User> => {
  const { username, email, password_hash, permissions, status } = userData;

  try {
    const result = await pool.query(
      'INSERT INTO users (username, email, password_hash, permissions, status) VALUES ($1, $2, $3, $4, $5) RETURNING *',
      [username, email, password_hash, permissions, status]
    );
    return result.rows[0]; // 成功时返回新创建的用户
  } catch (err) {
    throw err; // 失败时抛出错误
  }
};

// 更新用户
const updateOne = async (userId: string, userData: Partial<User>): Promise<User | null> => {
  const allowedFields: Array<keyof User> = ['username', 'email', 'password_hash', 'permissions', 'status'];

  const queryParams: any[] = [];
  const setStatements: string[] = [];
  let paramIndex = 1;

  // 动态构建 SQL 的 SET 子句
  allowedFields.forEach(field => {
    if (userData[field] !== undefined) {
      setStatements.push(`${field} = $${paramIndex++}`);
      queryParams.push(userData[field]);
    }
  });

  if (setStatements.length === 0) {
    throw new Error('No valid fields provided for update'); // 如果没有提供有效字段，抛出错误
  }

  queryParams.push(userId); // 将 userId 加入查询参数

  const queryString = `
        UPDATE users
        SET ${setStatements.join(', ')}
        WHERE user_id = $${paramIndex}
        RETURNING *;
    `;

  try {
    const result = await pool.query(queryString, queryParams);
    return result.rows[0]; // 成功时返回更新后的用户
  } catch (err) {
    throw err; // 失败时抛出错误
  }
};

// 删除用户
const deleteOne = async (userId: string): Promise<boolean> => {
  try {
    const result = await pool.query('DELETE FROM users WHERE user_id = $1 RETURNING *', [userId]);
    if (result.rows.length > 0) {
      return true; // 删除成功
    } else {
      throw new Error('User not found');
    }
  } catch (err) {
    throw err; // 删除操作失败
  }
};

export default {
  readAll,
  readOne,
  createOne,
  updateOne,
  deleteOne
};
