import React, { useEffect, useState } from 'react';
import html2canvas from 'html2canvas';
import jsPDF from 'jspdf';
import Button from '../../components/Button';
import TicketService from '../../services/TicketService';
import movie from '../../assets/img/movie.png';
import cinema from '../../assets/img/cinema.png';
import hall from '../../assets/img/hall.png';
import date from '../../assets/img/date.png';
import time from '../../assets/img/time.png';
import PdfComponent from '../../components/PdfComponent';
import '../../components/PdfComponent.css';

function TicketsPane({ user }) {
    const [tickets, setTickets] = useState([]);

    useEffect(() => {
        TicketService.getTicketsByUserId(user.userId)
            .then(tickets => {
                const sortedTickets = tickets.sort((a, b) => b.order.orderNumber - a.order.orderNumber);
                setTickets(sortedTickets);
            })
            .catch(error => {
                console.error('Error fetching tickets by user id: ', error);
            });
    }, [user.userId]);

    const fetchImageAsBase64 = async (imageUrl) => {
        const response = await fetch(imageUrl);
        const blob = await response.blob();
        return new Promise((resolve, reject) => {
            const reader = new FileReader();
            reader.onloadend = () => resolve(reader.result);
            reader.onerror = reject;
            reader.readAsDataURL(blob);
        });
    };

    const generatePDF = async (ticket) => {
        const ticketElement = document.getElementById(`pdf-${ticket.ticketId}`);
        ticketElement.classList.remove('hidden-for-print'); // Show the element for PDF generation

        const qrCodeImage = await fetchImageAsBase64(`https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=${ticket.order.orderNumber}`);
        const canvas = await html2canvas(ticketElement);
        const imgData = canvas.toDataURL('image/png');
        const pdf = new jsPDF();
        pdf.addImage(imgData, 'PNG', 10, 10);
        pdf.addImage(qrCodeImage, 'PNG', 140, 10, 50, 50); // Adjust the position and size as needed
        pdf.save(`${ticket.movieTitle}-ticket.pdf`);

        ticketElement.classList.add('hidden-for-print'); // Hide the element again
    };

    return (
        <div id='tickets-tab-pane' className="row border">
            <h2 className='text-center my-4'>Tickets Purchased</h2>

            {tickets.map((ticket, ticketIndex) => (
                <div key={ticketIndex} className="col-md-6 mb-4 px-4 px-md-3  border">
                    <div id={`pdf-${ticket.ticketId}`} className="hidden-for-print">
                        <PdfComponent ticket={ticket} />
                    </div>

                    <div className={`card mb-md-0 border ${ticketIndex === 0 ? 'border-3 border-warning' : 'border-2 border-primary'}`}>
                        <div className="card-body text-center ">
                            <h5 className="">Ref No: {ticket.order.orderNumber}</h5>
                            <div className={`border border-1 my-3 ${ticketIndex === 0 ? 'border-warning' : 'border-primary'}`}></div>

                            <div className='px-sm-5 px-2'>
                                <img id={`ticket-${ticket.order.orderNumber}-qrcode`}
                                    src={`https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=${ticket.order.orderNumber}`}
                                    alt="QR Code"
                                    className='w-sm-100 w-0' />
                            </div>
                            <div className={`border border-1 my-4 ${ticketIndex === 0 ? 'border-warning' : 'border-primary'}`}></div>
                            <div className='fs-6 '>
                                <div className='d-flex align-items-center ps-3 mb-2'>
                                    <img src={movie} width={'28px'} height={'28px'} alt="Movie Icon" />
                                    <div className='ps-2 text-start'>{ticket.movieTitle}</div>
                                </div>

                                <div className='d-flex align-items-center ps-3 mb-2'>
                                    <img src={hall} width={'28px'} height={'28px'} alt="Hall Icon" />
                                    <div className='ps-2 text-start'>{ticket.hallName}</div>
                                </div>

                                <div className='d-flex align-items-center ps-3 mb-2'>
                                    <img src={cinema} width={'28px'} height={'28px'} alt="Cinema Icon" />
                                    <div className='ps-2 text-start'>{ticket.cinemaName}</div>
                                </div>

                                <div className='d-flex align-items-center ps-3 mb-2'>
                                    <img src={date} width={'28px'} height={'28px'} alt="Date Icon" />
                                    <div className='ps-2 text-start'>{ticket.showDate.split(' ')[0]}</div>
                                </div>

                                <div className='d-flex align-items-center ps-3 mb-2'>
                                    <img src={time} width={'28px'} height={'28px'} alt="Time Icon" />
                                    <div className='ps-2 text-start'>{ticket.showDate.split(' ')[1]}</div>
                                </div>

                                <div className='d-flex justify-content-center my-3'>
                                    <Button
                                        buttonColor={(ticketIndex === 0) ? '#ffc107' : '#0d6efd'}
                                        textColor={(ticketIndex === 0) ? 'black' : 'white'}
                                        buttonTitle="Print PDF"
                                        buttonOnClick={() => generatePDF(ticket)}
                                    />
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            ))}
        </div>
    );
}

export default TicketsPane;
