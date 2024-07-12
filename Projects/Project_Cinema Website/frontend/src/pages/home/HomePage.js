import React, { useRef } from 'react';
import emailjs from '@emailjs/browser';


import Recommendation from './Recommendation'
import Movies from './Movies'
import Top10 from './Top10'
import Promotions from './Promotions'

import test_backend from '../../test_backend';


export const ContactUs = () => {
    const form = useRef();

    const sendEmail = (e) => {
        e.preventDefault();

        emailjs
            .sendForm('service_m58znch', 'template_u5qynqs', form.current, {
                publicKey: 'DVhnmYEt_rlkmW6dO',
            })
            .then(
                () => {
                    console.log('SUCCESS!');
                },
                (error) => {
                    console.log('FAILED...', error.text);
                },
            );
    };

    return (
        <form ref={form} onSubmit={sendEmail}>
            <label>To Name</label>
            <input type="text" name="user_name" />

            <label>From Name</label>
            <input type="text" name="from_name" />

            <label>Email</label>
            <input type="email" name="user_email" />

            <label>Subject</label>
            <input type="text" name="subject" />

            <label>Message</label>
            <textarea name="message" />

            <input type="submit" value="Send" />
        </form>
    );
};





function HomePage() {

    return (
        <div className="HomePage">
            <button onClick={test_backend}>test</button>

            <ContactUs />


            <Recommendation />
            <Movies />
            <Top10 />
            <Promotions />
        </div>
    );
}

export default HomePage;
