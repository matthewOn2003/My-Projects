import React, { useEffect, useState } from 'react';
import DateTimeUtils from "../../utils/DateTimeUtils";
import { useNavigate } from 'react-router-dom';
import ShowtimeService from '../../services/ShowtimeService';





function CinemaAndTime(props) {

    const navigate = useNavigate();
    let [showtimes, setShowtimes] = useState([]);

    //
    const movieId = props.movieId;
    const dateSelected = props.dateSelected;
    const expSelected = props.expSelected;

    useEffect(() => {
        const fetchShowtimes = async (movieId, dateSelected, expSelected) => {
            try {
                const showtimesData = await ShowtimeService.getShowtimesByMovieDateExperience(movieId, dateSelected, expSelected);
                setShowtimes(showtimesData);
            } catch (error) {
                console.error('Error fetching showtimes:', error);
            }
        };

        fetchShowtimes(movieId, dateSelected, expSelected);
    }, [movieId, dateSelected, expSelected]);




    //
    const renderScreenings = (showtime) => {
        const datetime = new DateTimeUtils(showtime.showDate);
        const time = datetime.getTime().split(':');
        const hour = parseInt(time[0], 10);
        const period = hour >= 12 ? 'PM' : 'AM';
        const formattedHour = hour % 12 || 12;
        const timeStr = `${formattedHour}:${time[1]} ${period}`;
        const date_only = showtime.showDate.split(' ')[0];
        const exp = showtime.hall.experienceType;

        if (date_only === dateSelected && exp === expSelected) {
            return (
                <li key={showtime.showtimeId} className="list-unstyled me-5 mb-5">
                    <a
                        className="d-block py-1 px-2 border border-1 border-warning rounded-2 text-decoration-none text-white"
                        href="/seat-selection-page"
                        onClick={(event) => {
                            event.preventDefault();
                            navigate('/seat-selection-page', {
                                state: {
                                    showtime: showtime
                                }
                            });
                        }}
                        style={{ width: '128px' }}
                    >
                        <div className="fs-6 py-2">{showtime.showtimeId}, {timeStr}</div>
                        <div className="fs-6 py-2 border-top border-warning">{exp}</div>
                    </a>
                </li>
            );
        }

        return null;
    };


    // \\ cinemas
    const renderCinemas = () => {

        if (showtimes/* && showtimes.length > 0*/) {
            const uniqueCinemas = Array.from(new Set(showtimes.map(showtime => showtime.cinema.cinemaId)))
                .map(cinemaId => showtimes.find(showtime => showtime.cinema.cinemaId === cinemaId));


            return uniqueCinemas.map((showtime, showtimeIndex) => (
                <li className="list-unstyled border-1 border-bottom border-white" key={showtimeIndex}>
                    <div className="fs-5 fw-bold p-4 d-flex justify-content-between text-decoration-none" type="button"
                        data-bs-toggle="collapse" data-bs-target={`#cinema-${showtimeIndex}`} aria-expanded="false"
                        aria-controls={`cinema-${showtimeIndex}`}>
                        <span>{showtime.cinema.name}</span>
                        <span className="fw-bold">+ {showtime.cinema.cinemaId}</span>
                    </div>

                    <div className="collapse collapse-horizontal" id={`cinema-${showtimeIndex}`}>
                        <ul className="d-flex flex-row flex-wrap text-center fw-bold py-0 px-4 mb-5 card card-body" style={{ backgroundColor: 'black' }}>
                            {showtimes
                                .filter(st => st.cinema.cinemaId === showtime.cinema.cinemaId)
                                .map(st => renderScreenings(st))
                            }
                            {/* {renderScreenings(showtime.cinema)} */}
                        </ul>
                    </div>
                </li>
            ));
        } else {
            return (
                <li className="list-unstyled text-center fs-5 fw-bold py-5 text-white">
                    ( No Cinema Found )
                </li>
            );
        }
    }

    return (
        <div className="CinemaAndTime text-white">
            <section className="py-4" style={{ backgroundColor: 'black' }}>
                <div className="container">
                    <div className="fs-5 py-3">Select Cinema</div>
                    <ul className="ps-0">

                        {renderCinemas()}

                    </ul>
                </div>
            </section>
        </div>
    );
}

export default CinemaAndTime;
