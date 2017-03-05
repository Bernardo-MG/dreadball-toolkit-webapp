import React from 'react';
import { Card } from 'react-toolbox/lib/card';
import LoadableDbxUnitTable from '../../../containers/LoadableDbxUnitTable';

const DbxPlayers = () => {
   return (
      <div>
         <h1>DBX players</h1>
         <Card>
            <LoadableDbxUnitTable/>
         </Card>
      </div>
   );
};

export default DbxPlayers;