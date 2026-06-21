import {HashRouter,Route,Routes} from 'react-router-dom';
import './App.css'
import HomePage from "./pages/HomePage.jsx";
import MenuPage from "./pages/MenuPage.jsx";
import NavBar from "./components/NavBar.jsx";

function App() {
  return (
      <div className="App">
          <HashRouter>
              <NavBar/>
              <Routes>
                  <Route path="/" element={<HomePage/>}/>
                  <Route path="/menu" element={<MenuPage/>}/>
              </Routes>
          </HashRouter>
      </div>
  );
}

export default App
