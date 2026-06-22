import './DishCard.scss';
function DishCard({dish}){
    return (
        <div className="dish-card">
            <div className="dish-details">
                <h1 className="dish-name" >{dish.dishName}</h1>

            </div>
            <div className="card-footer">
                <h1 className="dish-price" >₹{dish.dishPrice}</h1>
                <button className="add-to-cart-button">
                    Add
                </button>
            </div>
        </div>
    );
}

export default DishCard