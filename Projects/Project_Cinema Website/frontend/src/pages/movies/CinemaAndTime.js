import React, { useEffect, useState } from 'react';
import DateTimeUtils from "../../utils/DateTimeUtils";
import { useNavigate } from 'react-router-dom';
import { useShowtime } from '../../hooks/useShowtime';

import minus from '../../assets/img/minus.png';
import './CinemaAndTime.css'; // Assuming your CSS is in this file

function CinemaAndTime({ stateMovieId, optionState }) {

    const dateSelected = optionState.dateSelected;
    const expSelected = optionState.expSelected;

    const navigate = useNavigate();
    const { showtimes, fetchShowtimesByMovieDateExperience, loading, error } = useShowtime();
    const [uniqueCinemas, setUniqueCinemas] = useState([]);

    useEffect(() => {
        fetchShowtimesByMovieDateExperience(stateMovieId, dateSelected, expSelected);
    }, [stateMovieId, dateSelected, expSelected, fetchShowtimesByMovieDateExperience]);

    useEffect(() => {
        const uniqueCinemas = Array.from(new Set(showtimes.map(showtime => showtime.cinema.cinemaId)))
            .map(cinemaId => showtimes.find(showtime => showtime.cinema.cinemaId === cinemaId));
        setUniqueCinemas(uniqueCinemas);
    }, [showtimes]);

    const renderScreenings = (showtime) => {
        const date_only = showtime.showDate.split(' ')[0];
        const exp = showtime.hall.experienceType;
        if (!(date_only === dateSelected && exp === expSelected)) {
            return;
        }

        const datetime = new DateTimeUtils(showtime.showDate);
        const time = datetime.getTime().split(':');
        const hour = parseInt(time[0], 10);
        const period = hour >= 12 ? 'PM' : 'AM';
        const formattedHour = hour % 12 || 12;
        const timeStr = `${formattedHour}:${time[1]} ${period}`;

        return (
            <li key={showtime.showtimeId} className="list-unstyled me-5">
                <a
                    className="screening-link d-block py-1 px-2 border border-2 border-primary rounded-2 text-decoration-none"
                    href="/secret/seat-selection-page"
                    onClick={(e) => {
                        e.preventDefault();
                        navigate('/secret/seat-selection-page', {
                            state: {
                                showtime: showtime
                            }
                        });
                    }}
                    style={{ width: '128px' }}>
                    <div className="fs-6 py-2">{timeStr}</div>
                    <div className='line m-0 '></div>
                    <div className="fs-6 py-2 ">{exp}</div>
                </a>
            </li>
        );
    };

    return (
        <div className="CinemaAndTime">
            <section className="py-4">
                <div className="container">
                    <div className="fs-3 py-3 text-primary fw-bold">- Select Cinema -</div>
                    <ul className="ps-0">
                        {uniqueCinemas?.map((uniqueCinema, uniqueCinemaIndex) => (
                            <li className="list-unstyled border-5 border border-primary bg-primary rounded-3 mb-4 text-light" key={uniqueCinemaIndex}>
                                <div
                                    className="fs-5 fw-bold px-4 py-3 d-flex justify-content-between text-decoration-none"
                                    type="button"
                                    data-bs-toggle="collapse"
                                    data-bs-target={`#cinema-${uniqueCinemaIndex}`}
                                    aria-expanded="false"
                                    aria-controls={`cinema-${uniqueCinemaIndex}`}>
                                    <span>{uniqueCinema.cinema.name}</span>
                                    <span className="fw-bold">
                                        <img src={minus} height="16px" alt="minus" />
                                    </span>
                                </div>

                                <div
                                    className="collapse collapse-horizontal"
                                    id={`cinema-${uniqueCinemaIndex}`}>
                                    <ul
                                        className="d-flex flex-row flex-wrap text-center fw-bold px-5 py-4 card card-body">
                                        {showtimes
                                            .filter(showtime => showtime.cinema.cinemaId === uniqueCinema.cinema.cinemaId)
                                            .map(showtime => renderScreenings(showtime))}
                                    </ul>
                                </div>
                            </li>
                        ))}
                    </ul>
                </div>
            </section>
        </div>
    );
}

export default CinemaAndTime;
