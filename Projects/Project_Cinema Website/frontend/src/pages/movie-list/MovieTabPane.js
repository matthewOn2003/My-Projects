import React, { useState, useEffect } from 'react';
import { useNavigate, useLocation } from 'react-router-dom';

//
import genre from '../../assets/img/genre_logo.png'
import duration from '../../assets/img/duration_logo.png'
import language from '../../assets/img/language_logo.png'
import subtitle from '../../assets/img/subtitle_logo.png'


//
import Posters from '../../components/Posters';
import { useMovie } from '../../hooks/useMovie';



function MovieTabPane() {

    // const [movies, setMovies] = useState([]);
    const { movies, loading, error } = useMovie();
    const navigate = useNavigate();

    const infoLogos = [
        { logoUrl: genre, logoName: 'genre' },
        { logoUrl: duration, logoName: 'duration' },
        { logoUrl: language, logoName: 'language' },
        { logoUrl: subtitle, logoName: 'subtitle' }
    ];

    const viewMoreOnClick = (e, poster) => {
        e.preventDefault();
        navigate('/secret/movie-intro-page', { state: { movieId: poster.movieId } });
    }

    const buttonOnClick = (e, poster) => {
        e.preventDefault();
        navigate('/secret/movies-page', { state: { movieId: poster.movieId } });
    }

    //
    return (
        <div className="tab-content text-white" id="myTabContent">

            {loading && <div>Loading...</div>}
            {error ? (
                <div>Error: {error}</div>
            ) : (
                <Posters
                    posters={movies}
                    infoLogos={infoLogos}
                    viewMoreOnClick={viewMoreOnClick}
                    buttonOnClick={buttonOnClick} />
            )}

        </div>
    );
};


export default MovieTabPane;



{/* <div className="py-2 my-3">
    <span className="border border-3 border-warning rounded-3 px-5 py-2 fs-5">Now Showing</span>
</div> */}