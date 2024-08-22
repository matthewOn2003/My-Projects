import React, { useState } from 'react';

import MovieTabList from './MovieTabList';
import MovieTabPane from './MovieTabPane';

function MovieListPage() {

    const tabs = [
        { name: 'now-showing', title: 'Now Showing' },
        { name: 'advance-sales', title: 'Advanced Sales' },
        { name: 'coming-soon', title: 'Coming Soon' }
    ];

    return (
        <div className='bg-light py-5'>
            <div id='movie-options' className="container px-0 py-5 fs-6">
                <div className="fs-1 fw-bold text-dark mb-3">Movies</div>

                {/* <MovieTabList tabs_arr={tabs} /> */}
                <MovieTabPane tabs_arr={tabs} />

            </div>
        </div >


    );
}

export default MovieListPage;
