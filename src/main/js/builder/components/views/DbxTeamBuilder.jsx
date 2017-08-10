import React, { Component } from 'react';

import PropTypes from 'prop-types';

import SponsorAffinitiesView from 'builder/components/views/SponsorAffinitiesView';
import SponsorTeamView from 'builder/components/views/SponsorTeamView';

class DbxTeamBuilder extends Component {

   state = { affinitiesChosen: false };
   handleFinishedAffinities;

   finishedAffinities = () => {
      this.setState({ affinitiesChosen: true });
      this.handleFinishedAffinities();
   };

   constructor(props) {
      super(props);

      this.handleFinishedAffinities = props.handleFinishedAffinities;
   }

   render() {
      let view = null;

      if (this.state.affinitiesChosen) {
         view = <SponsorTeamView />;
      } else {
         view = <SponsorAffinitiesView onClick={ this.finishedAffinities } />;
      }

      return (
         view
      );
   }

}

DbxTeamBuilder.propTypes = {
   handleFinishedAffinities: PropTypes.func.isRequired
};

export default DbxTeamBuilder;
