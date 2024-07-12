import React from 'react';


function CinemaPicture(props) {
    return (
        <div className='CinemaPicture border '>
            <img
                className='d-block mx-auto border'
                src={props.cinema.cinemaImage}
                style={{
                    height: '500px'
                }}
            ></img>
        </div>
    );
}

export default CinemaPicture;