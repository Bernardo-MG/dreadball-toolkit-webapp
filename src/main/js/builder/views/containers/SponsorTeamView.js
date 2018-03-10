import React, { Component } from 'react';

import PropTypes from 'prop-types';

import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

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

import SponsorPlayersOptions from 'builder/players/containers/SponsorPlayersOptions';

import TeamReportButton from 'builder/views/containers/TeamReportButton';

import { fetch as fetchPlayers } from 'models/actions/sponsorPlayer';

import teamBuilderMessages from 'i18n/teamBuilder';

class SponsorTeamView extends Component {

   state = { view: 'assets', showSidebar: true };

   componentDidMount() {
      this.props.loadPlayers();
   }

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
         view = <SponsorPlayersOptions />;
      } else if (this.state.view === 'players') {
         view =
            <Box>
               <Heading tag='h2'>{this.props.intl.formatMessage(teamBuilderMessages.team_players)}</Heading>
               <SponsorTeamPlayers />
            </Box>;
      } else if (this.state.view === 'assets') {
         view =
            <Box justify='center' align='center' pad='medium'>
               <Box>
                  <SponsorNameInput label={this.props.intl.formatMessage(teamBuilderMessages.sponsor_name)} />
               </Box>
               <Heading tag='h2'>{this.props.intl.formatMessage(teamBuilderMessages.assets)}</Heading>
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
      options.push({ label: this.props.intl.formatMessage(teamBuilderMessages.assets), action: this.showAssets });
      options.push({ label: this.props.intl.formatMessage(teamBuilderMessages.add_players), action: this.showAddPlayers });
      options.push({ label: this.props.intl.formatMessage(teamBuilderMessages.team_players), action: this.showPlayers });
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
   loadPlayers: PropTypes.func.isRequired,
   intl: PropTypes.object.isRequired
};

const mapStateToProps = () => {
   return {};
};

const mapDispatchToProps = (dispatch) => {
   return {
      loadPlayers: bindActionCreators(fetchPlayers, dispatch)
   };
};

export default injectIntl(connect(
   mapStateToProps,
   mapDispatchToProps
)(SponsorTeamView));
