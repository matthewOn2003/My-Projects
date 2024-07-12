import React from 'react';
import { Outlet, Link } from 'react-router-dom';
import BlackFooter from './components/BlackFooter';
import DarkNav from './components/DarkNav';

const Layout = () => {
    return (
        <>
            {/* <DarkNav /> */}
            {/* <nav>
                <ul>
                    <li>
                        <Link to="/">main-page</Link>
                    </li>
                    <li>
                        <Link to="/food-selection-page">food-selection-page</Link>
                    </li>
                    <li>
                        <Link to="/movie-list-page">movie-list-page</Link>
                    </li>
                    <li>
                        <Link to="/movies-page">movies-page</Link>
                    </li>
                    <li>
                        <Link to="/payment-page">payment-page</Link>
                    </li>
                    <li>
                        <Link to="/promotion-list-page">promotion-list-page</Link>
                    </li>
                    <li>
                        <Link to="/seat-selection-page">seat-selection-page</Link>
                    </li>
                    <li>
                        <Link to="/ticket-confirm-page">ticket-confirm-page</Link>
                    </li>
                    <li>
                        <Link to="/about-us-page">about-us-page</Link>
                    </li>
                    <li>
                        <Link to="/admin-page">admin-page</Link>
                    </li>
                    <li>
                        <Link to="/auth-page">auth-page</Link>
                    </li>
                    <li>
                        <Link to="/cinema-intro-page">cinema-intro-page</Link>
                    </li>
                    <li>
                        <Link to="/cinema-list-page">cinema-list-page</Link>
                    </li>
                    <li>
                        <Link to="/experience-intro-page">experience-intro-page</Link>
                    </li>
                    <li>
                        <Link to="/experience-list-page">experience-list-page</Link>
                    </li>
                    <li>
                        <Link to="/movie-intro-page">movie-intro-page</Link>
                    </li>
                    <li>
                        <Link to="/promotion-intro-page">promotion-intro-page</Link>
                    </li>
                </ul>
            </nav> */}

            <Outlet />
            {/* <BlackFooter /> */}
        </>
    );
};

export default Layout;
