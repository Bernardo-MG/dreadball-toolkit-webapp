import React from 'react';
import { Card, CardActions } from 'react-toolbox/lib/card';
import LoadableDbxUnitTable from 'containers/LoadableDbxUnitTable';
import { Button } from 'react-toolbox/lib/button';
import PreviousPageButton from 'containers/PreviousPageButton';
import NextPageButton from 'containers/NextPageButton';

const DbxPlayers = () => {
   return (
      <div>
         <h1>DBX players</h1>
         <Card>
            <LoadableDbxUnitTable/>
            <CardActions>
               <PreviousPageButton label='previous' />
               <NextPageButton label='next' />
            </CardActions>
         </Card>
      </div>
   );
};

export default DbxPlayers;