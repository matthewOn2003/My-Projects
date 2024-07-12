import React, { useEffect } from 'react';
import { Navigate, Outlet } from 'react-router-dom';
import { useAuth } from '../hooks/useAuth';
import UserService from '../services/UserService';

export const ProtectedRoute = () => {
    const { user, setUser } = useAuth();
    console.log('this is protected page');

    // in case not login
    if (!user) {
        alert('Please Login to Access This Page!!');
        // Redirect to login page if user is not authenticated
        return <Navigate to="/login-page" />;
    }
    // change status to active means user active now
    let updatedUser = user;
    updatedUser.status = 'ACTIVE';
    setUser(updatedUser);
    UserService.updateUserStatus(user.userId, 'ACTIVE');

    console.log('current user: ', user);

    return <Outlet />; // Render child routes if user is authenticated
};