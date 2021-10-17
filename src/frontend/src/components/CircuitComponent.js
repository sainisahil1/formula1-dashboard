import { React } from "react";
import "./../styles/circuit_card.css"
import "./../styles/standing_page.css"

export const CircuitComponent = ({circuit}) => {

	if(!circuit)return null;
	 

  return (
    <div className="CircuitMain card">
<h2>{circuit.name}</h2>
	  <div className="CircuitContent MyScroll">
  		<p>Location: {circuit.location}</p>
  		<p>Country: {circuit.country}</p>
		  <a href={"https://maps.google.com/?q=" + circuit.lat + "," + circuit.lng} rel="noreferrer" target="_blank" className="Locate">Locate on map</a>
	  </div>
    </div>
  );
}
