import React from 'react';

function Button(props) {
    const buttonSize = props.buttonSize || 'md';
    const buttonColor = props.buttonColor || '#0d6efd';
    const textColor = props.textColor || '#fff';
    const buttonOnClick = props.buttonOnClick || (() => { });
    const buttonIsDisabled = props.buttonIsDisabled || false;
    const buttonTitle = props.buttonTitle || '';

    return (
        <button
            className={`btn btn-block btn-${buttonSize} gradient-custom-4`}
            onClick={buttonOnClick}
            disabled={buttonIsDisabled} // Disable button based on state
            style={{ backgroundColor: buttonColor, color: textColor }}
        >
            {buttonTitle}
        </button>
    );
}

export default Button;
