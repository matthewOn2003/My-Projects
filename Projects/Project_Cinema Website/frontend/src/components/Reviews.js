import { React, useState, useEffect } from 'react';
import './Reviews.css'

import star from '../assets/img/star.png'
import { useMovie } from '../hooks/useMovie';
import { useNavigate } from 'react-router-dom';

function Reviews({ title, subtitle, reviews }) {

    const navigate = useNavigate();

    const renderStars = (rating) => {
        const stars = [];
        for (let i = 0; i < rating; i++) {
            stars.push(<img key={i} src={star} alt="star" width="20" height="20" className="me-1" />);
        }
        return stars;
    }

    return (
        <div className="container d-flex justify-content-center p-0 ">
            <div className="py-2 w-100">

                {!(title || subtitle) || <div className="card-title p-4 pb-0 ">
                    <h3 className="m-0 ">{title}</h3>
                    <p className="pt-3">{subtitle}</p>
                </div>}

                {reviews.map((review, reviewIndex) => {
                    return (
                        <div
                            key={reviewIndex}
                            className="review-card mx-2 py-3 px-4 mb-4 rounded rounded-3 ">
                            <div className="d-flex flex-start ">
                                <img
                                    className="rounded-circle shadow-1-strong me-3 border border-dark"
                                    src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava3.webp"
                                    alt="avatar" width="60"
                                    height="60" />

                                <div className='w-100 position-relative'>
                                    <div className='row'>
                                        <span className="col-6 fw-bold mb-1">{review.userDTO.fullName}</span>
                                        <i className='col-6'>
                                            {review.targetTable === "movies" ? "Movie" : "Cinema"}: &nbsp;
                                            {review.targetName}

                                        </i>
                                    </div>
                                    <div className="d-flex align-items-center justify-content-between mb-1 ">
                                        <div>{renderStars(review.rating)}</div>
                                        <i className=''>{review.reviewDate}</i>
                                    </div>
                                    <p className="mb-0 w-100 "> {review.reviewText} </p>
                                    <a
                                        className="position-absolute bottom-0 end-0 hover-item"
                                        href='/secret/movie-intro-page'
                                        onClick={e => {
                                            e.preventDefault();

                                            if (review.targetTable === 'movies') {
                                                navigate('/secret/movie-intro-page', { state: { movieId: review.targetId } })
                                            } else {
                                                navigate('/secret/cinema-intro-page', { state: { cinemaId: review.targetId } })
                                            }

                                        }}>
                                        {review.targetId} - View More
                                    </a>

                                </div>
                            </div>
                        </div>
                    )
                })}
            </div>
        </div>
    );
}

export default Reviews;
