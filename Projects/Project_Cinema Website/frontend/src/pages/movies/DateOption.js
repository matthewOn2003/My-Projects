import React, { useEffect, useState } from 'react';
import DateTimeUtils from '../../utils/DateTimeUtils.js';
import ShowtimeService from '../../services/ShowtimeService.js';
import { useShowtime } from '../../hooks/useShowtime.js';

function DateOption({ movieId, setOptionSelected, setOptionState, optionSelected }) { // Add optionSelected as a prop

    const { showtimes, fetchShowtimesByMovieId, loading, error } = useShowtime();
    const [showtimeShowdates, setShowtimeShowdates] = useState([]);


    useEffect(() => {
        fetchShowtimesByMovieId(movieId);
    }, [movieId, fetchShowtimesByMovieId]);


    useEffect(() => {
        const showtimeShowdates = showtimes.reduce((dates, showtime) => {
            const date = showtime?.showDate.split(' ')[0];
            if (!dates.includes(date)) {
                dates.push(date);
            }
            return dates;
        }, []);

        setShowtimeShowdates(showtimeShowdates);
    }, [showtimes]);


    return (
        <div className="container py-3">
            <div className="fs-3 py-3 text-white">- Select Date -</div>
            <ul className="d-flex flex-wrap ps-0 text-center">
                {showtimeShowdates?.map((date, index) => {
                    const dateOption = new DateTimeUtils(date).getDateOption().split('-');

                    return (
                        <li className="list-unstyled me-4" key={index}>
                            <a
                                className={`d-block py-1 px-2 border border-2 border-light rounded-2 text-decoration-none
                                ${optionSelected.dateOptionSelected === date ? 'bg-light' : ''}`}
                                href=""
                                onClick={(event) => {
                                    event.preventDefault();

                                    setOptionSelected(prevState => ({
                                        ...prevState,
                                        dateOptionSelected: date
                                    }));

                                    setOptionState(prevState => ({
                                        ...prevState,
                                        dateSelected: date
                                    }));
                                }}>
                                <div className={`${optionSelected.dateOptionSelected === date ? 'fw-bold text-primary' : 'text-white'}`}>{dateOption[0]}</div>
                                <div className={`${optionSelected.dateOptionSelected === date ? 'fw-bold text-primary' : 'text-white'} fs-4 lh-1 px-1`}>{dateOption[1]}</div>
                                <div className={`${optionSelected.dateOptionSelected === date ? 'fw-bold text-primary' : 'text-white'}`}>{dateOption[2]}</div>
                            </a>
                        </li>
                    );
                })}
            </ul>
        </div>
    );
}

export default DateOption;
