import React from 'react';

function FormInput(props) {
    const {
        labelTitle,
        inputType,
        inputName,
        inputValue,
        inputOnChange,
        formatHint,
        showHint,
        isInputDisabled
    } = props;

    return (
        <div>
            {labelTitle && (<label className="form-label">{labelTitle}</label>)}
            <input
                type={inputType}
                className="form-control form-control-md"
                name={inputName}
                value={inputValue}
                onChange={inputOnChange}
                disabled={isInputDisabled}
            />
            {showHint && <i className="fas fa-globe fa-lg text-danger">{formatHint}</i>}
        </div>
    );
}

export default FormInput;
