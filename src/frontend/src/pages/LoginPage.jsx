import { useState } from "react";
import { useNavigate } from "react-router-dom";
import "./LoginPage.scss";

function LoginPage() {
    const navigate = useNavigate();

    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");

    const handleLogin = async (e) => {
        e.preventDefault();

        const response = await fetch("/auth/login", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                email,
                password
            })
        });

        if (response.ok) {
            const data = await response.json();
            localStorage.setItem("token", data.token);
            alert("Login Successful");
            navigate("/");
        } else {
            alert("Invalid Email or Password");
        }
    };

    return (
        <div className="login-container">
            <form className="login-card" onSubmit={handleLogin}>

                <h1>Foody</h1>
                <h3>Login</h3>

                <input
                    type="email"
                    placeholder="Email"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                    required
                />

                <input
                    type="password"
                    placeholder="Password"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                    required
                />

                <button type="submit" className="login-btn">
                    Login
                </button>

                <button
                    type="button"
                    className="register-btn"
                    onClick={() => navigate("/register")}
                >
                    Register
                </button>

            </form>
        </div>
    );
}

export default LoginPage;