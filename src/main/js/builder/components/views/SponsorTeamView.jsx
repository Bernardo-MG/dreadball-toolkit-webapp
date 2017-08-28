import React, { Component } from 'react';

import Box from 'grommet/components/Box';
import Heading from 'grommet/components/Heading';
import Tab from 'grommet/components/Tab';
import Tabs from 'grommet/components/Tabs';

import SponsorAddUnitTable from 'builder/containers/SponsorAddUnitTable';
import SponsorAffinityList from 'builder/containers/SponsorAffinityList';
import SponsorUnitList from 'builder/containers/SponsorUnitList';

import SponsorTeamCost from 'builder/components/SponsorTeamCost';

import SponsorAssetsForm from 'builder/components/forms/SponsorAssetsForm';
import SponsorNameInput from 'builder/containers/SponsorNameInput';

import SponsorTeamEditionLayer from 'builder/components/layers/SponsorTeamEditionLayer';

import BoundDbxTeamPlayersPanel from 'builder/containers/BoundDbxTeamPlayersPanel';

import EditionButton from 'components/buttons/EditionButton';

class SponsorTeamView extends Component {

   state = {
      editingAffinities: false,
      editingPlayers: false
   };

   editAffinities = () => {
      this.setState({ ...this.state, editingAffinities: true });
   };

   finishEditAffinities = () => {
      this.setState({ ...this.state, editingAffinities: false });
   };

   editPlayers = () => {
      this.setState({ ...this.state, editingPlayers: true });
   };

   finishEditPlayers = () => {
      this.setState({ ...this.state, editingPlayers: false });
   };

   render() {
      let view = null;

      if (this.state.editingPlayers) {
         view =
            <SponsorTeamEditionLayer title='players' onClose={ this.finishEditPlayers }>
               <SponsorAddUnitTable />
            </SponsorTeamEditionLayer>;
      } else {
         view =
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
                              <EditionButton onClick={ this.editAffinities } a11yTitle='edit_affinities' />
                           </Box>
                           <SponsorAffinityList />
                        </Box>
                        <Box size='medium'>
                           <Box direction='row'>
                              <Heading tag='h2'>players</Heading>
                              <EditionButton onClick={ this.editPlayers } a11yTitle='edit_players' />
                           </Box>
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
      }

      return (
         view
      );
   }

}

export default SponsorTeamView;
