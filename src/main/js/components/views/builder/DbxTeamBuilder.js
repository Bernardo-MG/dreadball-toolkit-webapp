import React, { Component } from 'react'
import SponsorAffinitiesView from './SponsorAffinitiesView';
import SponsorTeamView from './SponsorTeamView';

class DbxTeamBuilder extends Component {

   state = { affinitiesChosen : false };
   
   finishedAffinities = () => {
      this.setState({ affinitiesChosen : true} );
   };

   render() {
      let view = null;
      
      if(!this.state.affinitiesChosen) { 
         view = <SponsorAffinitiesView onClick={ this.finishedAffinities } />;
      } else {
         view = <SponsorTeamView source={this.props.source} />;
      }
      
      return (
         <div>
            { view }
         </div>
      );
   };
   
};

export default DbxTeamBuilder;