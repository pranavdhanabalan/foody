
import './HomePage.scss';
import img from '../assets/img.png';

function HomePage(){
    return (
        <div className="home-page">
            <img
                src={img}
                alt="Burger"
                className="dish-image"
            />
            <div className="ticker">
                <div className="ticker-track">
                    <span>
                        HAI! • LIFE'S BETTER WITH FOODY • FOOD SO GOOD, IT'S ALMOST CRIMINAL •
                    </span>

                    <span>
                        HAI! • LIFE'S BETTER WITH FOODY • FOOD SO GOOD, IT'S ALMOST CRIMINAL •
                    </span>

                    <span>
                        HAI! • LIFE'S BETTER WITH FOODY • FOOD SO GOOD, IT'S ALMOST CRIMINAL •
                    </span>

                    <span>
                        HAI! • LIFE'S BETTER WITH FOODY • FOOD SO GOOD, IT'S ALMOST CRIMINAL •
                    </span>
                </div>
            </div>
            <section className="about-section">
                <h2>
                    LET'S TALK ABOUT
                    <br />
                    FOOD, BABY!
                </h2>

                <p>
                    From cheesy pizzas and juicy burgers
                    to crispy dosas and flaky parottas,
                    Foody brings your favorite meals
                    right to your fingertips.
                </p>
            </section>
        </div>
    );
}

export default HomePage