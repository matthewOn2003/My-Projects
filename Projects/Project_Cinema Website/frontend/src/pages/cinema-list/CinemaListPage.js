import React, { useEffect, useState } from 'react';
import CinemaTabPane from './CinemaTabPane';
import CinemaTabList from './CinemaTabList';
import { useCinema } from '../../hooks/useCinema';

function CinemaListPage() {

    const { cinemas, fetchCinemas, loading, error } = useCinema();
    const [locationSelected, setLocationSelected] = useState('all');
    const [locations, setLocations] = useState([]);


    useEffect(() => {
        fetchCinemas();
    }, [fetchCinemas]);


    useEffect(() => {
        if (cinemas.length > 0) {
            for (let index = 0; index < cinemas.length; index++) {
                const cinema = cinemas[index];
                if (!locations.includes(cinema.city)) {
                    locations.push(cinema.city);
                }
            }
            setLocations(locations);
        }
    }, [cinemas])


    return (
        <div className='pt-5'>
            <div className="container px-0 py-5 fs-6">
                <div className="fs-1 fw-bold ">Cinemas</div>
                {loading && <div>Loading...</div>}
                {error ? (
                    <div>Error: {error}</div>
                ) : (
                    <>
                        <CinemaTabList
                            locationSelected={locationSelected}
                            setLocationSelected={setLocationSelected}
                            locations={locations}
                        />
                        <CinemaTabPane
                            cinemas={cinemas}
                            location={locationSelected}
                        />
                    </>
                )}
            </div>
        </div>
    );
}

export default CinemaListPage;
