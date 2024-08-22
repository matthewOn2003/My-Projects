import { useLocation } from 'react-router-dom';
import React, { useEffect, useState } from 'react';


function MovieInfo({ showtime }) {

    const movie = showtime.movie;
    const hall = showtime.hall;
    const cinema = showtime.cinema;

    return (
        <div className="MovieInfo container-fluid bg-light text-dark d-flex flex-wrap justify-content-between px-0 "
            style={{ minHeight: '300px' }}>

            <div className="col-lg-3 col-12 d-flex align-items-center justify-content-end ">
                <img className='border border-2 border-dark' src={movie.posterImage}
                    style={{ height: '250px' }} />
            </div>

            <div className="col-lg-9 col-12 px-4 d-flex align-items-center fs-5">
                <div className="">

                    <div className="mb-4 mx-0">
                        <div className="fs-3 fw-bold">{movie.title}</div>
                        <div className='fs-6'> {movie.language} | {movie.duration} | {hall.experienceType}</div>
                    </div>

                    <div className="mb-3 mx-0 d-flex align-items-center">
                        {cinema.city} - {cinema.name}
                    </div>

                    <div className="mb-3 mx-0 d-flex align-items-center">
                        {hall.hallName}
                    </div>

                    <div className="mx-0 d-flex align-items-center">
                        {showtime.showDate}
                    </div>
                </div>
            </div>
        </div>
    );
}

export default MovieInfo;
