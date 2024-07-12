function TicketTypes() {
    return (
        <div className="TicketTypes">
            <section className="w-75 mx-auto fs-5">
                <div className="bg-dark rounded-top-5 px-5">
                    <ul className="d-flex flex-wrap justify-content-between text-white py-3 px-0">
                        <li className="list-unstyled d-flex justify-content-between py-3" style={{ width: '30%' }}>
                            <span>
                                Adult
                            </span>

                            <span>
                                <span className="d-inline-block bg-warning rounded-5 mx-1 text-center fs-3 fw-bold text-dark"
                                    style={{ lineHeight: '26px', height: '32px', width: '32px' }}>
                                    -
                                </span>

                                <span className="mx-2">
                                    3
                                </span>

                                <span className="d-inline-block bg-warning rounded-5 mx-1 text-center fs-3 fw-bold text-dark"
                                    style={{ lineHeight: '26px', height: '32px', width: '32px' }}>
                                    +
                                </span>
                            </span>
                        </li>

                        {/* 这里放其他票务类型的代码，类似上面的结构 */}

                    </ul>


                    <div className="d-flex justify-content-end py-4 border-top border-white ">
                        <button type="button" className="btn btn-warning btn-lg px-5 py-3">
                            <strong>Confirm</strong> - 9 ticket(s)
                        </button>
                    </div>


                </div>
            </section>
        </div>
    );
}

export default TicketTypes;
