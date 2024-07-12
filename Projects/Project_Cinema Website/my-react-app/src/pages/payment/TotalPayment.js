import React from 'react';
import { useLocation } from 'react-router-dom';

import OrderService from '../../services/OrderService'

function TotalPayment(props) {
    const state = useLocation().state;
    const showtime = state.showtime;

    const movie = showtime.movie;
    const cinema = showtime.cinema;
    const hall = showtime.hall;

    const foodsChosen = state.foodsChosen;
    const selectedSeats = state.selectedSeats;

    const selectedSeatNumbers = selectedSeats.map(seat => seat.seatNumber).join(', ');


    // Aggregate foodsChosen to count quantities
    const aggregatedFoods = foodsChosen.reduce((acc, food) => {
        const foundFood = acc.find(item => item.foodId === food.foodId);
        if (foundFood) {
            foundFood.quantity += 1;
        } else {
            acc.push({ ...food, quantity: 1 });
        }
        return acc;
    }, []);


    // Calculate the total price
    const totalFoodPrice = aggregatedFoods.reduce((total, food) =>
        total + parseFloat(food.price) * food.quantity, 0);

    // Calculate total seat price
    const totalSeatPrice = selectedSeats.reduce((total, seat) =>
        total + parseFloat(seat.price), 0);

    // Calculate total price
    const totalPrice = (totalFoodPrice + totalSeatPrice).toFixed(2);


    const handleConfirm = async () => {
        const orderData = {
            userId: 5,
            showtimeId: showtime.showtimeId,
            totalAmount: totalPrice,
            foods: foodsChosen,
            seats: selectedSeats
        };

        console.log(orderData);

        try {
            const response = await OrderService.addOrder(orderData);
            if (response) {
                console.log('Order added successfully:', response);
            } else {
                console.log('Failed to add order');
            }
        } catch (error) {
            console.error('Error adding order:', error);
        }
    };


    return (
        <div className="TotalPayment">
            <div className="container text-white py-4 d-flex flex-wrap justify-content-between px-0 pb-5"
                style={{ minHeight: '350px' }}>
                <div className="col-lg-3 col-12 d-flex justify-content-center ">
                    <img className='border' src={movie.posterImage}
                        style={{ width: '80%', height: 'fit-content' }} />
                </div>

                <div className="col-lg-9 col-12">

                    <div className="border-bottom border-primary">
                        <div className="mb-4 row mx-0">
                            <div className="col-6">
                                <div className="fs-5 fw-bold">{movie.title}</div>
                                <div>{movie.language} | {movie.duration} | {hall.experienceType}</div>
                            </div>
                        </div>

                        <div className="mb-4 row mx-0">
                            <div className="col-6">
                                <div className="text-light">Cinema</div>
                                <div className="fw-bold">{cinema.city} - {cinema.name}</div>
                            </div>
                            <div className="col-6">
                                <div className="text-light">Hall</div>
                                <div className="fw-bold">{hall.hallName}</div>
                            </div>
                        </div>

                        <div className="mb-4 row mx-0">
                            <div className="col-6">
                                <div className="text-light">Time</div>
                                <div className="fw-bold">{showtime.startTime}</div>
                            </div>
                            <div className="col-6">
                                <div className="text-light">Seats</div>
                                <div className="fw-bold">{selectedSeatNumbers}</div>
                            </div>
                        </div>
                    </div>

                    <div className="py-2">
                        <div className="d-flex justify-content-between row m-0 py-3">
                            <div className="text-light fw-bold">Food</div>
                            {aggregatedFoods.map((food, foodIndex) => (
                                <div key={foodIndex} className="d-flex justify-content-between my-2">
                                    <span className="col-10">
                                        {food.name} x {food.quantity}
                                    </span>

                                    <span className="px-0 text-end">
                                        RM {parseFloat(food.price * food.quantity).toFixed(2)}
                                    </span>
                                </div>
                            ))}
                        </div>


                        <div className="d-flex justify-content-between row m-0 py-3">
                            <div className="text-light fw-bold">Seat</div>
                            {selectedSeats.map((seat, seatIndex) => (
                                <div key={seatIndex} className="d-flex justify-content-between my-2">
                                    <span className="col-10">
                                        Adult x 1
                                    </span>

                                    <span className="px-0 text-end">
                                        RM {seat.price}
                                    </span>
                                </div>
                            ))}
                        </div>


                    </div>

                    <div
                        className="d-flex justify-content-between row py-3 mx-0 border-top border-bottom border-warning fw-bold text-warning">
                        <span className="col-10">Total:</span>
                        <span className="col-2 text-end">RM {totalPrice}</span>
                    </div>

                    <button onClick={() => {
                        handleConfirm();
                    }}>Okay</button>
                </div>
            </div>
        </div>
    );
}

export default TotalPayment;
