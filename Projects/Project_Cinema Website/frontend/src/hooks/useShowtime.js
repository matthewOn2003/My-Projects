import { useState, useEffect, useCallback } from 'react';
import ShowtimeService from '../services/ShowtimeService';

export const useShowtime = () => {
    const [showtimes, setShowtimes] = useState([]);
    const [showtime, setShowtime] = useState(null);
    const [experiences, setExperiences] = useState([]);
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState(null);
    const [isShowtimeAdded, setIsShowtimeAdded] = useState(false);
    const [isShowtimeUpdated, setIsShowtimeUpdated] = useState(false);
    const [isShowtimeDeleted, setIsShowtimeDeleted] = useState(false);

    // 获取所有放映时间
    const fetchShowtimes = useCallback(async () => {
        setLoading(true);
        setError(null);
        try {
            const data = await ShowtimeService.getAllShowtimes();
            if (data) setShowtimes(data);
        } catch (err) {
            setError(err.message || '获取放映时间列表时出错。');
        } finally {
            setLoading(false);
        }
    }, []);


    // 获取单个放映时间
    const fetchShowtimeById = useCallback(async (showtimeId) => {
        setLoading(true);
        setError(null);
        try {
            const data = await ShowtimeService.getShowtimeById(showtimeId);
            if (data) setShowtime(data);
        } catch (err) {
            setError(err.message || '获取放映时间信息时出错。');
        } finally {
            setLoading(false);
        }
    }, []);


    // 通过电影ID获取放映时间
    const fetchShowtimesByMovieId = useCallback(async (movieId) => {
        setLoading(true);
        setError(null);
        try {
            const data = await ShowtimeService.getShowtimesByMovieId(movieId);
            if (data) setShowtimes(data);
        } catch (err) {
            setError(err.message || '获取电影放映时间时出错。');
        } finally {
            setLoading(false);
        }
    }, []);


    // 通过影院ID获取放映时间
    const fetchShowtimesByCinemaId = useCallback(async (cinemaId) => {
        setLoading(true);
        setError(null);
        try {
            const data = await ShowtimeService.getShowtimesByCinemaId(cinemaId);
            if (data) setShowtimes(data);
        } catch (err) {
            setError(err.message || '获取影院放映时间时出错。');
        } finally {
            setLoading(false);
        }
    }, []);


    // 通过影厅ID获取放映时间
    const fetchShowtimesByHallId = useCallback(async (hallId) => {
        setLoading(true);
        setError(null);
        try {
            const data = await ShowtimeService.getShowtimesByHallId(hallId);
            if (data) setShowtimes(data);
        } catch (err) {
            setError(err.message || '获取影厅放映时间时出错。');
        } finally {
            setLoading(false);
        }
    }, []);


    // 通过电影ID、日期和体验类型获取放映时间
    const fetchShowtimesByMovieDateExperience = useCallback(async (movieId, showDate, experienceType) => {
        setLoading(true);
        setError(null);
        try {
            const data = await ShowtimeService.getShowtimesByMovieDateExperience(movieId, showDate, experienceType);
            if (data) setShowtimes(data);
        } catch (err) {
            setError(err.message || '获取特定体验类型放映时间时出错。');
        } finally {
            setLoading(false);
        }
    }, []);


    // 获取放映时间的体验类型
    const fetchShowtimesExperiences = useCallback(async (movieId, showDate) => {
        setLoading(true);
        setError(null);
        try {
            const data = await ShowtimeService.getShowtimesExperiences(movieId, showDate);
            console.log(data);
            if (data) setExperiences(data);
        } catch (err) {
            setError(err.message || '获取放映时间体验类型时出错。');
        } finally {
            setLoading(false);
        }
    }, []);


    // 添加放映时间
    const addShowtime = useCallback(async (newShowtime) => {
        setLoading(true);
        setError(null);
        setIsShowtimeAdded(false);
        try {
            const success = await ShowtimeService.addShowtime(newShowtime);
            if (success) {
                setIsShowtimeAdded(true);
                fetchShowtimes(); // 添加放映时间后刷新列表
            }
            return success;
        } catch (err) {
            setError(err.message || '添加放映时间时出错。');
            throw err; // 重新抛出以让调用者处理
        } finally {
            setLoading(false);
        }
    }, [fetchShowtimes]);


    // 更新放映时间
    const updateShowtimeById = useCallback(async (showtimeId, updatedShowtime) => {
        setLoading(true);
        setError(null);
        setIsShowtimeUpdated(false);
        try {
            const success = await ShowtimeService.updateShowtimeById(showtimeId, updatedShowtime);
            if (success) {
                setIsShowtimeUpdated(true);
                fetchShowtimes(); // 更新放映时间后刷新列表
            }
            return success;
        } catch (err) {
            setError(err.message || '更新放映时间时出错。');
            throw err; // 重新抛出以让调用者处理
        } finally {
            setLoading(false);
        }
    }, [fetchShowtimes]);


    // 删除放映时间
    const deleteShowtimeById = useCallback(async (showtimeId) => {
        setLoading(true);
        setError(null);
        setIsShowtimeDeleted(false);
        try {
            const success = await ShowtimeService.deleteShowtimeById(showtimeId);
            if (success) {
                setIsShowtimeDeleted(true);
                fetchShowtimes(); // 删除放映时间后刷新列表
            }
            return success;
        } catch (err) {
            setError(err.message || '删除放映时间时出错。');
            throw err; // 重新抛出以让调用者处理
        } finally {
            setLoading(false);
        }
    }, [fetchShowtimes]);


    return {
        showtimes,
        showtime,
        experiences,
        loading,
        error,
        isShowtimeAdded,
        isShowtimeUpdated,
        isShowtimeDeleted,
        fetchShowtimes,
        fetchShowtimeById,
        fetchShowtimesByMovieId,
        fetchShowtimesByCinemaId,
        fetchShowtimesByHallId,
        fetchShowtimesByMovieDateExperience,
        fetchShowtimesExperiences,
        addShowtime,
        updateShowtimeById,
        deleteShowtimeById,
    };
};
