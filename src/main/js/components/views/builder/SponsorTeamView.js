import React from 'react';
import StatefulInput from '../../StatefulInput';
import TeamBuilderUnitTable from '../../TeamBuilderUnitTable';
import LoadableTeamBuilderUnitTable from '../../../containers/LoadableTeamBuilderUnitTable';
import { Button, IconButton } from 'react-toolbox/lib/button';
import { Layout, NavDrawer, Panel, Sidebar } from 'react-toolbox';

class SponsorTeamView extends React.Component {
   state = {
      sidebarPinned: false,
      builder: {},
      affinities: [],
   };
   
   constructor(props) {
      super(props);
      this.state.builder = props.source;
      this.state.affinities = this.state.builder.sponsorChosenAffinities.join(", ");
   }
   
   toggleDrawerActive = () => {
      this.setState({ drawerActive: !this.state.drawerActive });
   };
   
   toggleDrawerPinned = () => {
      this.setState({ drawerPinned: !this.state.drawerPinned });
   }
   
   toggleSidebar = () => {
      this.setState({ sidebarPinned: !this.state.sidebarPinned });
   };

   render() {
      return (
         <Layout>
            <Panel>
               <div>
                  <StatefulInput type='text' label='sponsor_name' maxLength={16} />
                  <p>chosen_affinities: {this.state.affinities}</p>
                  <p>sponsor_rank: {this.state.builder.sponsor.rank}</p>
                  <h1>spend_rank</h1>
                  <Button label='additional_affinity' raised primary />
                  <StatefulInput type='number' label='coaching_dice' maxLength={3} />
                  <StatefulInput type='number' label='special_move_card' maxLength={3} />
                  <StatefulInput type='number' label='nasty_surprise_card' maxLength={3} />
                  <StatefulInput type='number' label='wager' maxLength={3} />
                  <StatefulInput type='number' label='medibot' maxLength={3} />
                  <StatefulInput type='number' label='cheerleaders' maxLength={3} />
                  <h1>players</h1>
                  <TeamBuilderUnitTable/>
                  <Button label='add_player' raised primary />
                  <Button label='Show sidebar' onClick={this.toggleSidebar} />
               </div>
            </Panel>
            <Sidebar pinned={ this.state.sidebarPinned } width={ 5 }>
               <div><IconButton icon='close' onClick={ this.toggleSidebar }/></div>
               <div>
                  <LoadableTeamBuilderUnitTable/>
               </div>
            </Sidebar>
         </Layout>
      );
   }
}

export default SponsorTeamView;