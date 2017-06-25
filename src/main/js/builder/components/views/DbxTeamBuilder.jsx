import React, { Component } from 'react';

import Section from 'grommet/components/Section';

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

      if (!this.state.affinitiesChosen) {
         view = <SponsorAffinitiesView onClick={ this.finishedAffinities } />;
      } else {
         view = <SponsorTeamView />;
      }

      return (
         <Section primary={true} flex={true} pad='small'>
            { view }
         </Section>
      );
   }

}

export default DbxTeamBuilder;
