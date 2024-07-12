
function Recommendation() {
    return (
        <div className="Recommendation">
            <section style={{ backgroundColor: 'dodgerblue', height: '490px', marginBottom: '140px' }}>
                <div id="carouselExample" className="carousel slide">
                    <div className="d-flex align-items-center carousel-inner" style={{ height: '490px' }}>
                        <div className="carousel-item fs-1 text-center active">111</div>
                        <div className="carousel-item fs-1 text-center">222</div>
                        <div className="carousel-item fs-1 text-center">333</div>
                        <div className="carousel-item fs-1 text-center">444</div>
                        <div className="carousel-item fs-1 text-center">555</div>
                        <div className="carousel-item fs-1 text-center">666</div>
                        <div className="carousel-item fs-1 text-center">777</div>
                        <div className="carousel-item fs-1 text-center">888</div>
                        <div className="carousel-item fs-1 text-center">999</div>
                        <div className="carousel-item fs-1 text-center">000</div>
                    </div>

                    <button className="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
                        <span className="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span className="visually-hidden">Previous</span>
                    </button>

                    <button className="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
                        <span className="carousel-control-next-icon" aria-hidden="true"></span>
                        <span className="visually-hidden">Next</span>
                    </button>
                </div>
            </section>
        </div>
    );
}

export default Recommendation;
