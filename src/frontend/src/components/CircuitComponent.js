import { React } from "react";
import "./../styles/circuit_card.css"
import "./../styles/standing_page.css"

export const CircuitComponent = () => {
  return (
    <div className="CircuitMain card">
	  <h2>ALBERT PARK GRAND PRIX CIRCUIT</h2>
	  <div className="CircuitContent MyScroll">
		  <p>Location: Australia</p>
		  <p>Country: UK</p>
		  <a href="https://maps.google.com/?q=-37.8497,144.968" rel="noreferrer" target="_blank" className="Locate">Locate on map</a>
	  </div>
    </div>
  );
}
