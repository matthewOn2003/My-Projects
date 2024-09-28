// 用户数据接口
interface User {
  user_id?: string; // 根据实际数据库表结构调整类型
  username: string;
  email: string;
  password_hash: string;
  permissions?: string;
  status?: string;
}

export default User