import React, { useEffect, useState } from 'react';
import html2canvas from 'html2canvas';
import jsPDF from 'jspdf';
import Button from '../../components/Button';

import ReviewService from '../../services/ReviewService';
import Reviews from '../../components/Reviews';


function ReviewsPane({ user }) {

    const [reviews, setReviews] = useState([]);

    useEffect(() => {
        ReviewService.getReviewsByUser(user.userId).then(reviews => {
            setReviews(reviews);
        }).catch(error => {
            console.log('Error fetching reviews: ', error)
        });
    }, [])

    console.log(reviews);


    return (
        <div id='tickets-tab-pane' className="row">
            <h2 className='text-center my-4'>Reviews</h2>
            <Reviews reviews={reviews} />

        </div>
    );
}

export default ReviewsPane;
