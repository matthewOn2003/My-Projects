import { useState, useEffect, useCallback } from 'react';
import CinemaService from '../services/CinemaService';

export const useCinema = () => {
    const [cinemas, setCinemas] = useState([]);
    const [cinema, setCinema] = useState(null);
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState(null);
    const [isCinemaAdded, setIsCinemaAdded] = useState(false);
    const [isCinemaUpdated, setIsCinemaUpdated] = useState(false);
    const [isCinemaDeleted, setIsCinemaDeleted] = useState(false);


    // 获取所有影院
    const fetchCinemas = useCallback(async () => {
        setLoading(true);
        setError(null);
        try {
            const data = await CinemaService.getAllCinemas();
            if (data) setCinemas(data);
        } catch (err) {
            setError(err.message || '获取影院列表时出错。');
        } finally {
            setLoading(false);
        }
    }, []);


    // 获取单个影院
    const fetchCinemaById = useCallback(async (cinemaId) => {
        setLoading(true);
        setError(null);
        try {
            const data = await CinemaService.getCinemaById(cinemaId);
            if (data) setCinema(data);
        } catch (err) {
            setError(err.message || '获取影院信息时出错。');
        } finally {
            setLoading(false);
        }
    }, []);


    // 添加影院
    const addCinema = useCallback(async (newCinema) => {
        setLoading(true);
        setError(null);
        setIsCinemaAdded(false);
        try {
            const success = await CinemaService.addCinema(newCinema);
            if (success) {
                setIsCinemaAdded(true);
                fetchCinemas(); // 添加影院后刷新列表
            }
            return success;
        } catch (err) {
            setError(err.message || '添加影院时出错。');
            throw err; // 重新抛出以让调用者处理
        } finally {
            setLoading(false);
        }
    }, [fetchCinemas]);


    // 更新影院
    const updateCinemaById = useCallback(async (cinemaId, updatedCinema) => {
        setLoading(true);
        setError(null);
        setIsCinemaUpdated(false);
        try {
            const success = await CinemaService.updateCinemaById(cinemaId, updatedCinema);
            if (success) {
                setIsCinemaUpdated(true);
                fetchCinemas(); // 更新影院后刷新列表
            }
            return success;
        } catch (err) {
            setError(err.message || '更新影院时出错。');
            throw err; // 重新抛出以让调用者处理
        } finally {
            setLoading(false);
        }
    }, [fetchCinemas]);


    // 删除影院
    const deleteCinemaById = useCallback(async (cinemaId) => {
        setLoading(true);
        setError(null);
        setIsCinemaDeleted(false);
        try {
            const success = await CinemaService.deleteCinemaById(cinemaId);
            if (success) {
                setIsCinemaDeleted(true);
                fetchCinemas(); // 删除影院后刷新列表
            }
            return success;
        } catch (err) {
            setError(err.message || '删除影院时出错。');
            throw err; // 重新抛出以让调用者处理
        } finally {
            setLoading(false);
        }
    }, [fetchCinemas]);


    return {
        cinemas,
        cinema,
        loading,
        error,
        isCinemaAdded,
        isCinemaUpdated,
        isCinemaDeleted,
        fetchCinemas,
        fetchCinemaById,
        addCinema,
        updateCinemaById,
        deleteCinemaById,
    };
};
