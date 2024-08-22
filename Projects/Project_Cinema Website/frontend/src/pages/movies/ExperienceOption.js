import React, { useEffect, useState } from 'react';
import { useShowtime } from '../../hooks/useShowtime.js';
import ShowtimeService from '../../services/ShowtimeService.js';

function ExperienceOption({ movieId, setOptionState, optionSelected, setOptionSelected }) {

    const { experiences, fetchShowtimesExperiences, loading, error } = useShowtime();


    useEffect(() => {
        fetchShowtimesExperiences(movieId, optionSelected.dateOptionSelected);
    }, [movieId, optionSelected.dateOptionSelected, fetchShowtimesExperiences]);


    const onClickExperience = (e, exp) => {
        e.preventDefault();

        setOptionSelected(prevState => ({
            ...prevState,
            expOptionSelected: exp
        }));

        setOptionState(prevState => ({
            ...prevState,
            expSelected: exp
        }));
    };


    return (
        <div className="container py-3">
            <div className="fs-3 py-3 text-white">- Select Experience -</div>
            <ul className="d-flex ps-0 text-center">
                {experiences?.map((exp, index) => (
                    <li key={index} className="list-unstyled me-3">
                        <a
                            className={`d-block py-1 px-3 border border-2 border-light rounded-2 text-decoration-none 
                            ${optionSelected.expOptionSelected === exp ? 'bg-light text-primary fw-bold' : 'text-light'}`}
                            href=""
                            style={{ height: '55px', width: '110px' }}
                            onClick={e => onClickExperience(e, exp)}>
                            {exp}
                        </a>
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default ExperienceOption;
