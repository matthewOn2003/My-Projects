import React, { useState } from 'react';
import { useAuth } from '../../hooks/useAuth';
import AuthPrompt from '../../components/AuthPrompt';
import Button from '../../components/Button';
import InputFields from '../../components/InputFields';

function LoginForm({ title, formState, setFormState }) {

    const { login } = useAuth();
    const [hints, setHints] = useState({
        username: { showHint: false, formatHint: '' },
        password: { showHint: false, formatHint: '' },
    });

    const handleChange = (e) => {
        const { name, value, type, checked } = e.target;
        setFormState({
            ...formState,
            [name]: type === 'checkbox' ? checked : value,
        });
        setHints({ ...hints, [name]: { showHint: false, formatHint: '' } });
    };

    const validateInputs = () => {
        const usernameRegex = /^[a-zA-Z][a-zA-Z0-9._]{5,10}$/;
        const passwordRegex = /^(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[!@#$%^&*a-zA-Z\d]{5,20}$/;

        let isValid = true;
        const newHints = { ...hints };

        if (!usernameRegex.test(formState.username)) {
            newHints.username = {
                showHint: true,
                formatHint: 'Please check your username format: Should start with a letter, only lowercase letters, numbers, . or _, and length between 6 and 10.',
            };
            isValid = false;
        }

        if (!passwordRegex.test(formState.password)) {
            newHints.password = {
                showHint: true,
                formatHint: 'Please check your password format: Should be 6-20 characters long and contain at least 1 symbol, 1 uppercase letter, 1 lowercase letter, and 1 number.',
            };
            isValid = false;
        }

        setHints(newHints);
        return isValid;
    };

    const handleOnClick = async (e) => {
        e.preventDefault();
        if (validateInputs()) {
            const { username, password } = formState;
            await login({ username, password });
        }
    };

    const formFields = [
        {
            labelTitle: 'Username',
            inputType: 'text',
            inputName: 'username',
            inputValue: formState.username,
            inputOnChange: handleChange,
            formatHint: hints.username.formatHint,
            showHint: hints.username.showHint,
        },
        {
            labelTitle: 'Password',
            inputType: 'password',
            inputName: 'password',
            inputValue: formState.password,
            inputOnChange: handleChange,
            formatHint: hints.password.formatHint,
            showHint: hints.password.showHint,
        },
    ];

    return (
        <>
            <h4 className="text-center mb-5">{title}</h4>
            <form>
                <InputFields formFields={formFields} />
                <div className="d-flex justify-content-around px-5 mt-3 mb-5">
                    <Button buttonOnClick={handleOnClick} buttonTitle={"Login"} />
                </div>
                <AuthPrompt prompt={"New user? "} link="/register-page" linkWord="Register here" />
            </form>
        </>
    );
}

export default LoginForm;
