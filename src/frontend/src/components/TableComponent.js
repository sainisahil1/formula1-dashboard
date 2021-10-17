import { React } from "react";
import "./../styles/table_card.css"
import "./../styles/standing_page.css"

export const TableComponent = ({results}) => {




	if(!results){
		return null;
	}
  return (
    
	  <div className="TableMain MyScroll card">
		  <table className="TableContent">
			  <thead>
			  <tr>
				  <th>POS</th>
				  <th>DRIVER</th>
				  <th>CAR</th>
				  <th>LAPS</th>
				  <th>TIME/RETIRED</th>
				  <th>PTS</th>
			  </tr>
			  </thead>
			  <tbody>
			  {results.map(result => 
				<tr key={result.resultId}>
					<td>{result.positionText}</td>
					<td>{result.driverName}</td>
					<td>{result.constructorName}</td>
					<td>{result.laps}</td>
					<td>{result.absoluteTime}</td>
					<td>{result.points}</td>
			  </tr>
			  )}
			  </tbody>
		  </table>
	  </div>
    
  );
}
