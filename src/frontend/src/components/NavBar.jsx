import './NavBar.scss';

export const NavBar = () => {
    return (
        <nav className="NavBar">
            <div className="logo">FOODY</div>

            <ul>
                <li>Home</li>
                <li>Menu</li>
                <li>Contact</li>
            </ul>
        </nav>
    );
};