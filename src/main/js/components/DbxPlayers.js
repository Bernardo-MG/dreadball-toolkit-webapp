import React from 'react';

import LoadableUnitTable from '../containers/LoadableUnitTable';

const DbxPlayers = () => {
     return (
         <div>
            <h1>DBX players</h1>
            <LoadableUnitTable/>
         </div>
     );
};

export default DbxPlayers;
module.exports = DbxPlayers;