import React, { useEffect, useState } from 'react';

function CategoryTabPane(props) {
    const filteredFoods = props.filteredFoods;
    const category = props.category;
    const foodsChosen = props.foodsChosen;
    const setFoodsChosen = props.setFoodsChosen;


    const handleAddFood = (food) => {
        // Add the new food item to the array
        const updatedFoods = [...foodsChosen, food];

        // Sort the array by foodId
        updatedFoods.sort((a, b) => a.foodId - b.foodId);

        // Update the state with the sorted array
        setFoodsChosen(updatedFoods);
    };

    const handleRemoveFood = (food) => {
        const index = foodsChosen.indexOf(food);

        if (index !== -1) {
            const updatedFoods = [...foodsChosen];
            updatedFoods.splice(index, 1);
            setFoodsChosen(updatedFoods);
        }
    };

    return (
        <div className="CategoryTabPane my-5">
            <div id={toHyphenPattern(category)} className="py-2 my-3">
                <span className="border border-3 border-primary rounded-3 px-5 py-2 fs-5">{category}</span>
            </div>

            <ul className="d-flex flex-wrap px-0">
                {filteredFoods.map((food, foodIndex) => (
                    <li key={foodIndex} className="list-unstyled border col-lg-4 col-md-6 col-12 py-2">
                        <div className="d-flex flex-nowrap justify-content-between fs-5 m-0">
                            <div className="d-flex justify-content-center align-items-center" style={{ width: '40%' }}>
                                <img
                                    className='bg-white'
                                    style={{ width: '152px', height: '152px' }}
                                    src={food.foodImage}
                                    alt='food-img'></img>
                            </div>

                            <div className="px-3" style={{ width: '60%' }}>
                                <div className="fs-5 fw-bold">{food.name}</div>
                                <p className="fs-6">{food.foodId} - {food.description}</p>
                            </div>
                        </div>

                        <div className="py-4 fs-5 d-flex justify-content-between px-4">
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
                                    {foodsChosen.filter(f => f === food).length}
                                </span>

                                <span
                                    className="d-inline-block bg-warning rounded-5 mx-1 text-center fs-3 fw-bold text-dark"
                                    style={{ lineHeight: '26px', height: '32px', width: '32px', cursor: 'pointer' }}
                                    onClick={() => handleAddFood(food)}>
                                    +
                                </span>
                            </span>
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
