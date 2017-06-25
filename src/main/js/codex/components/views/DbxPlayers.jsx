import React from 'react';

import Box from 'grommet/components/Box';
import Form from 'grommet/components/Form';
import Heading from 'grommet/components/Heading';
import Section from 'grommet/components/Section';

import NextPageButton from 'containers/NextPageButton';
import PreviousPageButton from 'containers/PreviousPageButton';

import LoadableDbxUnitTable from 'codex/containers/LoadableDbxUnitTable';

const DbxPlayers = () => {
   return (
      <Section primary={true} flex={true} pad='small'>
         <Heading tag='h1'>DBX players</Heading>
         <Box>
            <LoadableDbxUnitTable/>
            <Form>
               <Box direction='row'>
                  <Box margin='small'>
                     <PreviousPageButton label='previous' />
                  </Box>
                  <Box margin='small'>
                     <NextPageButton label='next' />
                  </Box>
               </Box>
            </Form>
         </Box>
      </Section>
   );
};

export default DbxPlayers;
