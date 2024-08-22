import React, { useEffect, useState } from 'react';
import '../styles/Alert.css'; // Import your CSS file for animations

const Alert = ({ title, message }) => {
    const [showAlert, setShowAlert] = useState(true);

    const handleClose = () => {
        setShowAlert(false);
    };

    useEffect(() => {
        const timeoutId = setTimeout(() => {
            handleClose();
        }, 7000);

        // Clean up the timeout to prevent memory leaks
        return () => clearTimeout(timeoutId);
    }, []);

    return (
        <div className="position-fixed top-0 start-50 translate-middle-x mt-4">
            {showAlert && (
                <div className="alert alert-danger alert-dismissible fade show animated-alert" role="alert">
                    <strong>{title}</strong>{message}
                    <button type="button" className="btn-close" onClick={handleClose} aria-label="Close"></button>
                </div>
            )}
        </div>
    );
};

export default Alert;
