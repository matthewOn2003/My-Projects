import React, { useEffect, useState } from 'react';
import { Swiper, SwiperSlide } from 'swiper/react';
import 'swiper/swiper-bundle.css';
import './Movies.css'

//
import MovieService from '../../services/MovieService';

//
function Movies(props) {

    let [movies, setMovies] = useState([]);
    let [activeIndex, setActiveIndex] = useState(-1); //



    useEffect(() => {
        fetchMovies();
    }, []);


    // get index depends on movieId
    useEffect(() => {
        if (movies.length > 0) {
            const index = movies.findIndex(movie => movie.movieId === props.movieId);
            if (index !== -1) {
                setActiveIndex(index);
                props.setMovieSelected(movies[index]);
                props.setMovieId(movies[index].movieId)
            }
        }
    }, [movies, props.movieId]);


    // [] -> [...movies]
    const fetchMovies = () => {
        MovieService.getAllMovies().then(movieList => {
            setMovies(movieList); // Update state with fetched movieList
        }).catch(error => {
            console.error('Error fetching movies:', error);
        });
    };






    if ((movies.length > 0) && (activeIndex !== -1)) {

        return (
            <div className="Movies">
                <span className='me-5'>current movie id:{movies[activeIndex].movieId}</span>
                <span>current movie index:{activeIndex}</span>

                <section style={{ height: '500px', backgroundColor: 'black' }}>
                    <div className="container ">
                        <div className="fs-1 fw-bold text-white">Movies</div>

                        <Swiper
                            className="mySwiper"

                            effect="coverflow"
                            grabCursor={true}
                            centeredSlides={true}
                            slidesPerView="auto"
                            coverflowEffect={{
                                rotate: 50,
                                stretch: 0,
                                depth: 100,
                                modifier: 1,
                                slideShadows: true
                            }}
                            pagination={{ el: '.swiper-pagination' }}
                            initialSlide={activeIndex} // put index
                            onSlideChange={(swiper) => {
                                setActiveIndex(swiper.activeIndex);
                                props.setMovieSelected(movies[swiper.activeIndex]);
                                props.setMovieId(movies[swiper.activeIndex].movieId);
                                props.setDateSelected([]); // prevent date error
                                props.setExpSelected(''); // prevent date error
                            }}
                        >
                            {movies.map((movie, index) => (
                                <SwiperSlide key={index}>
                                    <img src={movie.posterImage} alt={movie.title} />
                                    <div className='text-white'>{`movieId=${movie.movieId}`}</div>
                                </SwiperSlide>
                            ))}


                        </Swiper>


                    </div>
                </section>
            </div>
        );
    }


}

export default Movies;
