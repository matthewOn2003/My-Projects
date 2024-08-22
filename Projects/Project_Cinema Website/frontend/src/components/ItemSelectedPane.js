import { useLocation } from 'react-router-dom';
import React, { useEffect, useState } from 'react';
import Button from './Button';


function ItemSelectedPane({ title, itemsDesc, buttonTitle, buttonOnClick }) {

    return (
        <div className="fixed-bottom mx-auto w-75 px-4 py-3 fs-5 bg-primary border border-2 border-light rounded-top-5">
            <div className="text-light px-3 text-center pb-2 fs-5">{title}</div>
            <div className='d-flex justify-content-between align-items-center bg-light py-3 px-4 mx-2 rounded-4 '>
                <div className="text-dark">{itemsDesc}</div>
                <Button
                    buttonTitle={buttonTitle}
                    buttonOnClick={buttonOnClick} />
            </div>
        </div>
    );
}

export default ItemSelectedPane;


/* <div className="text-primary border border-2 border-primary rounded-5 px-3 py-1">{itemsDesc}</div>
                    <Button
                        buttonTitle={buttonTitle}
                        buttonOnClick={buttonOnClick} /> */