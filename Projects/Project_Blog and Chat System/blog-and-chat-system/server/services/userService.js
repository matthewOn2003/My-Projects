const userRepository = require('../repositories/userRepository');

const getAllUsers = async (query) => {
    return userRepository.readAll(query);
};

const getOneUser = async (userId) => {
    return userRepository.readOne(userId);
};

const createNewUser = async (userData) => {
    return userRepository.createOne(userData);
};

const updateOneUser = async (userId, userData) => {
    return userRepository.updateOne(userId, userData);
};

const deleteOneUser = async (userId) => {
    return userRepository.deleteOne(userId);
};

module.exports = {
    getAllUsers,
    getOneUser,
    createNewUser,
    updateOneUser,
    deleteOneUser
};
