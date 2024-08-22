import React, { useState } from 'react';
import InputFields from '../../components/InputFields';
import Button from '../../components/Button';
import UserService from '../../services/UserService';

function UserInfo({ user, setUser }) {

    const [formState, setFormState] = useState({
        email: user.email,
        fullName: user.fullName,
        phoneNumber: user.phoneNumber,
    });

    const [isEditing, setIsEditing] = useState(false);

    const handleChange = (e) => {
        const { name, value, type, checked } = e.target;

        setFormState({
            ...formState,
            [name]: type === 'checkbox' ? checked : value,
        });

    };

    const formFields = [
        {
            labelTitle: 'Email',
            inputType: 'email',
            inputName: 'email',
            inputValue: formState.email,
            inputOnChange: handleChange,
            isInputDisabled: !isEditing ? 'disabled' : ''
        },
        {
            labelTitle: 'Full Name',
            inputType: 'text',
            inputName: 'fullName',
            inputValue: formState.fullName,
            inputOnChange: handleChange,
            isInputDisabled: !isEditing ? 'disabled' : ''
        },
        {
            labelTitle: 'Phone Number',
            inputType: 'text',
            inputName: 'phoneNumber',
            inputValue: formState.phoneNumber,
            inputOnChange: handleChange,
            isInputDisabled: !isEditing ? 'disabled' : ''
        },
    ];


    const validateInputs = () => {

        const emailRegex = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|.(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        const fullNameRegex = /^[a-zA-Z\s]{6,20}$/;
        const phoneRegex = /^01\d{8}$/;

        //
        if (!emailRegex.test(formState.email)) {
            alert('Please check your email format.')
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

        return true;
    };



    const buttonOnClick = () => {



        if (isEditing) { //click save change

            const updatedUser = {
                ...user,
                email: formState.email,
                fullName: formState.fullName,
                phoneNumber: formState.phoneNumber
            }
            console.log('Saving changes...', updatedUser);

            if (!validateInputs()) {
                return;
            }

            UserService.updateUserById(user.userId, updatedUser).then(response => {
                console.log('User updated: ', response);
                setUser(updatedUser);
                alert('User info updated!');
                window.scrollTo(0, 0);
            }).catch(error => {
                console.log('Fail update user: ', error);
            });

        } else {//click edit
            console.log('Editing user info...', user);


        }

        // Toggle the editing state
        setIsEditing(!isEditing);
    };

    return (
        <div className='px-5'>
            <h2 className='text-center my-4'>User Info</h2>
            <InputFields formFields={formFields} />

            <div className='d-flex justify-content-center'>
                <Button
                    buttonTitle={isEditing ? "Save Changes" : "Edit User Info"}
                    buttonOnClick={buttonOnClick} />
            </div>
        </div>
    );
}

export default UserInfo;
