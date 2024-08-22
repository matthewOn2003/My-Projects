import { useState, useEffect, useCallback } from 'react';
import FoodService from '../services/FoodService';

export const useFood = () => {
    const [foods, setFoods] = useState([]);
    const [food, setFood] = useState(null);
    const [categories, setCategories] = useState([]);
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState(null);
    const [isFoodAdded, setIsFoodAdded] = useState(false);
    const [isFoodUpdated, setIsFoodUpdated] = useState(false);
    const [isFoodDeleted, setIsFoodDeleted] = useState(false);

    // 获取所有食物
    const fetchFoods = useCallback(async () => {
        setLoading(true);
        setError(null);
        try {
            const data = await FoodService.getAllFoods();
            if (data) setFoods(data);
        } catch (err) {
            setError(err.message || '获取食物列表时出错。');
        } finally {
            setLoading(false);
        }
    }, []);

    // 获取单个食物
    const fetchFoodById = useCallback(async (foodId) => {
        setLoading(true);
        setError(null);
        try {
            const data = await FoodService.getFoodById(foodId);
            if (data) setFood(data);
        } catch (err) {
            setError(err.message || '获取食物信息时出错。');
        } finally {
            setLoading(false);
        }
    }, []);

    // 获取所有分类
    const fetchCategories = useCallback(async () => {
        setLoading(true);
        setError(null);
        try {
            const data = await FoodService.getAllCategories();
            if (data) setCategories(data);
        } catch (err) {
            setError(err.message || '获取分类列表时出错。');
        } finally {
            setLoading(false);
        }
    }, []);

    // 添加食物
    const addFood = useCallback(async (newFood) => {
        setLoading(true);
        setError(null);
        setIsFoodAdded(false);
        try {
            const success = await FoodService.addFood(newFood);
            if (success) {
                setIsFoodAdded(true);
                fetchFoods(); // 添加食物后刷新列表
            }
            return success;
        } catch (err) {
            setError(err.message || '添加食物时出错。');
            throw err; // 重新抛出以让调用者处理
        } finally {
            setLoading(false);
        }
    }, [fetchFoods]);

    // 更新食物
    const updateFoodById = useCallback(async (foodId, updatedFood) => {
        setLoading(true);
        setError(null);
        setIsFoodUpdated(false);
        try {
            const success = await FoodService.updateFoodById(foodId, updatedFood);
            if (success) {
                setIsFoodUpdated(true);
                fetchFoods(); // 更新食物后刷新列表
            }
            return success;
        } catch (err) {
            setError(err.message || '更新食物时出错。');
            throw err; // 重新抛出以让调用者处理
        } finally {
            setLoading(false);
        }
    }, [fetchFoods]);

    // 删除食物
    const deleteFoodById = useCallback(async (foodId) => {
        setLoading(true);
        setError(null);
        setIsFoodDeleted(false);
        try {
            const success = await FoodService.deleteFoodById(foodId);
            if (success) {
                setIsFoodDeleted(true);
                fetchFoods(); // 删除食物后刷新列表
            }
            return success;
        } catch (err) {
            setError(err.message || '删除食物时出错。');
            throw err; // 重新抛出以让调用者处理
        } finally {
            setLoading(false);
        }
    }, [fetchFoods]);


    return {
        foods,
        food,
        categories,
        loading,
        error,
        isFoodAdded,
        isFoodUpdated,
        isFoodDeleted,
        fetchFoods,
        fetchFoodById,
        addFood,
        updateFoodById,
        deleteFoodById,
    };
};
