// userService.ts
import userRepository from '../repositories/userRepository'; // 确保你的 userRepository 模块正确导出
import User from '../model/User';

const getAllUsers = async (query: Record<string, any>): Promise<User[]> => {
  return userRepository.readAll(query);
};

const getOneUser = async (userId: string): Promise<User | null> => {
  return userRepository.readOne(userId);
};

const createNewUser = async (userData: User): Promise<User> => {
  return userRepository.createOne(userData);
};

const updateOneUser = async (userId: string, userData: User): Promise<User | null> => {
  return userRepository.updateOne(userId, userData);
};

const deleteOneUser = async (userId: string): Promise<boolean> => {
  return userRepository.deleteOne(userId);
};

export default {
  getAllUsers,
  getOneUser,
  createNewUser,
  updateOneUser,
  deleteOneUser
};
