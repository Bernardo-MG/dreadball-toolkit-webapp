import React, { Component } from 'react';

import PropTypes from 'prop-types';

import { injectIntl } from 'react-intl';

import Article from 'grommet/components/Article';
import Box from 'grommet/components/Box';
import Button from 'grommet/components/Button';
import Header from 'grommet/components/Header';
import Heading from 'grommet/components/Heading';
import Split from 'grommet/components/Split';

import MoreIcon from 'grommet/components/icons/base/More';

import SponsorAffinitiesList from 'builder/affinities/containers/SponsorAffinitiesList';
import SponsorTeamPlayers from 'builder/players/containers/SponsorTeamPlayers';

import SponsorTeamCost from 'builder/views/components/SponsorTeamCost';

import ButtonsSidebar from 'components/ButtonsSidebar';

import SponsorAssetsForm from 'builder/views/components/SponsorAssetsForm';
import SponsorNameInput from 'builder/sponsors/containers/SponsorNameInput';

import SponsorPlayersOptions from 'builder/players/containers/SponsorPlayersOptions';

import TeamReportButton from 'builder/views/containers/TeamReportButton';

import teamBuilderMessages from 'i18n/teamBuilder';

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

   _onToggleSideBar() {
      const visible = this.state.sidebarVisible;

      this.setState({
         ...this.state,
         sidebarVisible: !visible
      });
   }

   _onResponsiveToggleSideBar(columns) {
      const small = columns === 'single';
      const visible = !small;

      this.setState({
         ...this.state,
         sidebarVisible: visible,
         smallScreen: small
      });
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

      let side;
      if (this.state.sidebarVisible) {
         side = <ButtonsSidebar options={options} />;
      }

      const toggle = this._onToggleSideBar.bind(this);
      const toggleResponsive = this._onResponsiveToggleSideBar.bind(this);

      let toggleSideButton;
      if (!this.state.sidebarVisible && this.state.smallScreen) {
         toggleSideButton = <Button onClick={() => toggle()} icon={<MoreIcon/>} />;
      }

      const priority = (this.state.sidebarVisible && this.state.smallScreen ? 'right' : 'left');

      return (
         <Split priority={priority} flex="left" separator={true} onResponsive={toggleResponsive}>
            <Article>
               <Header>
                  <Box direction='row'>
                     <SponsorTeamCost />
                     <TeamReportButton />
                     {toggleSideButton}
                  </Box>
               </Header>
               { view }
            </Article>
            {side}
         </Split>
      );
   }
}

SponsorTeamView.propTypes = {
   onLoadPlayers: PropTypes.func.isRequired,
   intl: PropTypes.object.isRequired
};

export default injectIntl(SponsorTeamView);
