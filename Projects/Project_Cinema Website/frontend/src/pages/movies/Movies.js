import React, { useEffect, useState } from 'react';
import { Swiper, SwiperSlide } from 'swiper/react';
import 'swiper/swiper-bundle.css';
import './Movies.css'

import { useMovie } from '../../hooks/useMovie';

function Movies({ stateMovieId, setStateMovieId, setOptionState, setOptionSelected }) {

    const { movies, loading, error } = useMovie();
    const [activeIndex, setActiveIndex] = useState(-1);

    useEffect(() => {
        if (movies.length > 0) {
            console.log('haha', stateMovieId);
            const index = movies.findIndex(movie => movie.movieId === stateMovieId);
            if (index !== -1) {
                console.log(index);
                setActiveIndex(index);
                setOptionState(prevState => ({
                    ...prevState,
                    movieSelected: movies[index]
                }));
                setStateMovieId(movies[index].movieId);
            }
        }
    }, [movies, stateMovieId]);


    console.log('aa', activeIndex);

    return (
        <>
            {loading && <div >Loading...</div>}
            {error ? (
                <div >Error: {error}</div>
            ) : (
                <div className="movies my-5">
                    <div className="container">
                        <div className="fs-1 fw-bold text-dark mb-3">Movies</div>
                        <div className='' style={{ aspectRatio: '3/1' }}>
                            <Swiper
                                className="mySwiper p-0"
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
                                initialSlide={+activeIndex}
                                onSlideChange={(swiper) => {
                                    setActiveIndex(swiper.activeIndex);
                                    setOptionState(prevState => ({
                                        ...prevState,
                                        movieSelected: movies[swiper.activeIndex],
                                        dateSelected: '',
                                        expSelected: ''
                                    }));

                                    setOptionSelected(prevState => ({
                                        ...prevState,
                                        dateOptionSelected: '',
                                        expOptionSelected: ''
                                    }));

                                    setStateMovieId(movies[swiper.activeIndex].movieId);
                                }}
                            >
                                {movies.map((movie, index) => (
                                    <SwiperSlide key={index} >
                                        <div className='border border-2 border-dark ' >
                                            <img src={movie.posterImage} alt={movie.title} />
                                        </div>
                                    </SwiperSlide>
                                ))}
                            </Swiper>
                        </div>
                    </div>

                </div>
            )}

        </>

    );

}

export default Movies;
