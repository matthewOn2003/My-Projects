import React, { useState, useEffect } from 'react';

//
import genre from '../../assets/img/genre_logo.png'
import duration from '../../assets/img/duration_logo.png'
import language from '../../assets/img/language_logo.png'
import subtitle from '../../assets/img/subtitle_logo.png'


//
import BuyNowButton from './BuyNowButton';
import MovieService from '../../services/MovieService';



//
const info_logos = [
    { logoUrl: genre, logoName: 'genre' },
    { logoUrl: duration, logoName: 'duration' },
    { logoUrl: language, logoName: 'language' },
    { logoUrl: subtitle, logoName: 'subtitle' }
];


//
let movies = [];

const MovieTabPane = (props) => {
    const [movies, setMovies] = useState([]);

    useEffect(() => {
        fetchMovies();
    }, []);


    // [] -> [...movies]
    const fetchMovies = () => {
        MovieService.getAllMovies().then(movieList => {
            setMovies(movieList); // Update state with fetched movieList
        }).catch(error => {
            console.error('Error fetching movies:', error);
        });
    };


    //
    const renderMovies = () => {

        return (
            <ul className="d-flex justify-content-between flex-wrap px-0">
                {movies.map((movie, index) => (
                    <li
                        className="list-unstyled border d-flex my-3"
                        style={{
                            height: '399px',
                            width: '266px',
                            backgroundImage: `url(${movie.posterImage})`,
                            backgroundSize: 'contain',
                            backgroundPosition: 'center',
                            backgroundRepeat: 'no-repeat'
                        }} key={index}>
                        <div
                            className="h-100 w-100 d-flex flex-column p-4"
                            style={{ backgroundColor: 'rgba(0,0,0,0.6)' }}>

                            <a
                                className="fs-5 fw-bold d-flex align-items-center text-white text-decoration-none"
                                href="/"
                            >
                                <span className="d-inline-block border border-3 rounded-5 text-center"
                                    style={{ width: '30px', height: '30px', lineHeight: '22px' }}>i</span>
                                <span className="ms-2">View More</span>
                            </a>

                            <div>
                                <h4 className="mt-4">[{movie.movieId}] {movie.title} </h4>

                                {info_logos.map((logo, index) => (
                                    <div className="d-flex align-items-center fs-6 py-1 " key={index}>
                                        <img
                                            className='d-inine-block me-1'
                                            src={logo.logoUrl}
                                            style={{ width: '20px', height: '20px' }}></img>
                                        <span className="ms-1"> {movie[logo.logoName]} </span>
                                    </div>
                                ))}

                                {movie.tickets_sold}


                            </div>
                            <BuyNowButton movieId={movie.movieId} />
                        </div>
                    </li>
                ))}
            </ul>

        )

    }




    //
    return (
        <div className="tab-content text-white" id="myTabContent">


            {/* Now Showing */}
            <div className="tab-pane fade show active" id="now-showing-tab-pane" role="tabpanel"
                aria-labelledby="now-showing-tab" tabIndex="0">
                <div>
                    <div className="py-2 my-3">
                        <span className="border border-3 border-warning rounded-3 px-5 py-2 fs-5">Now Showing</span>
                    </div>
                    {renderMovies('#now-showing-tab-pane')}
                </div>
            </div>

            {/* advanced sales (ticket sold order by tickets, need sql) */}
            <div className="tab-pane fade show " id="advanced-sales-tab-pane" role="tabpanel"
                aria-labelledby="advanced-sales-tab" tabIndex="0">
                <div>
                    <div className="py-2 my-3">
                        <span className="border border-3 border-warning rounded-3 px-5 py-2 fs-5">Advanced Sales</span>
                    </div>
                    {renderMovies('#advanced-sales-tab-pane')}
                </div>
            </div>



            {/* coming soon (realease_date > current date, need sql) */}
            <div className="tab-pane fade show " id="coming-soon-tab-pane" role="tabpanel"
                aria-labelledby="coming-soon-tab" tabIndex="0">
                <div>
                    <div className="py-2 my-3">
                        <span className="border border-3 border-warning rounded-3 px-5 py-2 fs-5">Coming Soon</span>
                    </div>
                    {renderMovies('#coming-soon-tab-pane')}
                </div>
            </div>


        </div>
    );
};

// 


export default MovieTabPane;
