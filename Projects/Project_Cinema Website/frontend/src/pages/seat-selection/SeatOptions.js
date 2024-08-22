import React, { useState } from 'react';

import screen from '../../assets/img/screen.png'

import selected from '../../assets/img/selected.png';
import available from '../../assets/img/available.png';
import booked from '../../assets/img/booked.png';
import blocked from '../../assets/img/blocked.png';


function SeatOptions({ seats, selectedSeats, setSelectedSeats }) {

    const handleSeatClick = (seat) => {
        setSelectedSeats(prevSelectedSeats => {
            const seatIndex = prevSelectedSeats.findIndex(selectedSeat => selectedSeat.seatId === seat.seatId);

            if (seatIndex !== -1) {
                // Seat is already selected, so remove it
                const updatedSeats = [...prevSelectedSeats];
                updatedSeats.splice(seatIndex, 1);
                return updatedSeats.sort((a, b) => a.seatId - b.seatId); // Sort by seatId
            } else {
                // Seat is not selected, so add it
                const newSeats = [...prevSelectedSeats, seat];
                return newSeats.sort((a, b) => a.seatId - b.seatId); // Sort by seatId
            }
        });
    };

    const renderSeats = (row) => {
        return seats
            .filter(seat => seat.seatRow === row)
            .map(seat => (
                <span
                    key={seat.seatId}
                    className={`d-inline-block mx-1 text-center`}
                    style={{
                        height: '40px', width: '40px', position: 'relative',
                        display: 'inline-flex', alignItems: 'center', justifyContent: 'center'
                    }}
                >
                    {seat.status === 'AVAILABLE' ? (
                        <button
                            className={`border-0 p-0 m-0 rounded-5 
                                    ${selectedSeats.some(selectedSeat => selectedSeat.seatId === seat.seatId)
                                    ? 'bg-warning text-dark fw-bold'
                                    : 'bg-light text-dark'}`}
                            style={{
                                height: '100%', // Fill parent height
                                width: '100%', // Fill parent width
                                cursor: 'pointer',
                                backgroundColor: 'transparent',
                                color: 'inherit',
                                border: 'none',
                                display: 'flex',
                                alignItems: 'center',
                                justifyContent: 'center'
                            }}
                            onClick={() => handleSeatClick(seat)}>
                            {seat.seatNumber}
                        </button>
                    ) : (
                        <img
                            className="d-inline-block"
                            src={seat.status === 'BOOKED' ? booked : blocked}
                            alt={seat.status}
                            style={{ height: '100%', width: '100%', objectFit: 'cover' }}
                        />
                    )}
                </span>
            ));
    };


    const uniqueRows = [...new Set(seats.map(seat => seat.seatRow))];

    const renderSeatInfo = () => {
        return (
            <div className="d-flex mx-auto justify-content-center px-4">
                <span className="border border-4 rounded-3 border-white p-3 mx-3 fs-5 text-white">
                    <img className="d-inline-block me-3 rounded-5 bg-light " src={selected} alt="Available" height="40px" width="40px" />
                    <span>Selected</span>
                </span>
                <span className="border border-4 rounded-3 border-white p-3 mx-3 fs-5 text-white">
                    <img className="d-inline-block me-3 rounded-5 bg-light " src={available} alt="Available" height="40px" width="40px" />
                    <span>Available</span>
                </span>
                <span className="border border-4 rounded-3 border-white p-3 mx-3 fs-5 text-white">
                    <img className="d-inline-block me-3 rounded-5 bg-light p-2" src={booked} alt="Booked" height="40px" width="40px" />
                    <span>Booked</span>
                </span>
                <span className="border border-4 rounded-3 border-white p-3 mx-3 fs-5 text-white">
                    <img className="d-inline-block me-3 rounded-5 bg-light p-2" src={blocked} alt="Blocked" height="40px" width="40px" />
                    <span>Blocked</span>
                </span>
            </div>
        );
    };

    return (
        <div className="">
            <section style={{ backgroundColor: '#003a8c', minHeight: '630px' }}>
                <div className="container p-5 ">
                    <div className='d-flex justify-content-center align-items-center'>
                        <img src={screen} />
                    </div>

                    <div className="py-4 text-white d-flex justify-content-center">
                        <div className=''>
                            {uniqueRows.map(row => (
                                <div
                                    key={row}
                                    className="d-flex justify-content-between mx-auto my-4 px-5 align-items-center">
                                    <span className="me-5 ">{row}</span>
                                    <span className=''>
                                        {renderSeats(row)}
                                    </span>
                                    <span className="ms-5">{row}</span>
                                </div>
                            ))}
                        </div>
                    </div>

                    {renderSeatInfo()}
                </div>
            </section>
        </div>
    );
}

export default SeatOptions;
