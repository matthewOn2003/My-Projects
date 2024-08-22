import React, { useState, useRef, useEffect } from 'react';
import AuthCard from '../../components/AuthCard';
import RegisterFormStep1 from './RegisterFormStep1';
import RegisterFormStep2 from './RegisterFormStep2';


/*
<FormInput
    labelTitle={labelTitle}
    inputType={inputType}
    inputName={inputName}
    inputValue={inputValue}
    inputOnChange={inputOnChange}
/>
*/

const RegisterPage = () => {
    const [step, setStep] = useState(1);

    const [formState, setFormState] = useState({
        username: '',
        email: '',
        password: '',
        repeatPassword: '',
        fullName: '',
        phoneNumber: '',
        birthDate: '',
        termsAccepted: false,
        otpInput: ''
    });

    return (
        <AuthCard title="Creat An Account">
            {step === 1 &&
                <RegisterFormStep1
                    title="Step 1: Email Validation"
                    setStep={setStep}
                    formState={formState}
                    setFormState={setFormState} />
            }

            {step === 2 &&
                <RegisterFormStep2
                    title="Step 2: Add More Information"
                    setStep={setStep}
                    formState={formState}
                    setFormState={setFormState} />
            }


        </AuthCard>
    );
};

export default RegisterPage;
