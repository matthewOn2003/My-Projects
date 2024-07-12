import React, { useEffect, useState } from 'react';
import { useLocation } from 'react-router-dom';

import DarkNav from '../../components/DarkNav'
import BlackFooter from '../../components/BlackFooter'

import SeatSelected from './SeatSelected';
import MovieInfo from './MovieInfo';
import SeatOptions from './SeatOptions';

import SeatService from '../../services/SeatService'

function SeatSelectionPage() {

    //
    const state = useLocation().state;
    const showtime = state.showtime;

    //
    let [seats, setSeats] = useState([]);
    let [selectedSeats, setSelectedSeats] = useState([]);


    const fetchSeats = async () => {
        try {
            const seats = await SeatService.getSeatsByHallId(showtime.hall.hallId);
            setSeats(seats);
        } catch (error) {
            console.error('Error fetching showtimes:', error);
        }
    };

    useEffect(() => {
        window.scrollTo(0, 0);
        fetchSeats();
    }, [])


    return (
        <div className="SeatSelectionPage" style={{ backgroundColor: 'black' }}>
            <SeatSelected
                showtime={showtime}
                selectedSeats={selectedSeats} />
            <MovieInfo
                showtime={showtime} />
            <SeatOptions
                seats={seats}
                selectedSeats={selectedSeats}
                setSelectedSeats={setSelectedSeats} />
        </div>
    );

}

export default SeatSelectionPage;
