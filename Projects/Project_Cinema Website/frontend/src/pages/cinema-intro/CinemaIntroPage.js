import React, { useEffect, useState } from 'react';
import { useLocation } from 'react-router-dom';

import Comments from '../../components/Reviews';
import ButtonSwiper from '../../components/ButtonSwiper';
import { useCinema } from '../../hooks/useCinema';
import { useReview } from '../../hooks/useReview';

import star from '../../assets/img/star.png'


function CinemaIntroPage() {
    // get the cinema clicked
    const cinemaId = useLocation().state.cinemaId;
    const { cinema, fetchCinemaById, cinemas, fetchCinemas } = useCinema();
    const { reviews, fetchReviewsByTarget } = useReview();

    const [cinemaRate, setCinemaRate] = useState(0);
    const [slides, setSlides] = useState([]);

    useEffect(() => {

        fetchCinemaById(cinemaId);
        fetchCinemas();
        fetchReviewsByTarget(cinemaId, 'cinemas');

        // window.scrollTo(0, 0);

    }, [cinemaId, cinema, cinemas, reviews, fetchCinemaById, fetchCinemas, fetchReviewsByTarget]);


    useEffect(() => {

        if (cinemas.length > 0) {
            const slides = cinemas.map((cinema) => {
                return {
                    slideButtonTitle: 'View More',
                    slideImage: cinema?.cinemaImage,
                    slideLink: '/secret/cinema-intro-page',
                    slideState: cinema
                };
            });
            setSlides(slides);

            const totalRating = reviews.reduce((sum, review) => sum + review.rating, 0);
            setCinemaRate(totalRating / reviews.length);
        }

    }, [cinemas, reviews]);




    return (
        <div className="container py-5">

            {/* Cinema Info */}
            <div className="fs-1 fw-bold text-dark mb-3">Cinema Information</div>
            <div className='px-5 mb-5'>
                <div
                    className='w-50 mx-auto border border-2 -dark'
                    style={{
                        backgroundImage: `url(${cinema?.cinemaImage})`,
                        backgroundSize: 'cover',
                        backgroundPosition: 'center',
                        backgroundRepeat: 'no-repeat',
                        aspectRatio: '16/9'
                    }}
                ></div>


                <h3 className='my-3 text-center'>{cinema?.name}</h3>
                <div className='row'>
                    <div className='col-6  p-3'>
                        <div className='mb-5'>
                            <h4 className='fw-bold'>Location</h4>
                            <p>{cinema?.city}</p>
                        </div>

                        <div className='mb-5'>
                            <h4 className='fw-bold'>Rating</h4>
                            <div className='d-flex fs-5 align-items-center '>
                                <strong className='ms-2 '>{cinemaRate.toFixed(1)} </strong>
                                <img className="me-1 " src={star} alt="star" width="20" height="20" />
                            </div>
                        </div>

                    </div>

                    <div className='col-6 p-3'>
                        <div className='mb-5'>
                            <h4 className='fw-bold'>Address</h4>
                            <p>{cinema?.address} </p>
                        </div>

                        <div className='mb-5'>
                            <h4 className='fw-bold'>Contact No</h4>
                            <p>{cinema?.contactNo}</p>
                        </div>

                    </div>


                </div>
            </div>

            <hr />

            <div className="fs-1 fw-bold text-dark mb-3">Cinema Location</div>
            <div className=' fs-5 d-flex mb-5 px-5'>
                {/* <CinemaMap /> */}
                <iframe
                    className='mx-auto w-50'
                    style={{ aspectRatio: '1/1' }}
                    src={cinema?.locationLink}
                    allowfullscreen=""
                    loading="lazy"
                    referrerpolicy="no-referrer-when-downgrade">

                </iframe>
            </div>

            <hr />


            <Comments
                title={"Recent Comments"}
                subtitle={`latest comment for the cinema "${cinema?.name}"`}
                reviews={reviews}
            />

            {/* <hr /> */}

            {/* <OtherCinemas /> */}
            {/* <ButtonSwiper slides={slides} /> */}

        </div >
    );
}

export default CinemaIntroPage;

