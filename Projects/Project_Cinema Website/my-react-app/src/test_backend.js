import axios from "axios";

async function test_backend() {
    const emailData = {
        to: 'onwuxu@gmail.com',
        subject: 'TEST',
        body: 'WAWA'
    };

    try {
        const response = await axios.post('http://localhost:8080/api/email/sendEmail', emailData, {
            headers: {
                'Content-Type': 'application/json'
            }
        });
        console.log('Email sent successfully:', response.data);
    } catch (error) {
        console.error('Error sending email:', error);
    }

}

export default test_backend;
