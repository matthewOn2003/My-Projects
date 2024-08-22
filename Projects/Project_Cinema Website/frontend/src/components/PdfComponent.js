import { useLocation } from 'react-router-dom';
import React, { useEffect, useState } from 'react';
import ShowtimeService from '../services/ShowtimeService';


function PdfComponent({ ticket }) {

    const [showtimeId, setShowtimeId] = useState(ticket.order.showtimeId);
    const [shotime, setShowtime] = useState({});

    useEffect(() => {
        ShowtimeService.getShowtimeById(showtimeId).then(showtime => {
            // console.log(showtime);
        });
    }, [showtimeId, shotime]);

    return (
        <div id={`pdf-${ticket.ticketId}`} className=" col-lg-9 col-12 p-2">
            {/* 
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
            </div> */}
        </div>
    );
}

export default PdfComponent;
