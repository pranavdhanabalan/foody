
function DishCard({dish}){
    return (
        <div>
            <h2 className="dish-name" >{dish.dishName}</h2>
            <h2 className="dish-price" >{dish.dishPrice}</h2>
            <button>
                Add to Cart
            </button>
        </div>
    );
}

export default DishCard