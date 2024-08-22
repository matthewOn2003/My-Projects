
import React, { useEffect, useState } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';
import Button from '../../components/Button';
import ItemDetail from '../../components/ItemDetail';
import { useAuth } from '../../hooks/useAuth';

import OrderService from '../../services/OrderService';


function PaymentPage() {
    const navigate = useNavigate();
    const { showtime, selectedFood, selectedSeats } = useLocation().state;
    const { movie, cinema, hall } = showtime;
    const { user } = useAuth();


    const selectedSeatNumbers = selectedSeats.map(seat => seat.seatNumber).join(', ');
    const aggregatedFoods = selectedFood.reduce((acc, food) => { //since no async function, so no useMemo
        const foundFood = acc.find(item => item.foodId === food.foodId);
        if (foundFood) {
            foundFood.quantity += 1;
        } else {
            acc.push({ ...food, quantity: 1 });
        }
        return acc;
    }, []);
    const totalPrice = (aggregatedFoods.reduce((total, food) =>
        total + parseFloat(food.price) * food.quantity, 0)
        + selectedSeats.reduce((total, seat) =>
            total + parseFloat(seat.price), 0)).toFixed(2);


    // on click
    const insertOrder = async () => {

        const orderData = {
            userId: user.userId,
            showtimeId: showtime.showtimeId,
            totalAmount: totalPrice,
            foods: selectedFood,
            seats: selectedSeats
        };
        console.log('order Data: ', orderData);

        navigate('/secret/tng-page', { state: { orderData: orderData } });
    }


    return (
        <div className="pt-5 ">
            <div className="container py-4 d-flex flex-wrap justify-content-between px-0 pb-5"
                style={{ minHeight: '350px' }}>
                <div className="col-lg-3 col-12 p-3">
                    <div
                        className='border border-2 border-dark'
                        style={{
                            backgroundImage: `url(${movie.posterImage})`,
                            backgroundSize: 'cover',
                            backgroundPosition: 'center',
                            backgroundRepeat: 'no-repeat',
                            aspectRatio: '2/3'
                        }}>
                    </div>
                </div>

                <div className="col-lg-9 col-12 p-2">
                    <div className="border-bottom border-2 border-dark">
                        <div className="mb-4 row mx-0">
                            <div className="col-6">
                                <div className="fs-5 fw-bold">{movie.title}</div>
                                <div>{movie.language} | {movie.duration} | {hall.experienceType}</div>
                            </div>
                        </div>

                        <div className="mb-4 row mx-0">
                            <div className="col-6">
                                <div className="">Cinema</div>
                                <div className="fw-bold">{cinema.city} - {cinema.name}</div>
                            </div>
                            <div className="col-6">
                                <div className="">Hall</div>
                                <div className="fw-bold">{hall.hallName}</div>
                            </div>
                        </div>

                        <div className="mb-4 row mx-0">
                            <div className="col-6">
                                <div className="">Time</div>
                                <div className="fw-bold">{showtime.startTime}</div>
                            </div>
                            <div className="col-6">
                                <div className="">Seats</div>
                                <div className="fw-bold">{selectedSeatNumbers}</div>
                            </div>
                        </div>
                    </div>

                    <div className="py-2">
                        <div className="d-flex justify-content-between row m-0 py-3">
                            <h5 className="fw-bold">Food</h5>
                            {aggregatedFoods.map((food, foodIndex) => (
                                <ItemDetail
                                    itemIndex={foodIndex}
                                    itemDescription={`${food.name} x ${food.quantity}`}
                                    itemAmount={`RM ${parseFloat(food.price * food.quantity).toFixed(2)}`} />
                            ))}
                        </div>

                        <div className="d-flex justify-content-between row m-0 py-3">
                            <h5 className="fw-bold">Seat</h5>
                            {selectedSeats.map((seat, seatIndex) => (
                                <ItemDetail
                                    itemIndex={seatIndex}
                                    itemDescription={`Adult x 1`}
                                    itemAmount={`RM ${seat.price}`} />
                            ))}
                        </div>
                    </div>
                    <div
                        className="d-flex justify-content-between row py-3 mx-0 border-top border-bottom border-dark fw-bold ">
                        <span className="col-10">Total:</span>
                        <span className="col-2 text-end">RM {totalPrice}</span>
                    </div>

                    <div className='d-flex justify-content-center my-5'>
                        <Button buttonTitle={"Pay With Touch n Go"} buttonOnClick={insertOrder} />
                    </div>



                </div>
            </div>
        </div>
    );
}

export default PaymentPage;


