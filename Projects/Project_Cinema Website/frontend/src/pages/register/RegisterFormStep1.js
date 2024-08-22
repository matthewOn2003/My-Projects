import React, { useState, useRef, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';

import emailjs from '@emailjs/browser';

import EmailParameters from './EmailParameters';
import AuthPrompt from '../../components/AuthPrompt';
import Button from '../../components/Button';
import FormInput from '../../components/FormInput';
import UserService from '../../services/UserService';

function RegisterFormStep1({ title, setStep, formState, setFormState }) {

    const form = useRef();
    const navigate = useNavigate();
    const [user, setUser] = useState(null);
    const [otp, setOtp] = useState(0);
    const [isButtonDisabled, setIsButtonDisabled] = useState(false);
    const [hint, setHint] = useState({ showHint: false, formatHint: '' });

    const handleChange = (e) => {
        const { name, value, type, checked } = e.target;

        setFormState({
            ...formState,
            [name]: type === 'checkbox' ? checked : value,
        });

        if (name === 'otpInput' && value === otp) {
            alert(`${value}: CORRECT!`);
            setStep(2);
        }

        if (name === 'email') {
            setHint({ showHint: false, formatHint: '' });
        }
    };

    const fetchUserByEmail = async () => {
        try {
            const user = await UserService.getUserByEmail(formState.email);
            setUser(user);
        } catch (error) {
            console.log('User not found, can use for register');
            setIsButtonDisabled(true);
            setOtp(Math.floor(100000 + Math.random() * 900000).toString());
        }
    }

    const validateEmail = () => {
        const emailRegex = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|.(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

        if (!emailRegex.test(formState.email)) {
            setHint({
                showHint: true,
                formatHint: 'Please check your email format.',
            });
            return false;
        }

        return true;
    };

    const generateOtp = (e) => {
        e.preventDefault();

        setTimeout(() => {
            setIsButtonDisabled(false);
        }, 30000);

        if (validateEmail()) {
            fetchUserByEmail();
        }
    };

    useEffect(() => {
        if (user !== null) {
            alert('Email already used, please log in or try another email.');
        }
    }, [user]);

    useEffect(() => {
        if (otp > 0) {
            console.log(otp);
            // emailjs
            //     .sendForm('service_tmg683g', 'template_ddtef7s', form.current, {
            //         publicKey: 'l_JaqwYLm4fsMV7-E',
            //     })
            //     .then(
            //         () => {
            //             console.log('SUCCESS!');
            //         },
            //         (error) => {
            //             console.log('FAILED...', error.text);
            //         },
            //     );
        }
    }, [otp]);

    return (
        <>
            <h4 className="text-center mb-5">{title}</h4>
            <form ref={form}>
                <EmailParameters formState={formState} otp={otp} />
                <FormInput
                    labelTitle="Enter your email:"
                    inputType="email"
                    inputName="email"
                    inputValue={formState.email}
                    inputOnChange={handleChange}
                    formatHint={hint.formatHint}
                    showHint={hint.showHint}
                />
                <div className="my-3">
                    <Button
                        buttonTitle={isButtonDisabled ? 'Getting OTP... ' : 'Get OTP'}
                        buttonOnClick={generateOtp}
                        buttonIsDisabled={isButtonDisabled} />
                </div>
                {otp === 0 ||
                    <FormInput
                        inputType="text"
                        inputName="otpInput"
                        inputValue={formState.otpInput}
                        inputOnChange={handleChange}
                    />}
                <AuthPrompt prompt={"Already have an account? "} link="/login-page" />
            </form>
        </>
    );
}

export default RegisterFormStep1;
