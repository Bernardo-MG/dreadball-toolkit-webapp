import React from 'react';

import Box from 'grommet/components/Box';
import Heading from 'grommet/components/Heading';
import Tab from 'grommet/components/Tab';
import Tabs from 'grommet/components/Tabs';

import SponsorAffinitiesList from 'builder/affinities/containers/SponsorAffinitiesList';
import SponsorUnitNameList from 'builder/units/containers/SponsorUnitNameList';

import SponsorTeamCost from 'builder/views/components/SponsorTeamCost';

import SponsorAssetsForm from 'builder/views/components/SponsorAssetsForm';
import SponsorNameInput from 'builder/sponsors/containers/SponsorNameInput';

import BoundDbxTeamPlayersPanel from 'builder/views/containers/BoundDbxTeamPlayersPanel';

const SponsorTeamView = () =>
   <Tabs>
      <Tab title='assets'>
         <Box justify='center' align='center'>
            <Box>
               <SponsorTeamCost />
            </Box>
            <Box>
               <SponsorNameInput />
            </Box>
            <Heading tag='h2'>assets</Heading>
            <SponsorAssetsForm />
            <Box direction='row' pad='small'>
               <Box pad='small' size='medium'>
                  <Box direction='row'>
                     <Heading tag='h2'>affinities</Heading>
                  </Box>
                  <SponsorAffinitiesList />
               </Box>
               <Box pad='small' size='medium'>
                  <Heading tag='h2'>players</Heading>
                  <SponsorUnitNameList />
               </Box>
            </Box>
         </Box>
      </Tab>
      <Tab title='players'>
         <Box pad='medium' full={true}>
            <BoundDbxTeamPlayersPanel />
         </Box>
      </Tab>
   </Tabs>;

export default SponsorTeamView;
