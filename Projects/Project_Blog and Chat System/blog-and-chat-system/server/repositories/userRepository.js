const pool = require('../db/db.config');

// 使用 Promise 处理 readAll
const readAll = (query) => {
    return new Promise((resolve, reject) => {
        let queryString = 'SELECT * FROM users';
        const filterAttributes = ['permissions', 'status'];

        const queryParams = [];
        const filters = [];
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
        queryString += ' ORDER BY user_id';

        // 执行查询
        pool.query(queryString, queryParams)
            .then(result => {
                resolve(result.rows);  // 查询成功，返回所有行数据
            })
            .catch(err => {
                reject(err);  // 查询失败，返回错误
            });
    });
};


// 已修改为 Promise 的 readOne 代码无需再更改
const readOne = (userId) => {
    return new Promise((resolve, reject) => {
        pool.query('SELECT * FROM users WHERE user_id = $1', [userId])
            .then(result => {
                if (result.rows.length > 0) {
                    resolve(result.rows[0]);  // 成功时返回用户数据
                } else {
                    reject(new Error('User not found'));  // 若找不到用户，返回错误
                }
            })
            .catch(error => {
                reject(error);
            });
    });
};

// 使用 Promise 处理 createOne
const createOne = (userData) => {
    return new Promise((resolve, reject) => {
        const { username, email, password_hash, permissions, status } = userData;

        pool.query(
            'INSERT INTO users (username, email, password_hash, permissions, status) VALUES ($1, $2, $3, $4, $5) RETURNING *',
            [username, email, password_hash, permissions, status]
        )
            .then(result => {
                resolve(result.rows[0]);  // 成功时返回新创建的用户
            })
            .catch(err => {
                reject(err);  // 失败时返回错误
            });
    });
};

// 使用 Promise 处理 updateOne
const updateOne = (userId, userData) => {
    return new Promise((resolve, reject) => {
        // 定义可以更新的字段
        const allowedFields = ['username', 'email', 'password_hash', 'permissions', 'status'];

        const queryParams = [];
        const setStatements = [];
        let paramIndex = 1;

        // 动态构建 SQL 的 SET 子句
        allowedFields.forEach(field => {
            if (userData[field] !== undefined) {
                setStatements.push(`${field} = $${paramIndex++}`);
                queryParams.push(userData[field]);
            }
        });

        console.log('wawa', setStatements);

        if (setStatements.length === 0) {
            reject(new Error('No valid fields provided for update'));  // 如果没有提供有效字段，抛出错误
            return;
        }

        queryParams.push(userId);  // 将 userId 加入查询参数

        const queryString = `
            UPDATE users
            SET ${setStatements.join(', ')}
            WHERE user_id = $${paramIndex}
            RETURNING *;
        `;

        pool.query(queryString, queryParams)
            .then(result => {
                resolve(result.rows[0]);  // 成功时返回更新后的用户
            })
            .catch(err => {
                reject(err);  // 失败时返回错误
            });
    });
};

// 使用 Promise 处理 deleteOne
const deleteOne = (userId) => {
    return new Promise((resolve, reject) => {
        pool.query('DELETE FROM users WHERE user_id = $1 RETURNING *', [userId])
            .then(result => {
                if (result.rows.length > 0) {
                    resolve(true);  // 删除成功
                } else {
                    reject(new Error('User not found'));
                }
            })
            .catch(err => {
                reject(err);  // 删除操作失败
            });
    });
};

module.exports = {
    readAll,
    readOne,
    createOne,
    updateOne,
    deleteOne
};
