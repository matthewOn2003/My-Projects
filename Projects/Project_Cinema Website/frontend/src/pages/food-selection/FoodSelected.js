import React from 'react';
import { useNavigate } from 'react-router-dom';


function FoodSelected(props) {
    const navigate = useNavigate();

    const showtime = props.showtime;
    const selectedSeats = props.selectedSeats;
    const foodsChosen = props.foodsChosen;

    // Calculate the total price
    const totalPrice = foodsChosen.reduce((total, food) => total + parseFloat(food.price), 0).toFixed(2);

    return (
        <div className="FoodSelected">
            <div className="d-flex flex-row justify-content-between align-items-center rounded-top-5 
                bg-dark fixed-bottom px-5 py-4 w-75 mx-auto">
                <div className="ms-2 fs-5 text-white">
                    Total - <strong>{foodsChosen.length} items</strong>
                </div>

                <a className="btn btn-primary btn-lg btn-block 
                    rounded-3 me-2 px-5 py-3 bg-warning border-0 text-dark text-decoration-none"
                    href="/secret/payment-page"
                    onClick={(e) => {
                        e.preventDefault();

                        if ((showtime === null) || !(selectedSeats.length > 0)) {
                            alert('error!!');
                            return;
                        }
                        navigate('/secret/payment-page', {
                            state: {
                                showtime: showtime,
                                selectedSeats: selectedSeats,
                                foodsChosen: foodsChosen
                            }
                        });
                    }}>
                    <strong>RM {totalPrice}</strong>
                </a>
            </div>
        </div>
    );
}

export default FoodSelected;
