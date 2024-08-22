import React, { useEffect, useState } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';
import { useSeat } from '../../hooks/useSeat';

import SeatSelected from './SeatSelected';
import MovieInfo from '../../components/MovieInfo';
import SeatOptions from './SeatOptions';
import ItemSelectedPane from '../../components/ItemSelectedPane';


function SeatSelectionPage() {

    const showtime = useLocation().state.showtime;
    const navigate = useNavigate();
    const { seats, fetchSeatsByHallId, loading, error } = useSeat();

    const [selectedSeats, setSelectedSeats] = useState([]);
    const selectedSeatNumbers = selectedSeats.map(seat => seat.seatNumber).join(', ');


    useEffect(() => {
        fetchSeatsByHallId(showtime.hall.hallId);
    }, [showtime, fetchSeatsByHallId]);


    const buttonOnClick = (e) => {
        e.preventDefault();
        if ((showtime === null) || !(selectedSeats.length > 0)) {
            alert('please select atleast 1 seat!!');
            return;
        }
        navigate('/secret/food-selection-page', {
            state: {
                showtime: showtime,
                selectedSeats: selectedSeats
            }
        });
    };


    return (
        <div className="SeatSelectionPage py-5">


            <MovieInfo showtime={showtime} />

            {loading && <div>Loading...</div>}
            {error ? (<div>Error: {error}</div>)
                : (
                    <SeatOptions
                        seats={seats}
                        selectedSeats={selectedSeats}
                        setSelectedSeats={setSelectedSeats} />
                )}

            <ItemSelectedPane
                title={"Seat Selection"}
                itemsDesc={(selectedSeats.length > 0) ? selectedSeatNumbers : '- Please Select Seats -'}
                buttonTitle={`Confirm - ${selectedSeats.length} ticket (s)`}
                buttonOnClick={buttonOnClick} />
        </div>
    );
}

export default SeatSelectionPage;
