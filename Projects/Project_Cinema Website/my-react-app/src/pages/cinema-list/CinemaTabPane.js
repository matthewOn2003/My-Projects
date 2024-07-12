import React from 'react';
import { useNavigate } from 'react-router-dom';

function CinemaTabPane(props) {
    const navigate = useNavigate();
    const { location, cinemas } = props;

    // Filter cinemas based on selected location
    const filteredCinemas = location === 'all'
        ? cinemas
        : cinemas.filter(cinema => {
            const match = toHyphenCase(cinema.city) === location.toLowerCase();
            return match;
        });


    return (
        <div className="CinemaTabPane tab-content text-white" id="cinema-tab-pane">
            <div className="tab-pane fade show active" id="now-showing-tab-pane" role="tabpanel"
                aria-labelledby={`${location}-tab`} tabIndex="0">
                <ul className="d-flex justify-content-between flex-wrap px-0">
                    {filteredCinemas.map((cinema, index) => (
                        <li
                            key={index}
                            className="list-unstyled my-2 d-flex border my-3"
                            style={{
                                height: '180px',
                                width: 'calc(25% - 20px)',
                                backgroundImage: `url(${cinema.cinemaImage})`,
                                backgroundSize: 'cover',
                                backgroundPosition: 'center',
                                backgroundRepeat: 'no-repeat',
                                boxShadow: 'inset 0 -50px 50px 0 rgba(0, 0, 0, 1)'
                            }}
                        >
                            <a
                                className='h-100 w-100 d-flex px-3 py-2 text-white text-decoration-none'
                                href=''
                                onClick={() => {
                                    navigate('/cinema-intro-page', {
                                        state: { cinema: cinema }
                                    });
                                }}>
                                <h5 className='align-self-end'>{cinema.name}</h5>
                            </a>
                        </li>
                    ))}
                </ul>
            </div>
        </div>
    );
}

export default CinemaTabPane;
function toHyphenCase(str) {
    return str.split(/[\s-]+/).map(word => word.toLowerCase()).join('-');
}