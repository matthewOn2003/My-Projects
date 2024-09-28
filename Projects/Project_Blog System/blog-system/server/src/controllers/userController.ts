// userController.ts
import { Request, Response } from 'express';
import STATUS_CODES from '../utils/statusCodes'; // 确保你的状态码模块正确导出
import userService from '../services/userService'; // 确保服务模块正确导出

const getAllUsers = (req: Request, res: Response): void => {

  userService.getAllUsers(req.query)
    .then(users => {
      res.status(STATUS_CODES.OK).json(users);
    })
    .catch(err => {
      console.error('Service error:', err.message);
      res.status(STATUS_CODES.INTERNAL_SERVER_ERROR)
        .json({ error: `${STATUS_CODES.INTERNAL_SERVER_ERROR} Internal Server Error. Error: ${err.message}` });
    });
};

const getOneUser = (req: Request, res: Response): void => {
  userService.getOneUser(req.params.userId) // if error, will not go into 'then'
    .then(user => {
      res.status(STATUS_CODES.OK).json(user);
    })
    .catch(err => {
      console.error('Service error:', err.message);
      res.status(STATUS_CODES.INTERNAL_SERVER_ERROR)
        .json({ error: `${STATUS_CODES.INTERNAL_SERVER_ERROR} Internal Server Error. Error: ${err.message}` });
    });
};

const createNewUser = (req: Request, res: Response): void => {
  userService.createNewUser(req.body)
    .then(newUser => {
      res.status(STATUS_CODES.CREATED).json(newUser);
    })
    .catch(err => {
      console.error('Service error:', err.message);
      res.status(STATUS_CODES.INTERNAL_SERVER_ERROR)
        .json({ error: `${STATUS_CODES.INTERNAL_SERVER_ERROR} Internal Server Error. Error: ${err.message}` });
    });
};

const updateOneUser = (req: Request, res: Response): void => {
  userService.updateOneUser(req.params.userId, req.body)
    .then(updatedUser => {
      res.status(STATUS_CODES.OK).json(updatedUser);
    })
    .catch(err => {
      console.error('Service error:', err.message);
      res.status(STATUS_CODES.INTERNAL_SERVER_ERROR)
        .json({ error: `${STATUS_CODES.INTERNAL_SERVER_ERROR} Internal Server Error. Error: ${err.message}` });
    });
};

const deleteOneUser = (req: Request, res: Response): void => {
  userService.deleteOneUser(req.params.userId)
    .then(result => {
      res.status(STATUS_CODES.OK).json(result);
    })
    .catch(err => {
      console.error('Service error:', err.message);
      res.status(STATUS_CODES.INTERNAL_SERVER_ERROR)
        .json({ error: `${STATUS_CODES.INTERNAL_SERVER_ERROR} Internal Server Error. Error: ${err.message}` });
    });
};

export default {
  getAllUsers,
  getOneUser,
  createNewUser,
  updateOneUser,
  deleteOneUser
};
