// userController.ts
import { Request, Response } from 'express';
import client from '../api/axiosConfig';

import User from '../model/User';

class UserService {

  static baseURL: string = "/users"

  static async getAllUsers() {
    const response = await client.get(`${UserService.baseURL}`);
    return response.data;
  }


  static async getOneUser(userId: number) {
    const response = await client.get(`${UserService.baseURL}/${userId}`);
    return response.data;
  }


  static async createNewUser(newUser: User) {
    const response = await client.post(`${UserService.baseURL}`, newUser);
    return response.data;
  }


  static async updateOneUser(userId: number, updatedUser: any) {
    const response = await client.patch(`${UserService.baseURL}`, updatedUser);
    return response.data;
  }


  static async deleteOneUser(userId: number) {
    const response = await client.delete(`${UserService.baseURL}/${userId}`);
    return response.data;
  }



}

export default UserService