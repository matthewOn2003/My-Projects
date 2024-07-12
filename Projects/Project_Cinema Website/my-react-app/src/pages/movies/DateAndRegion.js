import React, { useEffect, useState } from 'react';
import ShowtimeService from '../../services/ShowtimeService.js';

import DateTimeUtils from '../../utils/DateTimeUtils.js';



function DateAndRegion(props) {

    let [showtimes, setShowtimes] = useState([]);
    let [movieId, setMovieId] = useState(localStorage.getItem('selectedMovieId'));
    let [dateOptionSelected, setDateOptionSelected] = useState('');
    let [experiences, setExperiences] = useState([]);


    useEffect(() => {
        // Retrieve movieId from localStorage if available
        const storedMovieId = localStorage.getItem('selectedMovieId');
        if (!props.movieSelected?.movieId) {
            setMovieId(parseInt(storedMovieId));
        } else {
            setMovieId(props.movieSelected?.movieId);
            localStorage.setItem('selectedMovieId', props.movieSelected?.movieId);
        }
    }, [props.movieSelected]);


    useEffect(() => {
        fetchShowtimes();
    }, [movieId]);


    useEffect(() => {
        if (dateOptionSelected) {
            fetchExperiences(dateOptionSelected);
        }
    }, [dateOptionSelected, movieId]);



    const fetchShowtimes = async () => {
        try {
            const showtimes = await ShowtimeService.getShowtimesByMovieId(movieId);
            setShowtimes(showtimes);
        } catch (error) {
            console.error('Error fetching showtimes:', error);
        }
    };

    const fetchExperiences = async (showDate) => {
        try {
            const experiences = await ShowtimeService.getShowtimesExperiences(movieId, showDate);
            setExperiences(experiences);
        } catch (error) {
            console.error('Error fetching experiences:', error);
        }
    };


    // 
    let showtime_showdates = [];
    // let showtime_experiences = [];



    for (let i = 0; i < showtimes.length; i++) {
        // const date = new DateTimeUtils(showtimes[i].showDate);
        if (!showtime_showdates?.includes(showtimes[i]?.showDate.split(' ')[0])) {
            showtime_showdates?.push(showtimes[i]?.showDate.split(' ')[0]);
        }
    }



    // const hall_ids = showtimes
    const renderExperience = (setExpSelected) => {

        const wawa = false;

        if (true) {
            return (
                <>
                    {experiences?.map((exp, index) => {
                        return (
                            <li key={index} className="list-unstyled me-3">
                                <a
                                    className="d-block py-1 px-3 border border-1 border-white
                                            rounded-2 text-decoration-none text-white"
                                    href=""
                                    style={{ height: '55px', width: '110px' }}
                                    onClick={(event) => {
                                        event.preventDefault();
                                        setExpSelected(exp);
                                    }}>
                                    {exp}
                                </a>
                            </li>
                        );
                    })}
                </>
            );
        }
    }


    return (
        <div className="DateAndRegion">
            <section id="select-date" className="bg-dark text-white py-4">
                <div className="container py-3">
                    <div className="fs-5 py-3">Select Date</div>

                    <ul className="d-flex flex-wrap ps-0 text-center">
                        {showtime_showdates.map((date, index) => {
                            const date_option = new DateTimeUtils(date).getDateOption().split('-');
                            const dow = date_option[0];
                            const dom = date_option[1];
                            const month = date_option[2];

                            return (
                                <li className="list-unstyled me-3" key={`${index}`}>
                                    <a
                                        className="d-block py-1 px-2 border border-1 border-white rounded-2 text-decoration-none"
                                        href=""
                                        onClick={(event) => {
                                            event.preventDefault();
                                            setDateOptionSelected(date);
                                            props.setDateSelected(date);
                                        }}>
                                        <div className="text-white">{dow}</div>
                                        <div className="text-white fs-4 fw-bold lh-1 px-1">{dom}</div>
                                        <div className="text-warning">{month}</div>
                                    </a>
                                </li>
                            );
                        })}
                    </ul>
                </div>

                <div className="container py-3">
                    <div className="fs-5 py-3">Select Experience</div>

                    <ul className="d-flex ps-0 text-center">
                        {renderExperience(props.setExpSelected)}
                    </ul>
                </div>
            </section>
        </div>
    );
}



export default DateAndRegion;
