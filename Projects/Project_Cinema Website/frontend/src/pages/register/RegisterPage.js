import React, { useState, useRef } from 'react';
import emailjs from '@emailjs/browser';

const RegisterPage = () => {

    const form = useRef();


    const [username, setUsername] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [repeatPassword, setRepeatPassword] = useState('');
    const [fullName, setFullName] = useState('');
    const [phoneNumber, setPhoneNumber] = useState('');
    const [birthDate, setBirthDate] = useState('');
    const [termsAccepted, setTermsAccepted] = useState(false);

    const handleSubmit = (e) => {
        e.preventDefault();
        // Handle form submission logic here
        console.log({
            username,
            email,
            password,
            repeatPassword,
            fullName,
            phoneNumber,
            birthDate,
            termsAccepted,
        });

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
        <section className="vh-100 bg-image"
            style={{ backgroundImage: "url('https://mdbcdn.b-cdn.net/img/Photos/new-templates/search-box/img4.webp')" }}>
            <div className="mask d-flex align-items-center h-100">
                <div className="container h-100">
                    <div className="row d-flex justify-content-center align-items-center h-100">
                        <div className="col-12 col-md-9 col-lg-7 col-xl-6">
                            <div className="card" style={{ borderRadius: '15px' }}>
                                <div className="card-body p-5">
                                    <h2 className="text-center mb-5">Create an account</h2>

                                    <form ref={form} onSubmit={handleSubmit} >
                                        <input type="hidden" name="subject" value="Email Validation" />
                                        <input type="hidden" name="message" value="123456" />

                                        <div data-mdb-input-init className="form-outline mb-3">
                                            <label className="form-label">Username</label>
                                            <input
                                                type="text"
                                                className="form-control form-control-md"
                                                value={username}
                                                onChange={(e) => setUsername(e.target.value)}
                                            />
                                        </div>

                                        <div data-mdb-input-init className="form-outline mb-3">
                                            <label className="form-label">Email</label>
                                            <input
                                                type="email"
                                                className="form-control form-control-md"
                                                name="user_email"
                                                value={email}
                                                onChange={(e) => setEmail(e.target.value)}
                                            />
                                        </div>

                                        <div data-mdb-input-init className="form-outline mb-3">
                                            <label className="form-label">Password</label>
                                            <input
                                                type="password"
                                                className="form-control form-control-md"
                                                value={password}
                                                onChange={(e) => setPassword(e.target.value)}
                                            />
                                        </div>

                                        <div data-mdb-input-init className="form-outline mb-3">
                                            <label className="form-label">Repeat your password</label>
                                            <input
                                                type="password"
                                                className="form-control form-control-md"
                                                value={repeatPassword}
                                                onChange={(e) => setRepeatPassword(e.target.value)}
                                            />
                                        </div>

                                        <div data-mdb-input-init className="form-outline mb-3">
                                            <label className="form-label">Full Name</label>
                                            <input
                                                type="text"
                                                className="form-control form-control-md"
                                                name="user_name"
                                                value={fullName}
                                                onChange={(e) => setFullName(e.target.value)}
                                            />
                                        </div>

                                        <div data-mdb-input-init className="form-outline mb-3">
                                            <label className="form-label">Phone Number</label>
                                            <input
                                                type="text"
                                                className="form-control form-control-md"
                                                value={phoneNumber}
                                                onChange={(e) => setPhoneNumber(e.target.value)}
                                            />
                                        </div>

                                        <div data-mdb-input-init className="form-outline mb-3">
                                            <label className="form-label">Birth Date</label>
                                            <input
                                                type="date"
                                                className="form-control form-control-md"
                                                value={birthDate}
                                                onChange={(e) => setBirthDate(e.target.value)}
                                            />
                                        </div>

                                        <div className="form-check d-flex justify-content-center mb-3">
                                            <input
                                                className="form-check-input me-2"
                                                type="checkbox"
                                                id="form2Example3cg"
                                                checked={termsAccepted}
                                                onChange={(e) => setTermsAccepted(e.target.checked)}
                                            />
                                            <label className="form-check-label" htmlFor="form2Example3cg">
                                                I agree all statements in <a href="#!" className="text-body"><u>Terms of service</u></a>
                                            </label>
                                        </div>

                                        <div className="d-flex justify-content-center">
                                            <button
                                                type="submit"
                                                className="btn btn-primary btn-block btn-md gradient-custom-4 text-body">
                                                Register
                                            </button>
                                        </div>

                                        <p className="text-center text-muted mt-3 mb-0">
                                            Have already an account?
                                            <a href="/login-page" className="fw-bold text-body">
                                                <u>Login here</u>
                                            </a>
                                        </p>
                                    </form>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    );
};

export default RegisterPage;
