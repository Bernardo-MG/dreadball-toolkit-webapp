import React, { Component } from 'react';

import Article from 'grommet/components/Article';
import Box from 'grommet/components/Box';
import Header from 'grommet/components/Header';
import Heading from 'grommet/components/Heading';
import Split from 'grommet/components/Split';

import SponsorAffinitiesList from 'builder/affinities/containers/SponsorAffinitiesList';
import SponsorTeamPlayers from 'builder/players/containers/SponsorTeamPlayers';

import SponsorTeamCost from 'builder/views/components/SponsorTeamCost';

import SponsorAssetsForm from 'builder/views/components/SponsorAssetsForm';
import SponsorTeamViewSidebar from 'builder/views/components/SponsorTeamViewSidebar';
import SponsorNameInput from 'builder/sponsors/containers/SponsorNameInput';

import AddPlayerPanel from 'builder/views/containers/AddPlayerPanel';

import TeamReportButton from 'builder/views/containers/TeamReportButton';

class SponsorTeamView extends Component {

   state = { view: 'assets', showSidebar: true };

   showPlayers = () => {
      this.setState({ view: 'players' });
   }

   showAddPlayers = () => {
      this.setState({ view: 'addPlayers' });
   }

   showAssets = () => {
      this.setState({ view: 'assets' });
   }

   toggleSideBar = () => {
      this.setState({ showSidebar: !this.state.showSidebar });
   }

   render() {
      let view = null;

      if (this.state.view === 'addPlayers') {
         view = <AddPlayerPanel />;
      } else if (this.state.view === 'players') {
         view =
            <Box>
               <Heading tag='h2'>players</Heading>
               <SponsorTeamPlayers />
            </Box>;
      } else if (this.state.view === 'assets') {
         view =
            <Box justify='center' align='center' pad='medium'>
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
         <Split flex="left" separator={true}>
            <Article>
               <Header>
                  <Box direction='row'>
                     <SponsorTeamCost />
                     <TeamReportButton />
                  </Box>
               </Header>
               { view }
            </Article>
            <SponsorTeamViewSidebar onSelectAssets={this.showAssets} onSelectAddPlayers={this.showAddPlayers} onSelectPlayers={this.showPlayers} />
         </Split>
      );
   }
}

export default SponsorTeamView;
