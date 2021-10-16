import { React, useEffect, useState } from "react";
import { TabBar } from "./../components/TabBar";
import {BrowserRouter as Router, Link} from "react-router-dom"

import "./../styles/standing_page.css";
import { CircuitComponent } from "../components/CircuitComponent";
import {TableComponent} from "../components/TableComponent"



export const StandingsPage = () => {

  const [races, setRaces] = useState([]);
  const[seasons, setSeasons] = useState([]);

  useEffect(
    () => {
      const fetchRacesByYear = async () => {
        const repsonse = await fetch("http://localhost:8080/standings/races/" + seasons[0].year);
        const data = await repsonse.json();
        setRaces(data.races);
        console.log("running races");
      };

      const fetchSeasons = async () => {
        const response = await fetch("http://localhost:8080/standings/seasons");
        const data = await response.json();
        setSeasons(data.seasons);
        console.log("running seasons");
        fetchRacesByYear()
      };

      fetchSeasons();
    }, []
  );


  return (
    <div className="StandingsPage">
      <TabBar />
      <Router>


  <div className="MainGrid">

        <div className="LeftPane">

    {/**Year list */}
      <div className="ListBlock card">
        <p className="ListHeading">YEAR</p>
            <ul className="LeftList MyScroll YearList">
                {seasons.map(season => <li className="ListItem"><Link>{season.year}</Link></li>)}
            </ul>
          </div>

          {/**Year list */}
      <div className="ListBlock card">
        <p className="ListHeading">RACES</p>
            <ul className="LeftList MyScroll RaceList">
                {races.map(team => <li className="ListItem"><Link>{team.name}</Link></li>)}
            </ul>
          </div>

          </div>


          <div className="RightPane">

            <CircuitComponent/>
            <TableComponent />


          </div>




    </div>
        
        </Router>
    </div>
  );
}
