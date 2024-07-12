import React, { useEffect, useState } from 'react';
import { useLocation } from 'react-router-dom';

import DarkNav from '../../components/DarkNav'
import BlackFooter from '../../components/BlackFooter'

import TotalPayment from './TotalPayment';



function PaymentPage() {

    const state = useLocation().state;

    return (
        <div className="PaymentPage " style={{ backgroundColor: 'black' }}>
            <TotalPayment state={state} />
        </div>
    );
}

export default PaymentPage;
