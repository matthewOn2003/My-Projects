import React, { useEffect, useState } from 'react';
import { useLocation } from 'react-router-dom';

import DarkNav from '../../components/DarkNav';
import BlackFooter from '../../components/BlackFooter';

import FoodSelected from "./FoodSelected";
// import MovieInfo from "./MovieInfo";
import FoodOptions from "./FoodOptions";
import FoodService from '../../services/FoodService';

function FoodSelection() {

    const state = useLocation().state;
    const showtime = state.showtime;
    const selectedSeats = state.selectedSeats;

    let [foods, setFoods] = useState([]);
    let [categories, setCategories] = useState([]);
    let [foodsChosen, setFoodsChosen] = useState([]);


    // Function to update categories based on foods
    const updateCategories = (foods) => {
        const newCategories = [...new Set(foods.map(food => food.category))];
        setCategories(newCategories);
    };

    // Fetch foods from the API
    const fetchFoods = async () => {
        try {
            const foods = await FoodService.getAllFoods();
            setFoods(foods);
            updateCategories(foods); // Update categories after fetching foods
        } catch (error) {
            console.error('Error fetching foods:', error);
        }
    };

    useEffect(() => {
        window.scrollTo(0, 0);
        fetchFoods();
    }, []); // Separate useEffect for fetching foods

    return (
        <div style={{ backgroundColor: 'black' }} className="FoodSelection">
            <FoodSelected
                showtime={showtime}
                selectedSeats={selectedSeats}
                foodsChosen={foodsChosen}
            />
            <FoodOptions
                foods={foods}
                categories={categories}
                foodsChosen={foodsChosen}
                setFoodsChosen={setFoodsChosen} />
        </div>
    );
}

export default FoodSelection;
