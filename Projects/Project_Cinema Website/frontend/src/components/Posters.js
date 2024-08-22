import React, { useEffect, useState } from 'react';
import Button from './Button';
import './Posters.css';


function Posters({ posters, infoLogos, viewMoreOnClick, buttonOnClick }) {

    return (
        <ul className="d-flex flex-row flex-wrap px-0">
            {posters.map((poster, index) => (
                <li
                    key={index}
                    className="list-unstyled d-flex my-0 col-4 col-lg-3 col-md-4 col-sm-6 col-6 p-3">
                    <div
                        className="h-100 w-100 d-flex flex-column shadow-lg"
                        style={{
                            backgroundImage: `url(${poster.posterImage})`,
                            backgroundSize: 'cover',
                            backgroundPosition: 'center',
                            backgroundRepeat: 'no-repeat',
                            aspectRatio: '2/3'
                        }} >

                        <div className='hover-item h-100 flex-column p-4 ' style={{ backgroundColor: 'rgba(0,0,0,0.7)' }}>
                            <a className="fs-5 fw-bold d-flex align-items-center text-white text-decoration-none"
                                href="/"
                                onClick={e => viewMoreOnClick(e, poster)}>
                                <span className="d-inline-block border border-3 rounded-5 text-center"
                                    style={{ width: '30px', height: '30px', lineHeight: '22px' }}>i</span>
                                <span className="ms-2">
                                    View More
                                </span>
                            </a>

                            <div >
                                <h4 className="mt-4"> {poster.title} </h4>

                                {infoLogos.map((logo, index) => (
                                    <div className="d-flex align-items-center fs-6 py-1 " key={index}>
                                        <img
                                            className='d-inine-block me-1'
                                            src={logo.logoUrl}
                                            style={{ width: '20px', height: '20px' }}></img>
                                        <span className="ms-1"> {poster[logo.logoName]} </span>
                                    </div>
                                ))}

                            </div>

                            <div className="mt-auto mx-auto">
                                <Button
                                    buttonTitle={"Buy Now"}
                                    buttonOnClick={e => buttonOnClick(e, poster)} />
                            </div>
                        </div>

                    </div>
                </li>
            ))}
        </ul>
    );
}

export default Posters;
