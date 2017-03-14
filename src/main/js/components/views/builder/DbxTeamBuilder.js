import React, { Component } from 'react'
import { Button } from 'react-toolbox/lib/button';
import AffinityGroupsComboPanel from '../../../containers/AffinityGroupsComboPanel';

const SponsorAffinitiesView = (props) => {
   return (
      <div>
         <AffinityGroupsComboPanel />
         <Button onClick={ props.onClick } label='accept' raised primary />
      </div>
   );
};

const SponsorTeamView = () => {
   return (
      <div />
   );
};

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