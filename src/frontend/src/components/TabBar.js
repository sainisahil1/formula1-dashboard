import { React } from "react";
import "./../styles/tab_bar.css"
import logo from "./../logo-image.png";

export const TabBar = () => {
  return (
    <div className="TabBar">
	  <img src={logo} alt="Formula 1" className="LogoImage"/>
      <p id="standings_button" className="TabButton" >Standings</p>
	  <p id="standings_button" className="TabButton">Analysis</p>
    </div>
  );
}
