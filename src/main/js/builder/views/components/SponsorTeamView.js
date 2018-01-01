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

   state = { showUnits: false, showSidebar: true };

   showUnits = () => {
      this.setState({ showUnits: true });
   }

   showAssets = () => {
      this.setState({ showUnits: false });
   }

   toggleSideBar = () => {
      this.setState({ showSidebar: !this.state.showSidebar });
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
               pad='medium'
               full={true} flex={true}>
               { view }
            </Box>
            <SponsorTeamViewSidebar onSelectAssets={this.showAssets} onSelectUnits={this.showUnits} />
         </Box>
      );
   }
}

export default SponsorTeamView;
