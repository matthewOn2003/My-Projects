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
        <div className="tab-content text-white" id="cinema-tab-pane">
            <div className="tab-pane fade show active" id="now-showing-tab-pane" role="tabpanel"
                aria-labelledby={`${location}-tab`} tabIndex="0">
                <ul className="d-flex justify-content-between flex-wrap px-0">
                    {filteredCinemas.map((cinema, index) => (
                        <li key={index}
                            className="list-unstyled d-flex col-3 p-2"
                            style={{
                                height: '180px',
                            }}>
                            <div
                                className='w-100 border border-dark border-2'
                                style={{
                                    backgroundImage: `url(${cinema.cinemaImage})`,
                                    backgroundSize: 'cover',
                                    backgroundPosition: 'center',
                                    backgroundRepeat: 'no-repeat',
                                    boxShadow: 'inset 0 -50px 50px 0 rgba(0, 0, 0, 1)'
                                }}>
                                <div className='d-flex align-items-end h-100 w-100 px-3 py-2 text-white text-decoration-none border'
                                    href='/secret/cinema-intro-page'
                                    onClick={(e) => {

                                    }}>
                                    <div className='h-100 w-100 d-flex align-items-end flex-wrap  justify-content-between'>
                                        <div className='hover-item '>
                                            <a className="fs-5 fw-bold d-flex align-items-center text-white text-decoration-none"
                                                href="/"
                                                onClick={e => {
                                                    e.preventDefault();
                                                    navigate('/secret/cinema-intro-page', {
                                                        state: { cinemaId: cinema.cinemaId }
                                                    });
                                                }}>
                                                <span className="d-inline-block border border-3 me-2 rounded-5 text-center"
                                                    style={{ width: '30px', height: '30px', lineHeight: '22px' }}>i</span>
                                                <span className="">
                                                    View More
                                                </span>
                                            </a>
                                        </div>
                                        <h5 className='m-0'>{cinema.name}</h5>

                                    </div>
                                </div>
                            </div>
                        </li>
                    ))}
                </ul>
            </div>
        </div >
    );
}

export default CinemaTabPane;


function toHyphenCase(str) {
    return str.split(/[\s-]+/).map(word => word.toLowerCase()).join('-');
}