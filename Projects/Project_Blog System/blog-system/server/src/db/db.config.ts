import { Pool } from 'pg';
import dotenv from 'dotenv';

dotenv.config();

const connectionString = `postgresql://${process.env.PGUSER}:${process.env.PGPASSWORD}@${process.env.PGHOST}:${process.env.PGPORT}/${process.env.PGDATABASE}`;

const pool = new Pool({
  connectionString: connectionString,
});

// 导出 pool 对象
export default pool;
