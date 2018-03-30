import React, { Component } from 'react';

import PropTypes from 'prop-types';

import SponsorAffinitiesView from 'builder/views/components/SponsorAffinitiesView';
import SponsorTeamView from 'builder/views/components/SponsorTeamView';

class DbxTeamBuilder extends Component {

   state = { affinitiesChosen: false };
   onFinishAffinities;

   onAcceptAffinities = () => {
      this.setState({ affinitiesChosen: true });
      this.onFinishAffinities();
   };

   constructor(props) {
      super(props);

      this.onFinishAffinities = props.onFinishAffinities;
   }

   render() {
      let view = null;

      if (this.state.affinitiesChosen) {
         view = <SponsorTeamView onLoadPlayers={this.props.onLoadPlayers} />;
      } else {
         view = <SponsorAffinitiesView onClick={ this.onAcceptAffinities } />;
      }

      return (
         view
      );
   }

}

DbxTeamBuilder.propTypes = {
   onLoadPlayers: PropTypes.func.isRequired,
   onFinishAffinities: PropTypes.func.isRequired
};

export default DbxTeamBuilder;
