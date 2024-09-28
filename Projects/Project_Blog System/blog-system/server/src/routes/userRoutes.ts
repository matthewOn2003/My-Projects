import express from 'express';
import userController from '../controllers/userController';

const router = express.Router();

router.get('/', userController.getAllUsers); // 确保此行正确
router.get('/:userId', userController.getOneUser);
router.post('/', userController.createNewUser);
router.patch('/:userId', userController.updateOneUser);
router.delete('/:userId', userController.deleteOneUser);

export default router;
