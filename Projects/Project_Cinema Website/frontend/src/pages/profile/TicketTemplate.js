import React from 'react';

const TicketTemplate = ({ ticket }) => {
    return (
        <div id={`ticket-${ticket.order.orderNumber}`} className="ticket-template">
            <div className="ticket-header">
                <h2>{ticket.movieTitle}</h2>
            </div>
            <div className="ticket-body">
                <div className="ticket-section">
                    <strong>Hall:</strong> {ticket.hallName}
                </div>
                <div className="ticket-section">
                    <strong>Hall:</strong> {ticket.hallName}
                </div>
                <div className="ticket-section">
                    <strong>Hall:</strong> {ticket.hallName}
                </div>
                <div className="ticket-section">
                    <strong>Cinema:</strong> {ticket.cinemaName}
                </div>
                <div className="ticket-section">
                    <strong>Date:</strong> {ticket.showDate.split(' ')[0]}
                </div>
                <div className="ticket-section">
                    <strong>Time:</strong> {ticket.showDate.split(' ')[1]}
                </div>
                <div className="ticket-section">
                    <img src={`https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=${ticket.order.orderNumber}`} alt="QR Code" />
                </div>
            </div>
        </div>
    );
};

export default TicketTemplate;
