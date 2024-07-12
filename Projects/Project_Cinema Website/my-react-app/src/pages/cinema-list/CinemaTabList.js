import React from 'react';

function CinemaTabList(props) {
    const { locationSelected, setLocationSelected, locations } = props;

    return (
        <div className="CinemaTabList dropdown d-flex align-items-center my-4">
            <div className='text-white me-3 fs-5'>Location: </div>
            <button
                type="button"
                className="btn dropdown-toggle bg-white text-end px-3"
                data-bs-toggle="dropdown"
                style={{ minWidth: '150px' }}>
                {toTitleCase(locationSelected)}
            </button>
            <ul className="dropdown-menu">
                <li
                    id='location-all'
                    className={`dropdown-item ${locationSelected === 'all' ? 'active' : ''}`}
                    onClick={() => setLocationSelected('all')}
                    style={{ cursor: 'pointer' }}>
                    All
                </li>
                {locations.map((location, index) => (
                    <li
                        key={index}
                        id={`location-${toHyphenCase(location)}`}
                        className={`dropdown-item ${locationSelected === toHyphenCase(location) ? 'active' : ''}`}
                        onClick={() => setLocationSelected(toHyphenCase(location))}
                        style={{ cursor: 'pointer' }}>
                        {location}
                    </li>
                ))}
            </ul>
        </div>
    );
}

function toHyphenCase(str) {
    return str.split(/[\s-]+/).map(word => word.toLowerCase()).join('-');
}

function toTitleCase(str) {
    return str.split(/[\s-]+/).map(word => word.charAt(0).toUpperCase() + word.slice(1).toLowerCase()).join(' ');
}

export default CinemaTabList;
