import { React } from "react";
import "./../styles/circuit_card.css"
import "./../styles/standing_page.css"

export const CircuitComponent = () => {
  return (
    <div className="CircuitCard card">
	  <p className="ContentHeading">Circuit</p>
	  <div className="CircuitContent MyScroll">
		  <p>Albert Park Grand Prix Circuit</p>
		  <p>Location: Australia</p>
		  <p>Country: UK</p>
		  <a href="https://maps.google.com/?q=-37.8497,144.968" target="_blank" className="Locate">Locate on map</a>
	  </div>
    </div>
  );
}
