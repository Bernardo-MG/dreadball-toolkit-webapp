import React from 'react';

import UnitTable from '../component/UnitTable';

class DbxPlayers extends React.Component {
   render() {
         return (
	         <div>
	            <h1>DBX players</h1>
	            <UnitTable/>
	         </div>
         );
     };
};

export default DbxPlayers;
module.exports = DbxPlayers;