import DarkNav from '../../components/DarkNav'
import BlackFooter from '../../components/BlackFooter'

import MovieInfo from './MovieInfo';
import SeatsAndTickets from './SeatsAndTickets';
import TicketTypes from './TicketTypes';



function TicketConfirmPage() {
    return (
        <div className="TicketConfirmPage" style={{ backgroundColor: 'black' }}>
            <MovieInfo />
            <SeatsAndTickets />
            <TicketTypes />
        </div>
    );
}

export default TicketConfirmPage;
