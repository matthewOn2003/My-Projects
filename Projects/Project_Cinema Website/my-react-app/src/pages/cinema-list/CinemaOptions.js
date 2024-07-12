import React, { useEffect, useState } from 'react';
import CinemaTabPane from './CinemaTabPane';
import CinemaTabList from './CinemaTabList';
import CinemaService from '../../services/CinemaService';

function CinemaOptions(props) {
    let [cinemas, setCinemas] = useState([]);
    let [locationSelected, setLocationSelected] = useState('all');
    const locations = [];

    const fetchCinemas = () => {
        CinemaService.getAllCinemas().then(cinemas => {
            setCinemas(cinemas);
        }).catch(error => {
            console.error('Error fetching cinemas:', error);
        });
    };

    if (cinemas.length > 0) {
        for (let index = 0; index < cinemas.length; index++) {
            const cinema = cinemas[index];
            if (!locations.includes(cinema.city)) {
                locations.push(cinema.city);
            }
        }
    }

    useEffect(() => {
        fetchCinemas();
    }, []);

    return (
        <div className='CinemaOptions'>
            <div className="container px-0 py-5 fs-6">
                <div className="fs-1 fw-bold text-white">Cinemas</div>
                <CinemaTabList
                    locationSelected={locationSelected}
                    setLocationSelected={setLocationSelected}
                    locations={locations}
                />
                <CinemaTabPane
                    cinemas={cinemas}
                    location={locationSelected}
                />
            </div>
        </div>
    );
}

export default CinemaOptions;
