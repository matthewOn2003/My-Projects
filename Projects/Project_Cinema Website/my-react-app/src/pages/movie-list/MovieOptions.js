import React, { useState } from 'react';

import MovieTabList from './MovieTabList';
import MovieTabPane from './MovieTabPane';


const tabs = [
    { name: 'now-showing', title: 'Now Showing' },
    { name: 'advance-sales', title: 'Advanced Sales' },
    { name: 'coming-soon', title: 'Coming Soon' }
];


function MovieOptions() {


    return (
        <div id='movie-options' className="container px-0 py-5 fs-6">
            <div className="fs-1 fw-bold text-white">Movies</div>

            {/* tab list */}
            <MovieTabList tabs_arr={tabs} />

            {/* tab content */}
            <MovieTabPane tabs_arr={tabs} />

        </div>
    );
}

export default MovieOptions;


// current issue (20/5/2024)
// 1. Need to useState, when click certain tab on list, change the state
// 2. Then pass the state to tab pane, to decide the select condition