import React from 'react';

import LoadableUnitTable from '../containers/LoadableUnitTable';

class DbxPlayers extends React.Component {
   render() {
         return (
	         <div>
	            <h1>DBX players</h1>
	            <LoadableUnitTable/>
	         </div>
         );
     };
};

export default DbxPlayers;
module.exports = DbxPlayers;