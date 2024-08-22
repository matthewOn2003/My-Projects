import React from 'react';
import { Outlet, useLocation } from 'react-router-dom';
// import BlackFooter from './BlackFooter';
// import DarkNav from './DarkNav';

import Navbar01 from './Navbar01';
import Footer01 from './Footer01';

import 'bootstrap/dist/css/bootstrap.min.css'; // Import Bootstrap CSS
import 'bootstrap/dist/js/bootstrap.bundle.min.js';


const Layout = () => {
    const location = useLocation();
    const { pathname } = location;

    // Check if current path is login page or error page
    const isLoginPage = pathname === '/login-page';
    const isRegisterPage = pathname === '/register-page';
    const isNoPage = pathname.startsWith('/no-page'); // Update with actual path

    // Render layout with navigation and footer for all pages except login and error pages
    if (isLoginPage || isRegisterPage || isNoPage) {
        return (
            <Outlet />
        );
    }

    // Render layout with navigation and footer for all other pages
    return (
        <>
            <Navbar01 />
            <Outlet />
            <Footer01 />
        </>
    );
};

export default Layout;