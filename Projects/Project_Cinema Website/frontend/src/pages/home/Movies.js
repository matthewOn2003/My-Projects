import React, { useEffect } from 'react';

import Swiper from 'swiper/bundle';

function Movies() {
    useEffect(() => {
        const swiper = new Swiper('.mySwiper', {
            slidesPerView: 3,
            spaceBetween: 30,
            pagination: {
                el: '.swiper-pagination',
                clickable: true,
            },
        });
    }, []);

    return (
        <div className="Movies">
            <section style={{ backgroundColor: 'pink', height: '490px', marginBottom: '140px' }}>
                <div className="container" style={{ height: '90%' }}>
                    <div className="fs-1 fw-bold">Movies</div>
                    <div className="swiper mySwiper">
                        <div className="swiper-wrapper">
                            <div className="swiper-slide">Slide 1</div>
                            <div className="swiper-slide">Slide 2</div>
                            <div className="swiper-slide">Slide 3</div>
                            <div className="swiper-slide">Slide 4</div>
                            <div className="swiper-slide">Slide 5</div>
                            <div className="swiper-slide">Slide 6</div>
                            <div className="swiper-slide">Slide 7</div>
                            <div className="swiper-slide">Slide 8</div>
                            <div className="swiper-slide">Slide 9</div>
                        </div>
                        <div className="swiper-pagination"></div>
                    </div>
                </div>
            </section>
        </div>
    );
}

export default Movies;
