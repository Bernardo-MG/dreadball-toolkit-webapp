import React from 'react';

import LoadableDbxUnitTable from '../../containers/LoadableDbxUnitTable';

const DbxPlayers = () => {
     return (
         <div>
            <h1>DBX players</h1>
            <LoadableDbxUnitTable/>
         </div>
     );
};

export default DbxPlayers;
module.exports = DbxPlayers;