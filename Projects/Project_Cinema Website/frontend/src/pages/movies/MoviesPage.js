import React, { useEffect, useState } from 'react';
import { useLocation } from 'react-router-dom';

import Movies from './Movies'
import DateOption from './DateOption';
import ExperienceOption from './ExperienceOption';
import CinemaAndTime from './CinemaAndTime'


function MoviesPage() {

    const [stateMovieId, setStateMovieId] = useState(useLocation().state.movieId || 0);
    const [movieId, setMovieId] = useState(localStorage.getItem('selectedMovieId') || 0);
    const [optionState, setOptionState] = useState({
        movieSelected: {},
        dateSelected: '',
        expSelected: ''
    });
    const [optionSelected, setOptionSelected] = useState({
        dateOptionSelected: '',
        expOptionSelected: ''
    });


    useEffect(() => {
        const storedMovieId = localStorage.getItem('selectedMovieId');
        if (optionState.movieSelected?.movieId) {
            setMovieId(optionState.movieSelected.movieId);
            localStorage.setItem('selectedMovieId', optionState.movieSelected?.movieId);

        } else if (storedMovieId) {
            setMovieId(parseInt(storedMovieId));
        }
    }, [optionState.movieSelected]);


    return (
        <div className="py-5">
            <Movies
                stateMovieId={stateMovieId}
                setStateMovieId={setStateMovieId}
                setOptionState={setOptionState}
                setOptionSelected={setOptionSelected}
            />


            <section className="bg-primary">
                <DateOption
                    movieId={movieId}
                    setOptionSelected={setOptionSelected}
                    optionSelected={optionSelected}
                    setOptionState={setOptionState}
                />
            </section>

            <section className="bg-primary mt-5">

                {!optionSelected.dateOptionSelected ||
                    <ExperienceOption
                        movieId={movieId}
                        setOptionState={setOptionState}
                        optionSelected={optionSelected}
                        setOptionSelected={setOptionSelected}
                    />
                }
            </section>

            {(optionSelected.dateOptionSelected && optionSelected.expOptionSelected) ?
                <CinemaAndTime
                    stateMovieId={stateMovieId}
                    optionState={optionState}
                /> :
                <div className='text-primary fs-3 text-center py-5'>
                    - Please Select Date & Experience first -
                </div>
            }

        </div>
    );
}

export default MoviesPage;
