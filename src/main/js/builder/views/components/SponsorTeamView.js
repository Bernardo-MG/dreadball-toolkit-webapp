import React, { Component } from 'react';

import PropTypes from 'prop-types';

import { injectIntl } from 'react-intl';

import Article from 'grommet/components/Article';
import Box from 'grommet/components/Box';
import Header from 'grommet/components/Header';
import Heading from 'grommet/components/Heading';
import Split from 'grommet/components/Split';

import SponsorAffinitiesList from 'builder/affinities/containers/SponsorAffinitiesList';
import SponsorTeamPlayers from 'builder/players/containers/SponsorTeamPlayers';

import SponsorTeamCost from 'builder/views/components/SponsorTeamCost';

import ButtonsSidebar from 'components/ButtonsSidebar';

import SponsorAssetsForm from 'builder/views/components/SponsorAssetsForm';
import SponsorNameInput from 'builder/sponsors/containers/SponsorNameInput';

import AddPlayerPanel from 'builder/views/containers/AddPlayerPanel';

import TeamReportButton from 'builder/views/containers/TeamReportButton';

import teamBuilderMessages from 'i18n/teamBuilder';

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

   showAffinities = () => {
      this.setState({ view: 'affinities' });
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
            </Box>;
      } else if (this.state.view === 'affinities') {
         view =
            <Box justify='center' align='center' pad='medium'>
               <Heading tag='h2'>{this.props.intl.formatMessage(teamBuilderMessages.affinities)}</Heading>
               <SponsorAffinitiesList />
            </Box>;
      }

      const options = [];
      options.push({ label: 'assets', action: this.showAssets });
      options.push({ label: 'add_players', action: this.showAddPlayers });
      options.push({ label: 'players', action: this.showPlayers });
      options.push({ label: this.props.intl.formatMessage(teamBuilderMessages.affinities), action: this.showAffinities });

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
            <ButtonsSidebar options={options} />
         </Split>
      );
   }
}

SponsorTeamView.propTypes = {
   intl: PropTypes.object.isRequired
};

export default injectIntl(SponsorTeamView);
