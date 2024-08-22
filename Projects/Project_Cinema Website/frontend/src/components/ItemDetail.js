import { useLocation } from 'react-router-dom';
import React, { useEffect, useState } from 'react';


function ItemDetail({ itemIndex, itemDescription, itemAmount }) {


    return (
        <div key={itemIndex} className="d-flex justify-content-between my-2">
            <span className="col-10">
                {itemDescription}
            </span>

            <span className="px-0 text-end">
                {itemAmount}
            </span>
        </div>
    );
}

export default ItemDetail;
