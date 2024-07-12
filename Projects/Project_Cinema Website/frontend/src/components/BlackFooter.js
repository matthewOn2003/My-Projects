import React from 'react';

function BlackFooter() {
    return (
        <div className="BlackFooter">
            <footer style={{ backgroundColor: 'black' }}>
                <div className="container pt-5 text-white">
                    <div className="row">
                        <div className="col-sm-3">
                            <ul className="nav flex-column">
                                <li className="nav-item">
                                    <a className="nav-link ps-0 text-white" href="">Link 1</a>
                                </li>
                                <li className="nav-item">
                                    <a className="nav-link ps-0 text-white" href="">Link 2</a>
                                </li>
                                <li className="nav-item">
                                    <a className="nav-link ps-0 text-white" href="">Link 3</a>
                                </li>
                                <li className="nav-item">
                                    <a className="nav-link ps-0 text-white" href="">Link 4</a>
                                </li>
                                <li className="nav-item">
                                    <a className="nav-link ps-0 text-white" href="">Link 5</a>
                                </li>
                                <li className="nav-item">
                                    <a className="nav-link ps-0 text-white" href="">Link 6</a>
                                </li>
                            </ul>
                        </div>

                        <div className="col-sm-3">2</div>

                        <div className="col-sm-3">3</div>

                        <div className="col-sm-3">
                            <div className="footer-label">
                                <h5>Golden Screen Cinemas Sdn Bhd</h5>
                                <p className="font-xs fw-normal">195901000261 (3609-M)</p>
                            </div>
                            <div className="footer-item">
                                <p>1, Jalan SS 22/19, Damansara Jaya, 47400 Petaling Jaya, Selangor, Malaysia</p>
                                <p>How do I contact GSC Customer Service?</p>
                                <a className="btn btn-primary font-s text-dark fw-bold px-4" href="#">GET SUPPORT</a>
                            </div>
                        </div>
                    </div>
                </div>

                <div className="container py-3 pt-5">
                    <div className="row justify-content-between text-white">
                        <div className="col-auto d-flex flex-column flex-sm-row align-items-sm-center">
                            <div className="footer-label fw-bold mb-3 me-0 me-sm-3 mb-sm-0">
                                Download App
                            </div>
                            <ul className="nav">
                                <li className="nav-item">
                                    <a href="#" target="_blank" className="nav-link px-2">AAA</a>
                                </li>
                                <li className="nav-item">
                                    <a href="#" target="_blank" className="nav-link px-2">AAA</a>
                                </li>
                                <li className="nav-item">
                                    <a href="#" target="_blank" className="nav-link px-2">AAA</a>
                                </li>
                                <li className="nav-item">
                                    <a href="#" target="_blank" className="nav-link px-2">AAA</a>
                                </li>
                            </ul>
                        </div>

                        <div className="col-auto d-flex flex-column flex-sm-row align-items-sm-center">
                            <div className="footer-label fw-bold mb-3 me-0 me-sm-3 mb-sm-0">
                                Follow Us On
                            </div>
                            <ul className="nav">
                                <li className="nav-item">
                                    <a href="#" target="_blank" className="nav-link px-2">AAA</a>
                                </li>
                                <li className="nav-item">
                                    <a href="#" target="_blank" className="nav-link px-2">AAA</a>
                                </li>
                                <li className="nav-item">
                                    <a href="#" target="_blank" className="nav-link px-2">AAA</a>
                                </li>
                                <li className="nav-item">
                                    <a href="#" target="_blank" className="nav-link px-2">AAA</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>

                <div className="footer-bottom border-top py-4 font-xs text-white">
                    copy right
                </div>
            </footer>
        </div>
    );
}

export default BlackFooter;
