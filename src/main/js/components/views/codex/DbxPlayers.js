import React from 'react';
import { Card, CardActions } from 'react-toolbox/lib/card';
import LoadableDbxUnitTable from 'containers/LoadableDbxUnitTable';
import { Button } from 'react-toolbox/lib/button';

const DbxPlayers = () => {
   return (
      <div>
         <h1>DBX players</h1>
         <Card>
            <LoadableDbxUnitTable/>
            <CardActions>
               <Button label='previous' />
               <Button label='next' />
            </CardActions>
         </Card>
      </div>
   );
};

export default DbxPlayers;