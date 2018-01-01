import React, { Component } from 'react';

import Box from 'grommet/components/Box';
import Heading from 'grommet/components/Heading';

import SponsorAffinitiesList from 'builder/affinities/containers/SponsorAffinitiesList';
import SponsorUnitNameList from 'builder/units/containers/SponsorUnitNameList';

import SponsorTeamCost from 'builder/views/components/SponsorTeamCost';

import SponsorAssetsForm from 'builder/views/components/SponsorAssetsForm';
import SponsorTeamViewSidebar from 'builder/views/components/SponsorTeamViewSidebar';
import SponsorNameInput from 'builder/sponsors/containers/SponsorNameInput';

import BoundDbxTeamPlayersPanel from 'builder/views/containers/BoundDbxTeamPlayersPanel';

class SponsorTeamView extends Component {

   state = { view: 'assets', showSidebar: true };

   showUnits = () => {
      this.setState({ view: 'units' });
   }

   showAddUnits = () => {
      this.setState({ view: 'addUnits' });
   }

   showAssets = () => {
      this.setState({ view: 'assets' });
   }

   toggleSideBar = () => {
      this.setState({ showSidebar: !this.state.showSidebar });
   }

   render() {
      let view = null;

      if (this.state.view === 'addUnits') {
         view = <BoundDbxTeamPlayersPanel />;
      } else if (this.state.view === 'units') {
         view =
            <Box>
               <Heading tag='h2'>players</Heading>
               <SponsorUnitNameList />
            </Box>;
      } else if (this.state.view === 'assets') {
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
               <Box>
                  <Heading tag='h2'>affinities</Heading>
                  <SponsorAffinitiesList />
               </Box>
            </Box>;
      }

      return (
         <Box direction='row' full={true} flex={true}>
            <Box
               justify='center'
               align='center'
               pad='medium'
               full={true} flex={true}>
               { view }
            </Box>
            <SponsorTeamViewSidebar onSelectAssets={this.showAssets} onSelectAddUnits={this.showAddUnits} onSelectUnits={this.showUnits} />
         </Box>
      );
   }
}

export default SponsorTeamView;
