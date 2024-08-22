import React from "react";
import profile from '../assets/img/profile.png'
import ssc_logo from '../assets/img/ssc_logo.png'

import { useAuth } from "../hooks/useAuth";

import '../components/Navbar01.css'

function Navbar01() {

    const { logout } = useAuth();

    const handleLogout = () => {
        logout();
    };

    return (
        <nav className="fixed-top navbar navbar-expand-md bg-primary p-1 ">
            <div className="container ">
                <a className="navbar-brand " href="#">
                    <img className="rounded-3" src={ssc_logo} height='32px' />
                </a>

                {/* the button will only show at phone size */}
                <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
                    aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>

                {/* the things show */}
                {/* Collapsible navbar content */}
                <div className="collapse navbar-collapse" id="navbarNavDropdown">
                    <ul className="d-flex align-items-center navbar-nav ms-auto w-75"> {/* Ensure ms-auto to align right */}
                        <li className="nav-item px-4">
                            <a className="nav-link text-white active" aria-current="page" href="/secret/movie-list-page">Movies</a>
                        </li>
                        <li className="nav-item px-4">
                            <a className="nav-link text-white" href="/secret/cinema-list-page">Cinemas</a>
                        </li>
                        <li className="nav-item px-4">
                            <a className="nav-link text-white" href="/secret/about-us-page">About Us</a>
                        </li>
                    </ul>
                </div>

                <div className="dropdown ms-auto">
                    <a className="nav-link dropdown-toggle text-white" href="/secret/movie-list-page" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        <img src={profile} width="32px" alt="Profile" />
                    </a>
                    <ul className="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdownMenuLink">
                        <li><a className="dropdown-item" href="/secret/profile-page">Profile Page</a></li>
                        <li><a className="dropdown-item" href="/secret/profile-page">Tickets</a></li>
                        <li><a className="dropdown-item" href="#" onClick={e => {
                            e.preventDefault();
                            handleLogout();
                        }}>Log Out</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    )
}

export default Navbar01