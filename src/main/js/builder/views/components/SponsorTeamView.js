import React, { Component } from 'react';

import PropTypes from 'prop-types';

import { injectIntl } from 'react-intl';

import Box from 'grommet/components/Box';
import Heading from 'grommet/components/Heading';

import DocumentPdfIcon from 'grommet/components/icons/base/DocumentPdf';

import SponsorAffinitiesList from 'builder/affinities/containers/SponsorAffinitiesList';
import SponsorTeamPlayers from 'builder/players/containers/SponsorTeamPlayers';

import ButtonsSidebar from 'views/containers/ButtonsSidebar';

import SponsorAssetsForm from 'builder/views/components/SponsorAssetsForm';
import SponsorNameInput from 'builder/sponsors/containers/SponsorNameInput';
import SponsorTeamCost from 'builder/views/components/SponsorTeamCost';

import AffinityPlayersOptions from 'builder/players/containers/AffinityPlayersOptions';

import SidebarView from 'views/containers/SidebarView';

import teamBuilderMessages from 'i18n/teamBuilder';

import titleMessages from 'i18n/title';

class SponsorTeamView extends Component {

   constructor(props) {
      super(props);

      this.state = { view: 'assets', sidebarVisible: true, smallScreen: false };
   }

   componentDidMount() {
      this.props.onLoadPlayers();
   }

   showPlayers = () => {
      this.setState({
         ...this.state,
         view: 'players'
      });
   }

   showAddPlayers = () => {
      this.setState({
         ...this.state,
         view: 'addPlayers'
      });
   }

   showAssets = () => {
      this.setState({
         ...this.state,
         view: 'assets'
      });
   }

   showAffinities = () => {
      this.setState({
         ...this.state,
         view: 'affinities'
      });
   }

   render() {
      let view = null;

      if (this.state.view === 'addPlayers') {
         view = <Box justify='center' align='center' margin='medium'>
            <Heading tag='h2'>{this.props.intl.formatMessage(teamBuilderMessages.add_players)}</Heading>
            <AffinityPlayersOptions />
         </Box>;
      } else if (this.state.view === 'players') {
         view = <Box justify='center' align='center' margin='medium'>
            <Heading tag='h2'>{this.props.intl.formatMessage(teamBuilderMessages.team_players)}</Heading>
            <SponsorTeamPlayers />
         </Box>;
      } else if (this.state.view === 'assets') {
         view = <Box justify='center' align='center' margin='medium'>
            <SponsorNameInput label={this.props.intl.formatMessage(teamBuilderMessages.sponsor_name)} />
            <Heading tag='h2'>{this.props.intl.formatMessage(teamBuilderMessages.assets)}</Heading>
            <SponsorAssetsForm />
         </Box>;
      } else if (this.state.view === 'affinities') {
         view = <Box justify='center' align='center' margin='medium'>
            <Heading tag='h2'>{this.props.intl.formatMessage(teamBuilderMessages.affinities)}</Heading>
            <SponsorAffinitiesList />
         </Box>;
      }

      const options = [];
      options.push({ label: this.props.intl.formatMessage(teamBuilderMessages.assets), action: this.showAssets });
      options.push({ label: this.props.intl.formatMessage(teamBuilderMessages.add_players), action: this.showAddPlayers });
      options.push({ label: this.props.intl.formatMessage(teamBuilderMessages.team_players), action: this.showPlayers });
      options.push({ label: this.props.intl.formatMessage(teamBuilderMessages.affinities), action: this.showAffinities });
      options.push({ label: '', action: () => { this.props.onGenerateTeamReport(); }, icon: <DocumentPdfIcon/> });

      let side;
      if (this.state.sidebarVisible) {
         side = <ButtonsSidebar options={options} />;
      }

      return (
         <SidebarView sideBar={side} title={this.props.intl.formatMessage(titleMessages.teamBuilder)}>
            <Box justify='center' align='center' margin='medium' direction='row'>
               <SponsorTeamCost/>
            </Box>
            {view}
         </SidebarView>
      );
   }
}

SponsorTeamView.propTypes = {
   onLoadPlayers: PropTypes.func.isRequired,
   onGenerateTeamReport: PropTypes.func.isRequired,
   intl: PropTypes.object.isRequired
};

export default injectIntl(SponsorTeamView);
