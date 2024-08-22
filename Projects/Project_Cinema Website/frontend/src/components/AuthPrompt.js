import { useLocation } from 'react-router-dom';
import React, { useEffect, useState } from 'react';


function AuthPrompt({ prompt, link, linkWord }) {

    return (
        <p className="text-center text-muted mt-3 mb-0">
            {prompt}
            <a href={link} className="fw-bold text-body">
                <u>{linkWord || 'Click here'}</u>
            </a>
        </p>
    );
}

export default AuthPrompt;
