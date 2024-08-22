import { useState, useEffect, useCallback } from 'react';
import TicketService from '../services/TicketService';

export const useTicket = () => {
    const [tickets, setTickets] = useState([]);
    const [ticket, setTicket] = useState(null);
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState(null);
    const [isTicketAdded, setIsTicketAdded] = useState(false);
    const [isTicketUpdated, setIsTicketUpdated] = useState(false);
    const [isTicketDeleted, setIsTicketDeleted] = useState(false);

    // 获取所有票
    const fetchTickets = useCallback(async () => {
        setLoading(true);
        setError(null);
        try {
            const data = await TicketService.getAllTickets();
            if (data) setTickets(data);
        } catch (err) {
            setError(err.message || '获取票列表时出错。');
        } finally {
            setLoading(false);
        }
    }, []);

    // 获取单个票
    const fetchTicketById = useCallback(async (ticketId) => {
        setLoading(true);
        setError(null);
        try {
            const data = await TicketService.getTicketById(ticketId);
            if (data) setTicket(data);
        } catch (err) {
            setError(err.message || '获取票信息时出错。');
        } finally {
            setLoading(false);
        }
    }, []);

    // 获取票摘要
    const fetchTicketSummaryById = useCallback(async (ticketId) => {
        setLoading(true);
        setError(null);
        try {
            const data = await TicketService.getTicketSummaryById(ticketId);
            if (data) setTicket(data);
        } catch (err) {
            setError(err.message || '获取票摘要时出错。');
        } finally {
            setLoading(false);
        }
    }, []);

    // 通过参考编号获取票
    const fetchTicketByReferenceNo = useCallback(async (referenceNo) => {
        setLoading(true);
        setError(null);
        try {
            const data = await TicketService.getTicketByReferenceNo(referenceNo);
            if (data) setTicket(data);
        } catch (err) {
            setError(err.message || '通过参考编号获取票时出错。');
        } finally {
            setLoading(false);
        }
    }, []);

    // 通过用户ID获取票
    const fetchTicketsByUserId = useCallback(async (userId) => {
        setLoading(true);
        setError(null);
        try {
            const data = await TicketService.getTicketsByUserId(userId);
            if (data) setTickets(data);
        } catch (err) {
            setError(err.message || '通过用户ID获取票时出错。');
        } finally {
            setLoading(false);
        }
    }, []);

    // 添加票
    const addTicket = useCallback(async (newTicket) => {
        setLoading(true);
        setError(null);
        setIsTicketAdded(false);
        try {
            const success = await TicketService.addTicket(newTicket);
            if (success) {
                setIsTicketAdded(true);
                fetchTickets(); // 添加票后刷新列表
            }
            return success;
        } catch (err) {
            setError(err.message || '添加票时出错。');
            throw err; // 重新抛出以让调用者处理
        } finally {
            setLoading(false);
        }
    }, [fetchTickets]);

    // 更新票通过票ID
    const updateTicketById = useCallback(async (ticketId, updatedTicket) => {
        setLoading(true);
        setError(null);
        setIsTicketUpdated(false);
        try {
            const success = await TicketService.updateTicketById(ticketId, updatedTicket);
            if (success) {
                setIsTicketUpdated(true);
                fetchTickets(); // 更新票后刷新列表
            }
            return success;
        } catch (err) {
            setError(err.message || '更新票时出错。');
            throw err; // 重新抛出以让调用者处理
        } finally {
            setLoading(false);
        }
    }, [fetchTickets]);

    // 更新票通过参考编号
    const updateTicketByReferenceNo = useCallback(async (referenceNo, updatedTicket) => {
        setLoading(true);
        setError(null);
        setIsTicketUpdated(false);
        try {
            const success = await TicketService.updateTicketByReferenceNo(referenceNo, updatedTicket);
            if (success) {
                setIsTicketUpdated(true);
                fetchTickets(); // 更新票后刷新列表
            }
            return success;
        } catch (err) {
            setError(err.message || '通过参考编号更新票时出错。');
            throw err; // 重新抛出以让调用者处理
        } finally {
            setLoading(false);
        }
    }, [fetchTickets]);

    // 删除票通过票ID
    const deleteTicketById = useCallback(async (ticketId) => {
        setLoading(true);
        setError(null);
        setIsTicketDeleted(false);
        try {
            const success = await TicketService.deleteTicketById(ticketId);
            if (success) {
                setIsTicketDeleted(true);
                fetchTickets(); // 删除票后刷新列表
            }
            return success;
        } catch (err) {
            setError(err.message || '删除票时出错。');
            throw err; // 重新抛出以让调用者处理
        } finally {
            setLoading(false);
        }
    }, [fetchTickets]);

    // 删除票通过参考编号
    const deleteTicketByReferenceNo = useCallback(async (referenceNo) => {
        setLoading(true);
        setError(null);
        setIsTicketDeleted(false);
        try {
            const success = await TicketService.deleteTicketByReferenceNo(referenceNo);
            if (success) {
                setIsTicketDeleted(true);
                fetchTickets(); // 删除票后刷新列表
            }
            return success;
        } catch (err) {
            setError(err.message || '通过参考编号删除票时出错。');
            throw err; // 重新抛出以让调用者处理
        } finally {
            setLoading(false);
        }
    }, [fetchTickets]);

    // 挂载时获取所有票
    useEffect(() => {
        fetchTickets();
    }, [fetchTickets]);

    return {
        tickets,
        ticket,
        loading,
        error,
        isTicketAdded,
        isTicketUpdated,
        isTicketDeleted,
        fetchTicketById,
        fetchTicketByReferenceNo,
        fetchTicketSummaryById,
        fetchTicketsByUserId,
        addTicket,
        updateTicketById,
        updateTicketByReferenceNo,
        deleteTicketById,
        deleteTicketByReferenceNo,
    };
};
