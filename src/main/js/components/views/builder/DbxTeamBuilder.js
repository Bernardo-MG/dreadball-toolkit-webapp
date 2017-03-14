import React, { Component } from 'react'
import { Button } from 'react-toolbox/lib/button';
import AffinityGroupsComboPanel from '../../../containers/AffinityGroupsComboPanel';


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
         return (
            <div>
               <AffinityGroupsComboPanel />
               <Button onClick={ this.choosedAffinities } label='accept' raised primary />
            </div>
         );
      } else {
         return (
            <div/>
         );
      }
   };
   
};

export default DbxTeamBuilder;