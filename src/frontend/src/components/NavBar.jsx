import { Link } from "react-router-dom";
import './NavBar.scss';

function NavBar() {
    return (
        <div className="nav-bar">
            <div className="logo">
                <Link to="/">foody</Link>
            </div>

            <div className="nav-links">
                <Link to="/">Home</Link>
                <Link to="/menu">Menu</Link>
                <Link to="/account">Account</Link>
            </div>
        </div>
    );
}

export default NavBar