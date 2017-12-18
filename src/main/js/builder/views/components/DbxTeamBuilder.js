import React, { Component } from 'react';

import PropTypes from 'prop-types';

import Box from 'grommet/components/Box';

import SponsorAffinitiesView from 'builder/views/components/SponsorAffinitiesView';
import SponsorTeamView from 'builder/views/components/SponsorTeamView';

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
         view =
            <Box justify='center' align='center' pad='medium'>
               <SponsorAffinitiesView onClick={ this.finishedAffinities } />
            </Box>;
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
