import React from 'react';

const Footer = () => {
    return (
        <footer className="text-center text-white" style={{ background: 'linear-gradient(to bottom, #0d6efd, #002766)' }}>
            <div className="container">
                <section className="mt-5">
                    <div className="row text-center d-flex justify-content-center pt-5">
                        <div className="col-md-2">
                            <h6 className="text-uppercase font-weight-bold">
                                <a href="/secret/movie-list-page" className="text-white">Movie List</a>
                            </h6>
                        </div>
                        <div className="col-md-2">
                            <h6 className="text-uppercase font-weight-bold">
                                <a href="/secret/cinema-list-page" className="text-white">Cinema List</a>
                            </h6>
                        </div>
                        <div className="col-md-2">
                            <h6 className="text-uppercase font-weight-bold">
                                <a href="/secret/about-us-page" className="text-white">About Us</a>
                            </h6>
                        </div>

                    </div>
                </section>

                <hr className="my-5" />

                <section className="mb-5">
                    <div className="row d-flex justify-content-center">
                        <div className="col-lg-8">
                            <p>
                                a modern cinema website that enhanced UI/UX,
                                streamlined booking process & information access procedure.
                                "Let's Create Unforgettable Moments at SSC!"
                            </p>
                        </div>
                    </div>
                </section>

                <section className="text-center mb-5">
                    <a href="" className="text-white me-4">
                        <i className="fab fa-facebook-f"></i>
                    </a>
                    <a href="" className="text-white me-4">
                        <i className="fab fa-twitter"></i>
                    </a>
                    <a href="" className="text-white me-4">
                        <i className="fab fa-google"></i>
                    </a>
                    <a href="" className="text-white me-4">
                        <i className="fab fa-instagram"></i>
                    </a>
                    <a href="" className="text-white me-4">
                        <i className="fab fa-linkedin"></i>
                    </a>
                    <a href="" className="text-white me-4">
                        <i className="fab fa-github"></i>
                    </a>
                </section>
            </div>

            <div className="text-center p-3" style={{ backgroundColor: 'rgba(0, 0, 0, 0.2)' }}>
                © 2020 Copyright: &nbsp;
                <a className="text-white" href="https://matthew-website.vercel.app/">Author's Website</a>
            </div>
        </footer>
    );
};

export default Footer;
