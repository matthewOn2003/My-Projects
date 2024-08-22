import React, { useEffect, useState } from 'react';
import html2canvas from 'html2canvas';
import jsPDF from 'jspdf';
import Button from '../../components/Button';
import { useAuth } from '../../hooks/useAuth';
import TicketService from '../../services/TicketService';
import TicketsPane from './TicketsPane';
import ReviewsPane from './ReviewsPane';
import FormInput from '../../components/FormInput';
import UserInfo from './UserInfo';

const ProfilePage = () => {

    const { user, setUser } = useAuth();
    const [tabName, setTabName] = useState('user-info');

    return (
        <div className="container py-5 mt-5">
            <div className="row">
                <div className="col-lg-4">
                    <div className="card mb-4">
                        <div className="card-body text-center">
                            <img
                                src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava3.webp"
                                alt="avatar"
                                className="rounded-circle img-fluid"
                                style={{ width: '150px' }}
                            />
                            <h5 className="my-3">{user.fullName}</h5>
                            <p className="text-muted mb-1">@{user.username}</p>
                            <p className="text-muted mb-4">{user.role === 'ADMIN' ? 'Admin' : 'Stellar Sight Cinema User'}</p>
                        </div>
                    </div>
                    <div className="card mb-4 mb-lg-0">
                        <ul className="navbar-nav mr-auto px-3">
                            <li className="nav-item d-flex justify-content-center align-items-center p-2">
                                <a className="nav-link mb-0"
                                    href="#"
                                    onClick={() => { setTabName('user-info') }}
                                >User Info
                                </a>
                            </li>
                            <hr className='m-0 p-0' />

                            <li className="nav-item d-flex justify-content-center align-items-center p-2">
                                <a className="nav-link mb-0"
                                    href="#"
                                    onClick={() => { setTabName('tickets-purchased') }}>
                                    Tickets Purchased
                                </a>
                            </li>
                            <hr className='m-0 p-0' />

                            <li className="nav-item d-flex justify-content-center align-items-center p-2">
                                <a className="nav-link mb-0"
                                    href="#"
                                    onClick={() => { setTabName('reviews-posted') }}>
                                    Posted Reviews
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>

                <div className="col-lg-8">
                    {tabName === 'user-info' && <UserInfo user={user} setUser={setUser} />}
                    {tabName === 'tickets-purchased' && <TicketsPane user={user} />}
                    {tabName === 'reviews-posted' && <ReviewsPane user={user} />}



                </div>
            </div>
        </div>
    );
};

export default ProfilePage;


// username fullName phoneNumber birthDate  

