import { useLocation } from 'react-router-dom';
import React, { useEffect, useState } from 'react';


function Card(props) {


    return (
        <>
            <div className="col-md-6 mb-4">
                <div className="card mb-md-0">
                    <div className="card-body">
                        <p className="mb-4"><span className="text-primary font-italic me-1">assignment</span> Project Status</p>
                        <p className="mb-1" style={{ fontSize: '.77rem' }}>Web Design</p>
                        <div className="progress rounded" style={{ height: '5px' }}>
                            <div className="progress-bar" role="progressbar" style={{ width: '80%' }} aria-valuenow="80" aria-valuemin="0" aria-valuemax="100"></div>
                        </div>
                        <p className="mt-4 mb-1" style={{ fontSize: '.77rem' }}>Website Markup</p>
                        <div className="progress rounded" style={{ height: '5px' }}>
                            <div className="progress-bar" role="progressbar" style={{ width: '72%' }} aria-valuenow="72" aria-valuemin="0" aria-valuemax="100"></div>
                        </div>
                        <p className="mt-4 mb-1" style={{ fontSize: '.77rem' }}>One Page</p>
                        <div className="progress rounded" style={{ height: '5px' }}>
                            <div className="progress-bar" role="progressbar" style={{ width: '89%' }} aria-valuenow="89" aria-valuemin="0" aria-valuemax="100"></div>
                        </div>
                        <p className="mt-4 mb-1" style={{ fontSize: '.77rem' }}>Mobile Template</p>
                        <div className="progress rounded" style={{ height: '5px' }}>
                            <div className="progress-bar" role="progressbar" style={{ width: '55%' }} aria-valuenow="55" aria-valuemin="0" aria-valuemax="100"></div>
                        </div>
                        <p className="mt-4 mb-1" style={{ fontSize: '.77rem' }}>Backend API</p>
                        <div className="progress rounded mb-2" style={{ height: '5px' }}>
                            <div className="progress-bar" role="progressbar" style={{ width: '66%' }} aria-valuenow="66" aria-valuemin="0" aria-valuemax="100"></div>
                        </div>
                    </div>
                </div>
            </div>
        </>
    );
}

export default Card;
