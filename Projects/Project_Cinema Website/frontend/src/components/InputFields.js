import React from 'react';
import FormInput from './FormInput';

function InputFields({ formFields }) {
    return (
        <>
            {formFields?.map((field, index) => (
                <div key={index} data-mdb-input-init className="form-outline mb-3">
                    <FormInput
                        labelTitle={field.labelTitle}
                        inputType={field.inputType}
                        inputName={field.inputName}
                        inputValue={field.inputValue}
                        inputOnChange={field.inputOnChange}
                        formatHint={field.formatHint}
                        showHint={field.showHint}
                        isInputDisabled={field.isInputDisabled}
                    />
                </div>
            ))}
        </>
    );
}

export default InputFields;
