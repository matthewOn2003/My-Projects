import { useLocation, useNavigate } from 'react-router-dom';
import ItemSelectedPane from '../../components/ItemSelectedPane';
import MovieInfo from '../../components/MovieInfo';
import SeatsAndTickets from './SeatsAndTickets';
import TicketTypes from './TicketTypes';



function TicketConfirmPage() {

    const navigate = useNavigate();
    const { selectedSeats, showtime } = useLocation().state;

    const buttonOnClick = (e) => {
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
    };

    return (
        <div className="TicketConfirmPage" style={{ backgroundColor: 'black' }}>
            <MovieInfo showtime={showtime} />
            <div className="container fs-5 py-5 border-5 border-bottom">
                <div className="text-light">Seat(s)</div>
                <div className="text-white fw-bold">C08, C09</div>
            </div>
            {/* <TicketTypes /> */}
            <ItemSelectedPane
                title={"Ticket Types"}
                itemsDesc={""}
                buttonTitle={"Confirm"}
                buttonOnClick={buttonOnClick} />
        </div>
    );
}

export default TicketConfirmPage;
