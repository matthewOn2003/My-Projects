import React, { useState } from 'react';
import axios from 'axios';

function SendEmailComponent() {
    const [toEmail, setToEmail] = useState('');
    const [subject, setSubject] = useState('');
    const [body, setBody] = useState('');

    const handleSendEmail = async () => {
        try {
            const response = await axios.get('http://localhost:8080/sendEmail', {
                params: {
                    toEmail: toEmail,
                    subject: subject,
                    body: body
                }
            });
            console.log('Email sent successfully:', response.data);
        } catch (error) {
            console.error('Error sending email:', error);
        }
    };

    return (
        <div>
            <input
                type="email"
                placeholder="Recipient's email"
                value={toEmail}
                onChange={(e) => setToEmail(e.target.value)}
            />
            <input
                type="text"
                placeholder="Subject"
                value={subject}
                onChange={(e) => setSubject(e.target.value)}
            />
            <textarea
                placeholder="Email body"
                value={body}
                onChange={(e) => setBody(e.target.value)}
            />
            <button onClick={handleSendEmail}>Send Email</button>
        </div>
    );
}

export default SendEmailComponent;
