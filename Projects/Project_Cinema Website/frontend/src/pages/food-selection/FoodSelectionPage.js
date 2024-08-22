import React, { useEffect, useState } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';

import CategoryTabList from './CategoryTabList';
import CategoryTabPane from './CategoryTabPane';
import ItemSelectedPane from '../../components/ItemSelectedPane';

import FoodService from '../../services/FoodService';
import { useFood } from '../../hooks/useFood';
import MovieInfo from '../../components/MovieInfo';


function FoodSelectionPage() {

    const navigate = useNavigate();
    const showtime = useLocation().state.showtime;
    const selectedSeats = useLocation().state.selectedSeats;

    const { foods, fetchFoods, loading, error } = useFood();
    const [categories, setCategories] = useState([]);
    const [selectedFood, setSelectedFood] = useState([]);
    const [totalPrice, setTotalPrice] = useState(0);


    useEffect(() => {
        fetchFoods();
    }, [fetchFoods]);


    useEffect(() => {
        setCategories([...new Set(foods.map(food => food.category))]);
    }, [foods]);


    useEffect(() => {
        const totalPrice = selectedFood.reduce((total, food) => total + parseFloat(food.price), 0).toFixed(2);
        setTotalPrice(totalPrice);
    }, [selectedFood]);


    const buttonOnClick = (e) => {
        e.preventDefault();

        if ((showtime === null) || !(selectedSeats.length > 0)) {
            alert('error!!');
            return;
        }
        navigate('/secret/payment-page', {
            state: {
                showtime: showtime,
                selectedSeats: selectedSeats,
                selectedFood: selectedFood
            }
        });
    }


    return (
        <div className="py-5 ">
            <MovieInfo showtime={showtime} />

            <ItemSelectedPane
                title={"Food Selection"}
                itemsDesc={(selectedFood.length > 0) ? `${selectedFood.length} items` : '- Please Select Food -'}
                buttonTitle={`Confirm - RM ${totalPrice} `}
                buttonOnClick={buttonOnClick}
            />

            <section className=" px-0 py-5 fs-6">
                {/* <CategoryTabList categories={categories} /> */}
                {/* <div className="fs-1 fw-bold mb-3">Movies</div> */}

                {categories.map((category, categoryIndex) => {
                    return (
                        <CategoryTabPane
                            key={categoryIndex}
                            filteredFoods={foods?.filter(food => food.category === category)}
                            category={category}
                            selectedFood={selectedFood}
                            setSelectedFood={setSelectedFood} />
                    )
                })}
            </section>
        </div>
    );
}

export default FoodSelectionPage;
