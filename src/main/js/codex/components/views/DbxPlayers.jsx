import React from 'react';
import LoadableDbxUnitTable from 'codex/containers/LoadableDbxUnitTable';
import PreviousPageButton from 'containers/PreviousPageButton';
import NextPageButton from 'containers/NextPageButton';
import Box from 'grommet/components/Box';

const DbxPlayers = () => {
   return (
      <div>
         <h1>DBX players</h1>
         <Box>
            <LoadableDbxUnitTable/>
            <Box direction='row'>
               <PreviousPageButton label='previous' />
               <NextPageButton label='next' />
            </Box>
         </Box>
      </div>
   );
};

export default DbxPlayers;