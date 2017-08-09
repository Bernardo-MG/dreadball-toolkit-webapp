import React from 'react';

import Box from 'grommet/components/Box';
import Heading from 'grommet/components/Heading';

import NextPageButton from 'containers/NextPageButton';
import PreviousPageButton from 'containers/PreviousPageButton';

import LoadableDbxUnitTable from 'codex/containers/LoadableDbxUnitTable';

const DbxPlayers = () => {
   return (
      <Box>
         <Heading tag='h1'>dbx_players</Heading>
         <LoadableDbxUnitTable/>
         <Box direction='row'>
            <Box margin='small'>
               <PreviousPageButton label='previous' />
            </Box>
            <Box margin='small'>
               <NextPageButton label='next' />
            </Box>
         </Box>
      </Box>
   );
};

export default DbxPlayers;
