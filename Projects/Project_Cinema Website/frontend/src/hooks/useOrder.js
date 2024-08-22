import { useState, useEffect, useCallback } from 'react';
import OrderService from '../services/OrderService';

export const useOrder = () => {
    const [orders, setOrders] = useState([]);
    const [order, setOrder] = useState(null);
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState(null);
    const [isOrderAdded, setIsOrderAdded] = useState(false);
    const [isOrderUpdated, setIsOrderUpdated] = useState(false);
    const [isOrderDeleted, setIsOrderDeleted] = useState(false);

    // 获取所有订单
    const fetchOrders = useCallback(async () => {
        setLoading(true);
        setError(null);
        try {
            const data = await OrderService.getAllOrders();
            if (data) setOrders(data);
        } catch (err) {
            setError(err.message || '获取订单列表时出错。');
        } finally {
            setLoading(false);
        }
    }, []);

    // 获取单个订单
    const fetchOrderById = useCallback(async (orderId) => {
        setLoading(true);
        setError(null);
        try {
            const data = await OrderService.getOrderById(orderId);
            if (data) setOrder(data);
        } catch (err) {
            setError(err.message || '获取订单信息时出错。');
        } finally {
            setLoading(false);
        }
    }, []);

    // 获取订单通过订单号
    const fetchOrderByOrderNumber = useCallback(async (orderNumber) => {
        setLoading(true);
        setError(null);
        try {
            const data = await OrderService.getOrderByOrderNumber(orderNumber);
            if (data) setOrder(data);
        } catch (err) {
            setError(err.message || '通过订单号获取订单信息时出错。');
        } finally {
            setLoading(false);
        }
    }, []);

    // 添加订单
    const addOrder = useCallback(async (newOrder) => {
        setLoading(true);
        setError(null);
        setIsOrderAdded(false);
        try {
            const success = await OrderService.addOrder(newOrder);
            if (success) {
                setIsOrderAdded(true);
                fetchOrders(); // 添加订单后刷新列表
            }
            return success;
        } catch (err) {
            setError(err.message || '添加订单时出错。');
            throw err; // 重新抛出以让调用者处理
        } finally {
            setLoading(false);
        }
    }, [fetchOrders]);

    // 更新订单
    const updateOrder = useCallback(async (orderId, updatedOrder) => {
        setLoading(true);
        setError(null);
        setIsOrderUpdated(false);
        try {
            const success = await OrderService.updateOrder(orderId, updatedOrder);
            if (success) {
                setIsOrderUpdated(true);
                fetchOrders(); // 更新订单后刷新列表
            }
            return success;
        } catch (err) {
            setError(err.message || '更新订单时出错。');
            throw err; // 重新抛出以让调用者处理
        } finally {
            setLoading(false);
        }
    }, [fetchOrders]);

    // 删除订单
    const deleteOrder = useCallback(async (orderId) => {
        setLoading(true);
        setError(null);
        setIsOrderDeleted(false);
        try {
            const success = await OrderService.deleteOrder(orderId);
            if (success) {
                setIsOrderDeleted(true);
                fetchOrders(); // 删除订单后刷新列表
            }
            return success;
        } catch (err) {
            setError(err.message || '删除订单时出错。');
            throw err; // 重新抛出以让调用者处理
        } finally {
            setLoading(false);
        }
    }, [fetchOrders]);

    // 挂载时获取所有订单
    useEffect(() => {
        fetchOrders();
    }, [fetchOrders]);

    return {
        orders,
        order,
        loading,
        error,
        isOrderAdded,
        isOrderUpdated,
        isOrderDeleted,
        fetchOrderById,
        fetchOrderByOrderNumber,
        addOrder,
        updateOrder,
        deleteOrder,
    };
};
