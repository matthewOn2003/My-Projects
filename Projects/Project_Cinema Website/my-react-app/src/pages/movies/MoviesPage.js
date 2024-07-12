import React, { useEffect, useState } from 'react';
import { useLocation } from 'react-router-dom';

import DarkNav from '../../components/DarkNav'
import BlackFooter from '../../components/BlackFooter'

import Movies from './Movies'
import DateAndRegion from './DateAndRegion'
import CinemaAndTime from './CinemaAndTime'



function MoviesPage() {

    // sharedState is movie id
    let [movieId, setMovieId] = useState(useLocation().state.movieId);
    let [movieSelected, setMovieSelected] = useState({});
    let [dateSelected, setDateSelected] = useState('');
    let [expSelected, setExpSelected] = useState('');



    useEffect(() => {
        // Check if the page was reloaded
        if (performance.navigation.type === 1) {
            // Scroll to top
            window.scrollTo(0, 0);
        }
    }, []);


    return (
        <div className="MoviesPage">
            <div>movieSelected: {movieSelected.title}</div>
            <Movies
                movieId={movieId}
                setMovieId={setMovieId}
                setMovieSelected={setMovieSelected}
                setDateSelected={setDateSelected}
                setExpSelected={setExpSelected}
            />

            <DateAndRegion
                movieSelected={movieSelected}
                setDateSelected={setDateSelected}
                setExpSelected={setExpSelected}
            />

            {(dateSelected && expSelected) ? (
                <CinemaAndTime
                    movieId={movieId}
                    dateSelected={dateSelected}
                    expSelected={expSelected}
                />
            ) :
                (<div className='text-white fs-3 bg-dark text-center py-5'>
                    - Please Select Date and Experience first -
                </div>)
            }

        </div>
    );
}

export default MoviesPage;





