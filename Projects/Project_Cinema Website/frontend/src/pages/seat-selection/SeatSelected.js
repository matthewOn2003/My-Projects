import { useNavigate } from 'react-router-dom';


function SeatSelected(props) {
    const navigate = useNavigate();

    const showtime = props.showtime;
    const selectedSeats = props.selectedSeats;
    const selectedSeatNumbers = selectedSeats.map(seat => seat.seatNumber).join(', ');

    return (
        <div className="SeatSelected">
            <div className="d-flex flex-row justify-content-between align-items-center rounded-top-5 
                bg-dark fixed-bottom px-5 py-4 w-75 mx-auto">
                <div className="ms-2 fs-5">
                    <div className="text-light ">Seat Selection</div>
                    <div className="text-warning">
                        {(selectedSeats.length > 0) ? selectedSeatNumbers : '- Please Select Seats -'}
                    </div>
                </div>

                <a className="btn btn-primary btn-lg btn-block 
                    rounded-3 me-2 px-5 py-3 bg-warning border-0 text-dark text-decoration-none"
                    href="/secret/food-selection-page"
                    onClick={(e) => {
                        e.preventDefault();

                        if ((showtime === null) || !(selectedSeats.length > 0)) {
                            alert('please select atleast 1 seat!!');
                            return;
                        }
                        navigate('/secret/food-selection-page', {
                            state: {
                                showtime: showtime,
                                selectedSeats: selectedSeats
                            }
                        });
                    }}>
                    <strong>Confirm</strong> - {selectedSeats.length} ticket(s)
                </a>
            </div>
        </div>
    );
}

export default SeatSelected;
