import { useState, useEffect, useCallback } from 'react';
import MovieService from '../services/MovieService';

export const useMovie = () => {
    const [movies, setMovies] = useState([]);
    const [movie, setMovie] = useState(null);
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState(null);
    const [isMovieAdded, setIsMovieAdded] = useState(false);
    const [isMovieUpdated, setIsMovieUpdated] = useState(false);
    const [isMovieDeleted, setIsMovieDeleted] = useState(false);

    // 获取所有电影
    const fetchMovies = useCallback(async () => {
        setLoading(true);
        setError(null);
        try {
            const data = await MovieService.getAllMovies();
            if (data) setMovies(data);
        } catch (err) {
            setError(err.message || '获取电影列表时出错。');
        } finally {
            setLoading(false);
        }
    }, []);

    // 获取单个电影
    const fetchMovieById = useCallback(async (movieId) => {
        setLoading(true);
        setError(null);
        try {
            const data = await MovieService.getMovieById(movieId);
            if (data) setMovie(data);
        } catch (err) {
            setError(err.message || '获取电影信息时出错。');
        } finally {
            setLoading(false);
        }
    }, []);

    // 添加电影
    const addMovie = useCallback(async (newMovie) => {
        setLoading(true);
        setError(null);
        setIsMovieAdded(false);
        try {
            const success = await MovieService.addMovie(newMovie);
            if (success) {
                setIsMovieAdded(true);
                fetchMovies(); // 添加电影后刷新列表
            }
            return success;
        } catch (err) {
            setError(err.message || '添加电影时出错。');
            throw err; // 重新抛出以让调用者处理
        } finally {
            setLoading(false);
        }
    }, [fetchMovies]);

    // 更新电影
    const updateMovieById = useCallback(async (movieId, updatedMovie) => {
        setLoading(true);
        setError(null);
        setIsMovieUpdated(false);
        try {
            const success = await MovieService.updateMovieById(movieId, updatedMovie);
            if (success) {
                setIsMovieUpdated(true);
                fetchMovies(); // 更新电影后刷新列表
            }
            return success;
        } catch (err) {
            setError(err.message || '更新电影时出错。');
            throw err; // 重新抛出以让调用者处理
        } finally {
            setLoading(false);
        }
    }, [fetchMovies]);

    // 删除电影
    const deleteMovieById = useCallback(async (movieId) => {
        setLoading(true);
        setError(null);
        setIsMovieDeleted(false);
        try {
            const success = await MovieService.deleteMovieById(movieId);
            if (success) {
                setIsMovieDeleted(true);
                fetchMovies(); // 删除电影后刷新列表
            }
            return success;
        } catch (err) {
            setError(err.message || '删除电影时出错。');
            throw err; // 重新抛出以让调用者处理
        } finally {
            setLoading(false);
        }
    }, [fetchMovies]);

    // 挂载时获取所有电影
    useEffect(() => {
        fetchMovies();
    }, [fetchMovies]);

    return {
        movies,
        movie,
        loading,
        error,
        isMovieAdded,
        isMovieUpdated,
        isMovieDeleted,
        fetchMovieById,
        addMovie,
        updateMovieById,
        deleteMovieById,
    };
};
