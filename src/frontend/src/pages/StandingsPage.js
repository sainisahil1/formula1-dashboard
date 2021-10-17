import { React, useEffect, useState } from "react";
import { TabBar } from "./../components/TabBar";
import {Link, useParams} from "react-router-dom"

import "./../styles/standing_page.css";
import { CircuitComponent } from "../components/CircuitComponent";
import {TableComponent} from "../components/TableComponent"



export const StandingsPage = ({seasons}) => {

  var [races, setRaces] = useState([]);
  
  var [results, setResults] = useState([]);
  var [circuit, setCircuit] = useState([]);
  var {year} = useParams();



  useEffect(
    () => {
      const fetchRacesByYearInit = async () => {

        const repsonse = await fetch(`${process.env.REACT_APP_BASE_URL}/standings/races/${seasons[0]}`);
        const data = await repsonse.json();
        setRaces(data.races);
        console.log("running races");
        
      };
      fetchRacesByYearInit();
    }, [seasons]
  );

  useEffect(
    () => {
      const fetchRacesByYear = async () => {

        const repsonse = await fetch(`${process.env.REACT_APP_BASE_URL}/standings/races/${year}`);
        const data = await repsonse.json();
        setRaces(data.races);
        console.log("running races");
        
      };
      fetchRacesByYear();
    }, [year]
  );

  useEffect(
    () => {
      if(races[0]){
      fetchDetails(races[0])
      }
    }, [races]
  )




	const fetchResults = async (raceId) => {
				const repsonse = await fetch(`${process.env.REACT_APP_BASE_URL}/standings/results/${raceId}`);
        		const data = await repsonse.json();
        		setResults(data.results);
			}
		
  
  
	const fetchCircuit = async (circuitId) => {
				const repsonse = await fetch(`${process.env.REACT_APP_BASE_URL}/standings/circuits/${circuitId}`);
        		const data = await repsonse.json();
				setCircuit(data.circuit);
			}

      const fetchDetails = (race) => {
        fetchResults(race.raceId);
        fetchCircuit(race.circuitId);
      }
  



  if(!races[0]){
    return null;
  }


  return (
    <div className="StandingsPage">
      <TabBar />
      


  <div className="MainGrid">

        <div className="LeftPane">

    
      <div className="ListBlock card">
        <p className="ListHeading">YEAR</p>
            <ul className="LeftList MyScroll YearList">
                {seasons.map(season => <li key={season} className="ListItem"><Link to={`/standings/races/${season}`}>{season}</Link></li>)}
            </ul>
          </div>

          
      <div className="ListBlock card">
        <p className="ListHeading">RACES</p>
            <ul className="LeftList MyScroll RaceList">
                {races.map(race => <li key={race.raceId} onClick={() => {fetchDetails(race)}} className="ListItem">{race.name}</li>)}
            </ul>
          </div>

          </div>


          <div className="RightPane">


            <CircuitComponent circuit={circuit}/>
            <TableComponent results={results}/>


          </div>




    </div>
        
        
    </div>
  );
}
