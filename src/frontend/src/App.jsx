import {HashRouter,Route,Routes} from 'react-router-dom';
import './App.css'
import MenuPage from "./pages/MenuPage.jsx";

function App() {
  return (
      <div className="App">
          <HashRouter>
              <Routes>
                  <Route path="/menu" element={<MenuPage/>}/>
              </Routes>
          </HashRouter>
      </div>
  );
}

export default App
