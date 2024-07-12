import axios from 'axios';

const baseURL = 'http://localhost:8080/api/tickets'; // Replace with your actual API endpoint

class TicketService {

    // GET
    static async getTicketById(ticketId) {
        return (await axios.get(`${baseURL}/getTicket/${ticketId}`)).data;
    }

    static async getTicketByReferenceNo(referenceNo) {
        return (await axios.get(`${baseURL}/getTicketByReferenceNo/${referenceNo}`)).data;
    }

    static async getAllTickets() {
        return (await axios.get(`${baseURL}/getAllTickets`)).data;
    }

    // POST
    static async addTicket(newTicket) {
        return (await axios.post(`${baseURL}/addTicket`, newTicket)).data;
    }

    // PUT (Update by Ticket ID)
    static async updateTicketById(ticketId, updatedTicket) {
        return (await axios.put(`${baseURL}/updateTicketById/${ticketId}`, updatedTicket)).data;
    }

    // PUT (Update by Reference Number)
    static async updateTicketByReferenceNo(referenceNo, updatedTicket) {
        return (await axios.put(`${baseURL}/updateTicketByReferenceNo/${referenceNo}`, updatedTicket)).data;
    }

    // DELETE (Delete by Ticket ID)
    static async deleteTicketById(ticketId) {
        return (await axios.delete(`${baseURL}/deleteTicketById/${ticketId}`)).data;
    }

    // DELETE (Delete by Reference Number)
    static async deleteTicketByReferenceNo(referenceNo) {
        return (await axios.delete(`${baseURL}/deleteTicketByReferenceNo/${referenceNo}`)).data;
    }
}

export default TicketService;
