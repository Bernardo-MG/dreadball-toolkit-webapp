import React, { Component } from 'react';

import Box from 'grommet/components/Box';
import Sidebar from 'grommet/components/Sidebar';
import Header from 'grommet/components/Header';
import Heading from 'grommet/components/Heading';
import Title from 'grommet/components/Title';
import Menu from 'grommet/components/Menu';
import Button from 'grommet/components/Button';

import SponsorAffinitiesList from 'builder/affinities/containers/SponsorAffinitiesList';
import SponsorUnitNameList from 'builder/units/containers/SponsorUnitNameList';

import SponsorTeamCost from 'builder/views/components/SponsorTeamCost';

import SponsorAssetsForm from 'builder/views/components/SponsorAssetsForm';
import SponsorNameInput from 'builder/sponsors/containers/SponsorNameInput';

import BoundDbxTeamPlayersPanel from 'builder/views/containers/BoundDbxTeamPlayersPanel';

class SponsorTeamView extends Component {

   state = { showUnits: false };

   showUnits = () => {
      this.setState({ showUnits: true });
   }

   showAssets = () => {
      this.setState({ showUnits: false });
   }

   render() {
      let view = null;

      if (this.state.showUnits) {
         view =
            <BoundDbxTeamPlayersPanel />;
      } else {
         view =
            <Box justify='center' align='center' pad='medium'>
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
            </Box>;
      }

      return (
         <Box direction='row' full={true} flex={true}>
            <Box
               justify='center'
               align='center'
               pad='medium'>
               <Sidebar>
                  <Header pad='medium'
                     justify='between'>
                     <Title>options</Title>
                  </Header>
                  <Box flex='grow'
                     justify='start'>
                     <Menu primary={true}>
                        <Button onClick={this.showAssets}>assets</Button>
                        <Button onClick={this.showUnits}>units</Button>
                     </Menu>
                  </Box>
               </Sidebar>
            </Box>
            <Box
               justify='center'
               align='center'
               pad='medium'
               full={true} flex={true}>
               { view }
            </Box>
         </Box>
      );
   }
}


export default SponsorTeamView;
