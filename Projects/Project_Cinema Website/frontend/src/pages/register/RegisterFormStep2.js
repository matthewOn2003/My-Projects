import React, { useState, useRef, useEffect } from 'react';
// import emailjs from '@emailjs/browser';
import { useAuth } from '../../hooks/useAuth';

import TermOfService from './TermOfService';
import InputFields from '../../components/InputFields';
import EmailParameters from './EmailParameters';
import AuthPrompt from '../../components/AuthPrompt';
import Button from '../../components/Button';
import FormInput from '../../components/FormInput';


function RegisterFormStep2({ title, setStep, formState, setFormState }) {

    const form = useRef();
    const { register } = useAuth();

    const handleChange = (e) => {
        const { name, value, type, checked } = e.target;

        setFormState({
            ...formState,
            [name]: type === 'checkbox' ? checked : value,
        });

    };

    const validateInputs = () => {

        const usernameRegex = /^[a-zA-Z][a-zA-Z0-9._]{5,10}$/;
        const passwordRegex = /^(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[!@#$%^&*a-zA-Z\d]{5,20}$/;
        const fullNameRegex = /^[a-zA-Z\s]{6,20}$/;
        const phoneRegex = /^01\d{8}$/;

        // Validate username
        if (!usernameRegex.test(formState.username)) {
            alert('Please check your username format: \nShould start with a letter, only lowercase letters, numbers, . or _, and length between 6 and 10.');
            return false;
        }

        // Validate password
        if (!passwordRegex.test(formState.password)) {
            alert('Please check your password format: \nShould be 6-20 characters long and contain at least 1 symbol, 1 uppercase letter, 1 lowercase letter, and 1 number.');
            return false;
        }

        // Validate repeatPassword
        if (formState.password !== formState.repeatPassword) {
            alert('Repeat password must match password.');
            return false;
        }

        // Validate full name
        if (!fullNameRegex.test(formState.fullName)) {
            alert('Please check your full name format: \nShould be 6-20 characters long and only contain letters.');
            return false;
        }

        // Validate phone number
        if (!phoneRegex.test(formState.phoneNumber)) {
            alert('Please check your phone number format: \nShould be 10 digits and start with 01.');
            return false;
        }

        // Validate terms accepted
        if (formState.termsAccepted == false) {
            alert('Please tick the terms accepted chekck box.');
            return false;
        }

        return true;
    };



    const formFields = [
        {
            labelTitle: 'Username',
            inputType: 'text',
            inputName: 'username',
            inputValue: formState.username,
            inputOnChange: handleChange,
        },
        {
            labelTitle: 'Password',
            inputType: 'password',
            inputName: 'password',
            inputValue: formState.password,
            inputOnChange: handleChange,
        },
        {
            labelTitle: 'Repeat your password',
            inputType: 'password',
            inputName: 'repeatPassword',
            inputValue: formState.repeatPassword,
            inputOnChange: handleChange,
        },
        {
            labelTitle: 'Full Name',
            inputType: 'text',
            inputName: 'fullName',
            inputValue: formState.fullName,
            inputOnChange: handleChange,
        },
        {
            labelTitle: 'Phone Number',
            inputType: 'text',
            inputName: 'phoneNumber',
            inputValue: formState.phoneNumber,
            inputOnChange: handleChange,
        },
        {
            labelTitle: 'Birth Date',
            inputType: 'date',
            inputName: 'birthDate',
            inputValue: formState.birthDate,
            inputOnChange: handleChange,
        }
    ];

    const handleSubmit = (e) => {
        e.preventDefault();

        if (validateInputs()) {
            console.log(formState);
            register(formState);
        }
        //
    };



    return (
        <>
            <h4 className="text-center mb-5">{title}</h4>

            <form ref={form} onSubmit={handleSubmit} >

                <InputFields formFields={formFields} />
                <TermOfService formState={formState} handleChange={handleChange} />

                <div className="d-flex justify-content-around px-5 my-3">
                    <Button
                        buttonTitle={'Register'}
                        buttonOnClick={handleSubmit} />
                </div>

                <AuthPrompt prompt={"Already have an account? "} link="/login-page" />

            </form>
        </>
    );
}

export default RegisterFormStep2;
