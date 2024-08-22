import { useState, useEffect, useCallback } from 'react';
import SeatService from '../services/SeatService';

export const useSeat = () => {
    const [seats, setSeats] = useState([]);
    const [seat, setSeat] = useState(null);
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState(null);
    const [isSeatAdded, setIsSeatAdded] = useState(false);
    const [isSeatUpdated, setIsSeatUpdated] = useState(false);
    const [isSeatDeleted, setIsSeatDeleted] = useState(false);

    // 获取所有座位
    const fetchSeats = useCallback(async () => {
        setLoading(true);
        setError(null);
        try {
            const data = await SeatService.getAllSeats();
            if (data) setSeats(data);
        } catch (err) {
            setError(err.message || '获取座位列表时出错。');
        } finally {
            setLoading(false);
        }
    }, []);


    // 获取单个座位
    const fetchSeatById = useCallback(async (seatId) => {
        setLoading(true);
        setError(null);
        try {
            const data = await SeatService.getSeatById(seatId);
            if (data) setSeat(data);
        } catch (err) {
            setError(err.message || '获取座位信息时出错。');
        } finally {
            setLoading(false);
        }
    }, []);


    // 获取所有座位通过影厅ID
    const fetchSeatsByHallId = useCallback(async (hallId) => {
        setLoading(true);
        setError(null);
        try {
            const data = await SeatService.getSeatsByHallId(hallId);
            if (data) setSeats(data);
        } catch (err) {
            setError(err.message || '获取影厅座位时出错。');
        } finally {
            setLoading(false);
        }
    }, []);


    // 添加座位
    const addSeat = useCallback(async (newSeat) => {
        setLoading(true);
        setError(null);
        setIsSeatAdded(false);
        try {
            const success = await SeatService.addSeat(newSeat);
            if (success) {
                setIsSeatAdded(true);
                fetchSeats(); // 添加座位后刷新列表
            }
            return success;
        } catch (err) {
            setError(err.message || '添加座位时出错。');
            throw err; // 重新抛出以让调用者处理
        } finally {
            setLoading(false);
        }
    }, [fetchSeats]);


    // 更新座位
    const updateSeatById = useCallback(async (seatId, updatedSeat) => {
        setLoading(true);
        setError(null);
        setIsSeatUpdated(false);
        try {
            const success = await SeatService.updateSeatById(seatId, updatedSeat);
            if (success) {
                setIsSeatUpdated(true);
                fetchSeats(); // 更新座位后刷新列表
            }
            return success;
        } catch (err) {
            setError(err.message || '更新座位时出错。');
            throw err; // 重新抛出以让调用者处理
        } finally {
            setLoading(false);
        }
    }, [fetchSeats]);


    // 删除座位
    const deleteSeatById = useCallback(async (seatId) => {
        setLoading(true);
        setError(null);
        setIsSeatDeleted(false);
        try {
            const success = await SeatService.deleteSeatById(seatId);
            if (success) {
                setIsSeatDeleted(true);
                fetchSeats(); // 删除座位后刷新列表
            }
            return success;
        } catch (err) {
            setError(err.message || '删除座位时出错。');
            throw err; // 重新抛出以让调用者处理
        } finally {
            setLoading(false);
        }
    }, [fetchSeats]);


    return {
        seats,
        seat,
        loading,
        error,
        isSeatAdded,
        isSeatUpdated,
        isSeatDeleted,
        fetchSeats,
        fetchSeatById,
        fetchSeatsByHallId,
        addSeat,
        updateSeatById,
        deleteSeatById,
    };
};
