import { useState, useEffect, useCallback } from 'react';
import ReviewService from '../services/ReviewService';

export const useReview = () => {
    const [reviews, setReviews] = useState([]);
    const [review, setReview] = useState(null);
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState(null);
    const [isReviewAdded, setIsReviewAdded] = useState(false);
    const [isReviewUpdated, setIsReviewUpdated] = useState(false);
    const [isReviewDeleted, setIsReviewDeleted] = useState(false);


    // 获取所有评论
    const fetchReviews = useCallback(async () => {
        console.log('fetchReviewssss');
        setLoading(true);
        setError(null);
        try {
            const data = await ReviewService.getAllReviews();
            if (data) setReviews(data);
        } catch (err) {
            setError(err.message || '获取评论列表时出错。');
        } finally {
            setLoading(false);
        }
    }, []);


    // 获取单个评论
    const fetchReviewById = useCallback(async (reviewId) => {
        setLoading(true);
        setError(null);
        try {
            const data = await ReviewService.getReviewById(reviewId);
            if (data) setReview(data);
        } catch (err) {
            setError(err.message || '获取评论信息时出错。');
        } finally {
            setLoading(false);
        }
    }, []);


    // 获取评论通过目标ID和目标表
    const fetchReviewsByTarget = useCallback(async (targetId, targetTable) => {
        setLoading(true);
        setError(null);
        try {
            const data = await ReviewService.getReviewsByTarget(targetId, targetTable);
            if (data) {
                setReviews(data);
            } // This sets the reviews state correctly
        } catch (err) {
            setError(err.message || 'Error fetching reviews by target.');
        } finally {
            setLoading(false);
        }
    }, []);


    // 获取评论通过用户ID
    const fetchReviewsByUser = useCallback(async (userId) => {
        setLoading(true);
        setError(null);
        try {
            const data = await ReviewService.getReviewsByUser(userId);
            if (data) setReviews(data);
        } catch (err) {
            setError(err.message || '获取用户评论信息时出错。');
        } finally {
            setLoading(false);
        }
    }, []);


    // 添加评论
    const addReview = useCallback(async (newReview) => {
        setLoading(true);
        setError(null);
        setIsReviewAdded(false);
        try {
            const success = await ReviewService.addReview(newReview);
            if (success) {
                setIsReviewAdded(true);
                fetchReviews(); // 添加评论后刷新列表
            }
            return success;
        } catch (err) {
            setError(err.message || '添加评论时出错。');
            throw err; // 重新抛出以让调用者处理
        } finally {
            setLoading(false);
        }
    }, [fetchReviews]);


    // 更新评论
    const updateReviewById = useCallback(async (reviewId, updatedReview) => {
        setLoading(true);
        setError(null);
        setIsReviewUpdated(false);
        try {
            const success = await ReviewService.updateReviewById(reviewId, updatedReview);
            if (success) {
                setIsReviewUpdated(true);
                fetchReviews(); // 更新评论后刷新列表
            }
            return success;
        } catch (err) {
            setError(err.message || '更新评论时出错。');
            throw err; // 重新抛出以让调用者处理
        } finally {
            setLoading(false);
        }
    }, [fetchReviews]);


    // 删除评论
    const deleteReviewById = useCallback(async (reviewId) => {
        setLoading(true);
        setError(null);
        setIsReviewDeleted(false);
        try {
            const success = await ReviewService.deleteReviewById(reviewId);
            if (success) {
                setIsReviewDeleted(true);
                fetchReviews(); // 删除评论后刷新列表
            }
            return success;
        } catch (err) {
            setError(err.message || '删除评论时出错。');
            throw err; // 重新抛出以让调用者处理
        } finally {
            setLoading(false);
        }
    }, [fetchReviews]);


    return {
        reviews,
        review,
        loading,
        error,
        isReviewAdded,
        isReviewUpdated,
        isReviewDeleted,
        fetchReviews,
        fetchReviewById,
        fetchReviewsByTarget,
        fetchReviewsByUser,
        addReview,
        updateReviewById,
        deleteReviewById,
    };
};
