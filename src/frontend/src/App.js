
import './App.css';
import { StandingsPage } from './pages/StandingsPage';
import {HashRouter as Router, Route, Switch} from "react-router-dom"
import { useEffect, useState } from 'react';


function App() {


  const[seasons, setSeasons] = useState([]);

  useEffect(
    () => {
      const fetchSeasons = async () => {
        const response = await fetch(`${process.env.REACT_APP_BASE_URL}/standings/seasons`);
        const data = await response.json();
        setSeasons(data);
      };
      fetchSeasons();
    }, []
  );

  return (
    <div className="App">
      <Router>
        <Switch>
        <Route path={"/standings/races/:year"}>
      <StandingsPage seasons={seasons}/>
      </Route>
      <Route path={"/"}>
      <StandingsPage seasons={seasons}/>
      </Route>
      </Switch>
      </Router>
    </div>
  );
}

export default App;
