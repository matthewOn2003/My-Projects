import React from 'react';
import food1 from '../../assets/img/food1.png';
import CategoryTabList from './CategoryTabList';
import CategoryTabPane from './CategoryTabPane';


function FoodOptions(props) {

    const foods = props.foods;
    const categories = props.categories;
    const foodsChosen = props.foodsChosen;
    const setFoodsChosen = props.setFoodsChosen;

    return (
        <section className="FoodOptions container px-0 py-5 text-white fs-6">
            <CategoryTabList
                categories={categories} />

            {categories.map((category, categoryIndex) => {

                const filteredFoods = foods.filter(food => food.category === category);

                return (
                    <CategoryTabPane
                        key={categoryIndex}
                        filteredFoods={filteredFoods}
                        category={category}
                        foodsChosen={foodsChosen}
                        setFoodsChosen={setFoodsChosen} />
                )

            })}

        </section>
    );
}

export default FoodOptions;