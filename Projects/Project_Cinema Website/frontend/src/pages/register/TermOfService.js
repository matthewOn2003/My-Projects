import { useLocation } from 'react-router-dom';
import React, { useEffect, useState } from 'react';


function TermOfService(props) {

    const formState = props.formState;
    const handleChange = props.handleChange;


    return (
        <div className="form-check d-flex justify-content-center mb-3">
            <input
                className="form-check-input me-2"
                type="checkbox"
                id="form2Example3cg"
                name="termsAccepted"
                checked={formState.termsAccepted}
                onChange={handleChange}
            />
            <label className="form-check-label" htmlFor="form2Example3cg">
                I agree all statements in <a href="#!" className="text-body"><u>Terms of service</u></a>
            </label>
        </div>
    );
}

export default TermOfService;
