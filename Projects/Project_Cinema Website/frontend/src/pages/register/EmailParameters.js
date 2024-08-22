import { useLocation } from 'react-router-dom';
import React, { useEffect, useState } from 'react';


function EmailParameters(props) {

    const formState = props.formState;
    const otp = props.otp;

    return (
        <>
            <input type="hidden" name="subject" value="Email Validation" />
            <input type="hidden" name="message" value={`Your OTP for registration: ${otp}`} />
            {/* <input type="hidden" name="user_name" value={formState.fullName} /> */}
            <input type="hidden" name="user_email" value={formState.email} />

        </>
    );
}

export default EmailParameters;
