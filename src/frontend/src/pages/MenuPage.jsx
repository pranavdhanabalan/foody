import DishCard from '../components/DishCard.jsx';
import './MenuPage.scss';
import {useEffect, useState} from "react";

function MenuPage(){

    const [dishes,setDishes]=useState([]);

    useEffect(() => {
        const fetchDishes=async ()=>{
            const response=await fetch(`/menu/get`);
            const data=await response.json();
            console.log(data);
            setDishes(data);
        };
        fetchDishes();
    }, []);

    return (
        <div className="menu-page">
            <div className="dish-grid">
                <div>

                </div>
                <div>
                    {dishes.map(item => (
                        <DishCard
                            key={item.itemId}
                            dish={item}
                        />
                    ))}
                </div>
                <div>
                    
                </div>
            </div>
        </div>
    );
}

export default MenuPage