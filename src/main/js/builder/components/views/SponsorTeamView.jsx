import React from 'react';

import Box from 'grommet/components/Box';
import Heading from 'grommet/components/Heading';
import Tab from 'grommet/components/Tab';
import Tabs from 'grommet/components/Tabs';

import SponsorAffinityList from 'builder/containers/SponsorAffinityList';
import SponsorUnitList from 'builder/containers/SponsorUnitList';

import SponsorTeamCost from 'builder/components/SponsorTeamCost';

import SponsorAssetsForm from 'builder/components/forms/SponsorAssetsForm';
import SponsorNameInput from 'builder/containers/input/SponsorNameInput';

import BoundDbxTeamPlayersPanel from 'builder/containers/BoundDbxTeamPlayersPanel';

import EditionButton from 'components/buttons/EditionButton';

const SponsorTeamView = () =>
   <Tabs>
      <Tab title='First Title'>
         <Box>
            <Box>
               <SponsorTeamCost />
            </Box>
            <Box>
               <SponsorNameInput />
            </Box>
            <Heading tag='h2'>assets</Heading>
            <SponsorAssetsForm />
            <Box direction='row'>
               <Box size='medium'>
                  <Box direction='row'>
                     <Heading tag='h2'>affinities</Heading>
                  </Box>
                  <SponsorAffinityList />
               </Box>
               <Box size='medium'>
                  <Heading tag='h2'>players</Heading>
                  <SponsorUnitList />
               </Box>
            </Box>
         </Box>
      </Tab>
      <Tab title='players'>
         <Box>
            <SponsorTeamCost />
         </Box>
         <Box>
            <BoundDbxTeamPlayersPanel />
         </Box>
      </Tab>
   </Tabs>;

export default SponsorTeamView;
