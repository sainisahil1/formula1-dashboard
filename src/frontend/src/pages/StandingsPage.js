import { React } from "react";
import { TabBar } from "./../components/TabBar";
import {BrowserRouter as Router, Link} from "react-router-dom"

import "./../styles/standing_page.css";
import { CircuitComponent } from "../components/CircuitComponent";



export const StandingsPage = () => {
  return (
    <div className="StandingsPage">
      <TabBar />
      <Router>


  <div className="MainGrid">

        <div class="LeftPane">

    {/**Year list */}
      <div className="ListBlock card">
        <p className="ListHeading">YEAR</p>
            <ul className="LeftList MyScroll YearList">
                <li className="ListItem"><Link>2001</Link></li>
                <li className="ListItem"><Link>2002</Link></li>
                <li className="ListItem"><Link>2003</Link></li>
                <li className="ListItem"><Link>2004</Link></li>
                <li className="ListItem"><Link>2005</Link></li>
                <li className="ListItem"><Link>2006</Link></li> 
                <li className="ListItem"><Link>2007</Link></li> 
                <li className="ListItem"><Link>2008</Link></li>
                <li className="ListItem"><Link>2009</Link></li>
                <li className="ListItem"><Link>2010</Link></li>
                <li className="ListItem"><Link>2011</Link></li>
                <li className="ListItem"><Link>2013</Link></li>
                <li className="ListItem"><Link>2014</Link></li>
            </ul>
          </div>

          {/**Year list */}
      <div className="ListBlock card">
        <p className="ListHeading">RACES</p>
            <ul className="LeftList MyScroll RaceList">
                <li className="ListItem"><Link>Austria</Link></li>
                <li className="ListItem"><Link>Styria</Link></li>
                <li className="ListItem"><Link>Hungary</Link></li>
                <li className="ListItem"><Link>Great Britain</Link></li>
                <li className="ListItem"><Link>70th Anniversary</Link></li>
                <li className="ListItem"><Link>Spain</Link></li> 
                <li className="ListItem"><Link>Belgium</Link></li> 
                <li className="ListItem"><Link>Italy</Link></li>
                <li className="ListItem"><Link>Tuscany</Link></li>
                <li className="ListItem"><Link>Russia</Link></li>
                <li className="ListItem"><Link>Eifel</Link></li>
                <li className="ListItem"><Link>Portugal</Link></li>
                <li className="ListItem"><Link>Emilia Romagna</Link></li>
                <li className="ListItem"><Link>Turkey</Link></li>
                <li className="ListItem"><Link>Bahrain</Link></li>
                <li className="ListItem"><Link>Sakhir</Link></li>
                <li className="ListItem"><Link>Abu Dhabi</Link></li>
            </ul>
          </div>

          </div>


          <div className="RightPane">

            <CircuitComponent/>


          </div>




    </div>
        
        </Router>
    </div>
  );
}
