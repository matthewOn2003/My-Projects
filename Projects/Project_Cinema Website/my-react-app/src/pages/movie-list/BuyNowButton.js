import React from 'react';
import { useNavigate } from 'react-router-dom';

const BuyNowButton = (props) => {

    const navigate = useNavigate();

    const handleClick = (e) => {
        e.preventDefault();
        navigate('/movies-page', { state: { movieId: props.movieId } });

    };

    return (
        <div className="mt-auto mx-auto">
            <button
                className="btn btn-warning btn-lg fw-bold px-5"
                onClick={handleClick}>
                Buy Now
            </button>
        </div>
    );
};

export default BuyNowButton;
