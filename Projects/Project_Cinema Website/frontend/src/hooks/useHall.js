import { useState, useEffect, useCallback } from 'react';
import HallService from '../services/HallService';

export const useHall = () => {
    const [halls, setHalls] = useState([]);
    const [hall, setHall] = useState(null);
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState(null);
    const [isHallAdded, setIsHallAdded] = useState(false);
    const [isHallUpdated, setIsHallUpdated] = useState(false);
    const [isHallDeleted, setIsHallDeleted] = useState(false);

    // 获取所有影厅
    const fetchHalls = useCallback(async () => {
        setLoading(true);
        setError(null);
        try {
            const data = await HallService.getAllHalls();
            if (data) setHalls(data);
        } catch (err) {
            setError(err.message || '获取影厅列表时出错。');
        } finally {
            setLoading(false);
        }
    }, []);

    // 获取单个影厅
    const fetchHallById = useCallback(async (hallId) => {
        setLoading(true);
        setError(null);
        try {
            const data = await HallService.getHallById(hallId);
            if (data) setHall(data);
        } catch (err) {
            setError(err.message || '获取影厅信息时出错。');
        } finally {
            setLoading(false);
        }
    }, []);

    // 获取指定影院的所有影厅
    const fetchHallsByCinemaId = useCallback(async (cinemaId) => {
        setLoading(true);
        setError(null);
        try {
            const data = await HallService.getHallsByCinemaId(cinemaId);
            if (data) setHalls(data);
        } catch (err) {
            setError(err.message || '获取影院的影厅列表时出错。');
        } finally {
            setLoading(false);
        }
    }, []);

    // 添加影厅
    const addHall = useCallback(async (newHall) => {
        setLoading(true);
        setError(null);
        setIsHallAdded(false);
        try {
            const success = await HallService.addHall(newHall);
            if (success) {
                setIsHallAdded(true);
                fetchHalls(); // 添加影厅后刷新列表
            }
            return success;
        } catch (err) {
            setError(err.message || '添加影厅时出错。');
            throw err; // 重新抛出以让调用者处理
        } finally {
            setLoading(false);
        }
    }, [fetchHalls]);

    // 更新影厅
    const updateHallById = useCallback(async (hallId, updatedHall) => {
        setLoading(true);
        setError(null);
        setIsHallUpdated(false);
        try {
            const success = await HallService.updateHallById(hallId, updatedHall);
            if (success) {
                setIsHallUpdated(true);
                fetchHalls(); // 更新影厅后刷新列表
            }
            return success;
        } catch (err) {
            setError(err.message || '更新影厅时出错。');
            throw err; // 重新抛出以让调用者处理
        } finally {
            setLoading(false);
        }
    }, [fetchHalls]);

    // 删除影厅
    const deleteHallById = useCallback(async (hallId) => {
        setLoading(true);
        setError(null);
        setIsHallDeleted(false);
        try {
            const success = await HallService.deleteHallById(hallId);
            if (success) {
                setIsHallDeleted(true);
                fetchHalls(); // 删除影厅后刷新列表
            }
            return success;
        } catch (err) {
            setError(err.message || '删除影厅时出错。');
            throw err; // 重新抛出以让调用者处理
        } finally {
            setLoading(false);
        }
    }, [fetchHalls]);

    // 挂载时获取所有影厅
    useEffect(() => {
        fetchHalls();
    }, [fetchHalls]);

    return {
        halls,
        hall,
        loading,
        error,
        isHallAdded,
        isHallUpdated,
        isHallDeleted,
        fetchHallById,
        fetchHallsByCinemaId,
        addHall,
        updateHallById,
        deleteHallById,
    };
};
