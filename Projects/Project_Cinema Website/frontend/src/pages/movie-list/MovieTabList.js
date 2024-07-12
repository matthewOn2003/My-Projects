import React from 'react';
import { useState } from "react";
import { useNavigate } from 'react-router-dom';


const MovieTabList = (props) => {
    const tabs = props.tabs_arr;

    return (
        <ul className="d-flex flex-row flex-wrap justify-content-between px-5 text-warning" id="myTab" role="tablist">
            {tabs.map((tab, index) => (
                <li key={index} className="list-unstyled" role="presentation">
                    <button
                        id={`${tab.name}-tab`}
                        key={index}
                        className="nav-link border-bottom border-warning px-5 py-2 active"
                        data-bs-toggle="tab"
                        data-bs-target={`${tab.name}-tab-pane`}
                        type="button"
                        role="tab"
                        aria-controls={`${tab.name}-tab-pane`}
                        aria-selected="true"
                    >
                        {tab.title}
                    </button>
                </li>
            ))}
        </ul>

    );
};

export default MovieTabList;
