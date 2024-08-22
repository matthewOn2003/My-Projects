import React, { useEffect, useState } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';
import Button from './Button';

function ButtonSwiper({ slides }) {

    const navigate = useNavigate();

    return (
        <div className='container p-0 border my-5'>
            <div id="carouselExample" className="carousel slide">
                <div className="d-flex align-items-center carousel-inner w-75 max-w-75 mx-auto text-white"
                    style={{ aspectRatio: '2/1' }}>


                    <div className="carousel-item fs-1 text-center active">123</div>
                    {slides?.map((slide, slideIndex) => {
                        console.log(slide);
                        return (
                            <div key={slideIndex} className="carousel-item fs-1 text-center w-100 h-100 "
                                style={{
                                    backgroundImage: `url(${slide.slideImage})`,
                                    backgroundSize: 'cover'
                                }}>

                                <div>{slide.slideState.name}</div>
                                <Button
                                    title={slide.slideButtonTitle}
                                    onClick={() => {
                                        console.log(123);
                                        navigate(slide.slideLink, { state: { cinema: slide.slideState } })
                                    }}
                                />
                            </div>
                        )
                    })}
                    {/* <div className="carousel-item fs-1 text-center">222</div> */}


                </div>

                <button className="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
                    <span className="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span className="visually-hidden">Previous</span>
                </button>

                <button className="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
                    <span className="carousel-control-next-icon" aria-hidden="true"></span>
                    <span className="visually-hidden">Next</span>
                </button>
            </div>
        </div>
    );
}

export default ButtonSwiper;
