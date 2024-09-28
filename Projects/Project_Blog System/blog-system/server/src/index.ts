// server.ts
import express, { Request, Response } from 'express';
import cors from 'cors';
import userRoute from './routes/userRoutes'; // 确保 userRoutes 文件存在并导出相应的路由

const app = express();
const PORT = process.env.PORT || 9000;

// Middleware
app.use(cors());
app.use(express.json());

// Routes
// const blogRoute = require('./routes/blogRoutes'); // 如果需要博客路由，确保其存在并导出
// ...

// Use Routes 
app.use('/api/users', userRoute);
// app.use('/api//blogs', blogRoute); // 如果需要博客路由，取消注释
// ...

app.listen(PORT, () => {
  console.log(`wawaServer running on port ${PORT}`);
});
