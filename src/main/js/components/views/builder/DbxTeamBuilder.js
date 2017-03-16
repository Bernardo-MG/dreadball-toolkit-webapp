import React, { Component } from 'react'
import SponsorAffinitiesView from './SponsorAffinitiesView';
import SponsorTeamView from './SponsorTeamView';

class DbxTeamBuilder extends Component {

   state = { affinitiesChosen : false };
   
   constructor(props) {
      super(props);
   }
   
   choosedAffinities = () => {
      this.setState({ affinitiesChosen : true} );
   };

   render() {
      let view = null;
      
      if(!this.state.affinitiesChosen) { 
         view = <SponsorAffinitiesView onClick={ this.choosedAffinities } />;
      } else {
         view = <SponsorTeamView />;
      }
      
      return (
         <div>
            { view }
         </div>
      );
   };
   
};

export default DbxTeamBuilder;