import React, { useEffect, useState } from 'react';

function CategoryTabPane({ filteredFoods, category, selectedFood, setSelectedFood }) {

    const handleAddFood = (food) => {
        const updatedFoods = [...selectedFood, food];
        updatedFoods.sort((a, b) => a.foodId - b.foodId);
        setSelectedFood(updatedFoods);
    };

    const handleRemoveFood = (food) => {
        const index = selectedFood.indexOf(food);
        if (index !== -1) {
            const updatedFoods = [...selectedFood];
            updatedFoods.splice(index, 1);
            setSelectedFood(updatedFoods);
        }
    };

    return (
        <div className="container my-5 px-4 py-3 rounded-5 shadow" style={{ backgroundColor: '#0050b3' }}>
            <div id={toHyphenPattern(category)} className="py-2 my-3">
                <span className="bg-light fw-bold rounded-4 px-5 py-2 fs-5">{category}</span>
            </div>

            <ul className="d-flex flex-wrap px-0">
                {filteredFoods.map((food, foodIndex) => (
                    <li key={foodIndex} className="list-unstyled col-lg-4 col-md-6 col-12 p-2">
                        <div className='bg-light rounded-4 p-3'>
                            <div className="d-flex w-100 justify-content-between fs-5 m-0">
                                <span
                                    className='border col-4'
                                    style={{
                                        backgroundImage: `url(${food.foodImage})`,
                                        backgroundSize: 'cover',
                                        backgroundPosition: 'center',
                                        backgroundRepeat: 'no-repeat',
                                        aspectRatio: '1/1'
                                    }}>
                                </span>

                                <div className="px-3 col-8 ">
                                    <div className="fs-5 fw-bold">{food.name}</div>
                                    <p className="fs-6">{food.foodId} - {food.description}</p>
                                </div>

                            </div>

                            <div className="d-flex justify-content-between align-items-center fs-5 mt-3">
                                <span>
                                    <span>RM</span>
                                    <span>{food.price}</span>
                                </span>

                                <span className='d-flex'>
                                    <span
                                        className="d-inline-block bg-warning rounded-5 mx-1 text-center fs-3 fw-bold text-dark"
                                        style={{ lineHeight: '26px', height: '32px', width: '32px', cursor: 'pointer' }}
                                        onClick={() => handleRemoveFood(food)}>
                                        -
                                    </span>

                                    <span className="mx-2">
                                        {selectedFood.filter(f => f === food).length}
                                    </span>

                                    <span
                                        className="d-inline-block bg-warning rounded-5 mx-1 text-center fs-3 fw-bold text-dark"
                                        style={{ lineHeight: '26px', height: '32px', width: '32px', cursor: 'pointer' }}
                                        onClick={() => handleAddFood(food)}>
                                        +
                                    </span>
                                </span>
                            </div>

                        </div>
                    </li>
                ))}
            </ul>
        </div>
    );
}

function toHyphenPattern(string) {
    return string.toLowerCase().split(' ').join('-');
}

export default CategoryTabPane;
