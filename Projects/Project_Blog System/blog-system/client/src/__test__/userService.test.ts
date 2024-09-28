import UserService from '../services/userService';
import axios from '../../node_modules/axios/index';


// Mock axios
jest.mock('axios');

describe('UserService', () => {
  it('should fetch all users', async () => {
    const mockUsers = [{ id: 1, name: 'John Doe' }];

    // 模拟axios返回数据
    (axios.get as jest.Mock).mockResolvedValue({ data: mockUsers });

    const users = await UserService.getAllUsers();
    expect(users).toEqual(mockUsers);
  });
});
