import React, { useState, useEffect } from 'react';
import { useLocation } from 'react-router-dom';
import { useReview } from '../../hooks/useReview';

import star from '../../assets/img/star.png'

import Comments from '../../components/Reviews';
import { useMovie } from '../../hooks/useMovie';


function MovieIntroPage() {

    const movieId = useLocation().state.movieId;
    const { movie, fetchMovieById /* loading, error*/ } = useMovie();
    const { reviews, fetchReviewsByTarget, loading, error } = useReview();
    const [movieRate, setMovieRate] = useState(0);


    useEffect(() => {
        fetchMovieById(movieId);
        fetchReviewsByTarget(movieId, 'movies');


    }, [movieId, fetchReviewsByTarget]);


    useEffect(() => {
        if (reviews.length > 0) {
            const totalRating = reviews.reduce((sum, review) => sum + review.rating, 0);
            setMovieRate(totalRating / reviews.length);
        }
    }, [reviews]);


    return (
        <div className='container py-5'>
            <div className="fs-1 fw-bold text-dark mb-3">Movie Information</div>
            <div className='row border'>
                <div className='col-4 d-flex justify-content-center'>
                    <img className='w-75' src={movie?.posterImage} />
                </div>
                <div className='col-8 '>

                    <div className='d-flex fs-5'>
                        <p >Title: </p>
                        <strong className='ms-2'>{movie?.title}</strong>
                    </div>
                    <div className='d-flex fs-5'>
                        <p >Genre: </p>
                        <strong className='ms-2'>{movie?.genre}</strong>
                    </div>

                    <div className='d-flex fs-5'>
                        <p >Duration: </p>
                        <strong className='ms-2'>{movie?.duration}</strong>
                    </div>

                    <div className='d-flex fs-5'>
                        <p >Language: </p>
                        <strong className='ms-2'>{movie?.language}</strong>
                    </div>

                    <div className='d-flex fs-5'>
                        <p >Subtitle: </p>
                        <strong className='ms-2'>{movie?.subtitle}</strong>
                    </div>

                    <div className='d-flex fs-5'>
                        <p >Director: </p>
                        <strong className='ms-2'>{movie?.director}</strong>
                    </div>

                    <div className='d-flex fs-5'>
                        <p >Synopsis: </p>
                        <strong className='ms-2'>{movie?.synopsis}</strong>
                    </div>

                    <div className='d-flex fs-5 align-items-center '>
                        <div className=''>Movie Rate: </div>
                        <strong className='ms-2'>{movieRate.toFixed(1)} </strong>
                        <img src={star} alt="star" width="20" height="20" className="me-1" />
                    </div>
                </div>
            </div>

            <hr className='my-5' />
            <div className="fs-1 fw-bold text-dark mb-3">Movie Trailer</div>
            <div className="container d-flex justify-content-center p-0 ">

                {movie?.trailerLink && (
                    <iframe
                        className='mx-auto w-75'
                        style={{ aspectRatio: '16/9' }}
                        src={movie?.trailerLink.replace("watch?v=", "embed/")}
                        title="YouTube video player"
                        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                        referrerPolicy="strict-origin-when-cross-origin"
                        allowFullScreen
                    ></iframe>
                )}
            </div>

            <hr className='my-5' />


            {loading && <div>Loading...</div>}
            {error ? (
                <div>Error: {error}</div>
            ) : (
                <Comments
                    title={"Recent Comments"}
                    subtitle={`Latest comments for the movie "${movie?.title}"`}
                    reviews={reviews}
                />
            )}



        </div>
    );
}

export default MovieIntroPage;
