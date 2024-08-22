import AuthCard from "../../components/AuthCard";
import tng from "../../assets/img/tng.jpg"
import Button from "../../components/Button";
import { useLocation, useNavigate } from "react-router-dom";

import OrderService from "../../services/OrderService";
import SeatService from "../../services/SeatService";

function TngPage() {

    const navigate = useNavigate();
    const orderData = useLocation().state.orderData;


    const cancelPayment = (e) => {
        e.preventDefault();
        navigate('/secret/movie-list-page');
    }

    const confirmPayment = (e) => {
        e.preventDefault();

        OrderService.addOrder(orderData).then(response => {
            console.log('Order added successfully:', response);


        }).catch(error => {
            console.log('Failed to add order: ', error);
        });


        // Update each seat status to 'BOOKED'
        orderData.seats.forEach(seat => {
            const updatedSeat = { ...seat, status: 'BOOKED' };
            SeatService.updateSeatById(seat.seatId, updatedSeat).then(() => {
                console.log(`Seat ${seat.seatNumber} updated to BOOKED`);
            }).catch(error => {
                console.log(`Failed to update seat ${seat.seatNumber}: `, error);
            });
        });
        // console.log(orderData);
        alert('Successful!!')

        navigate('/secret/profile-page');
    }

    return (
        <div className="container vh-100 py-5 border">
            <h2 className="text-center my-3">Stellar Sight Cinema</h2>
            <div className="d-flex flex-wrap justify-content-center">
                <img
                    className="border border-3 border-primary rounded-5 "
                    style={{ width: '400px' }}
                    src={tng} />
            </div>

            <div className="d-flex justify-content-center my-5 ">
                <div className="me-5">
                    <Button buttonTitle={"Cancel"} buttonOnClick={(e) => cancelPayment(e)} />
                </div>

                <div>
                    <Button buttonTitle={"Confirm Payment"} buttonOnClick={(e) => confirmPayment(e)} />
                </div>

            </div>

        </div>
    );
}

export default TngPage;
