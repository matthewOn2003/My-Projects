import { React, useState, useEffect, useRef } from 'react';

import Movies from './Movies'
import Top10 from './Top10'
import Promotions from './Promotions'

import test_backend from '../../test_backend';
import ButtonSwiper from '../../components/ButtonSwiper';




function HomePage() {

    return (
        <div className="HomePage">
            <button onClick={test_backend}>test</button>

            <ButtonSwiper />
            <Movies />
            <Top10 />
            <Promotions />
        </div>
    );
}

export default HomePage;
