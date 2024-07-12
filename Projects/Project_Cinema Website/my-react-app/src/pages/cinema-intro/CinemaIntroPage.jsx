import React, { useEffect, useState } from 'react';
import { useLocation } from 'react-router-dom';

import CinemaPicture from './CinemaPicture';
import CinemaInfo from './CinemaInfo';
import CinemaMap from './CinemaMap';
import OtherCinemas from './OtherCinemas';

import CinemaService from '../../services/CinemaService';
import HallService from '../../services/HallService';


function CinemaIntroPage() {
    // get the cinema clicked
    const location = useLocation();
    const cinema = location.state.cinema;
    console.log(cinema);

    let [halls, setHalls] = useState([]);


    const fetchHalls = (async) => {
        HallService.getHallsByCinemaId(cinema.cinemaId).then(halls => {
            setHalls(halls);
        }).catch(error => {
            console.error('Error fetching halls:', error);
        });
    }

    useEffect(() => {
        fetchHalls();
    }, [])

    console.log(halls);




    return (
        <div style={{ backgroundColor: 'black' }} className="CinemaIntroPage">
            <div className='container text-white '>
                <CinemaPicture cinema={cinema} />

                <div className='border fs-5 d-flex'>
                    <CinemaInfo cinema={cinema} halls={halls} />
                    <CinemaMap />
                </div>
            </div>

            <OtherCinemas />
        </div >
    );
}

export default CinemaIntroPage;

