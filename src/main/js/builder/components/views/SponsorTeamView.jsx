import React from 'react';
import StatefulInput from 'components/StatefulInput';
import TeamBuilderUnitTable from 'builder/components/TeamBuilderUnitTable';
import LoadableUnitOptionTable from 'builder/containers/LoadableUnitOptionTable';
import Form from 'grommet/components/Form';
import FormField from 'grommet/components/FormField';
import TextInput from 'grommet/components/TextInput';
//import { Button } from 'react-toolbox/lib/button';
//import { Layout, NavDrawer, Panel, Sidebar } from 'react-toolbox';
//import { Card, CardActions } from 'react-toolbox/lib/card';
//import Dialog from 'react-toolbox/lib/dialog';

class SponsorTeamView extends React.Component {
   state = {
      showPlayerOptions: false,
      builder: {},
      affinities: [],
   };
   
   constructor(props) {
      super(props);
      this.state.sponsor = props.source;
      this.state.affinities = this.state.sponsor.affinities.join(", ");
   }
   
   toggleDrawerActive = () => {
      this.setState({ drawerActive: !this.state.drawerActive });
   };
   
   toggleDrawerPinned = () => {
      this.setState({ drawerPinned: !this.state.drawerPinned });
   }
   
   togglePlayerOptions = () => {
      this.setState({ showPlayerOptions: !this.state.showPlayerOptions });
   };
   
   dialogActions = [
      { label: "close", onClick: this.togglePlayerOptions }
   ];

   render() {
      return (
            <div>
               <Form>
                  <FormField label='sponsor_name'>
                     <TextInput id='sponsor_name' name='sponsor_name'/>
                  </FormField>
               </Form>
            </div>
//         <Layout>
//            <Panel>
//               <div>
//                  <StatefulInput type='text' label='sponsor_name' maxLength={16} />
//                  <p>chosen_affinities: {this.state.affinities}</p>
//                  <p>sponsor_rank: {this.state.builder.sponsor.rank}</p>
//                  <h1>spend_rank</h1>
//                  <Button label='additional_affinity' raised primary />
//                  <StatefulInput type='number' label='coaching_dice' maxLength={3} />
//                  <StatefulInput type='number' label='special_move_card' maxLength={3} />
//                  <StatefulInput type='number' label='nasty_surprise_card' maxLength={3} />
//                  <StatefulInput type='number' label='wager' maxLength={3} />
//                  <StatefulInput type='number' label='medibot' maxLength={3} />
//                  <StatefulInput type='number' label='cheerleaders' maxLength={3} />
//                  <h1>players</h1>
//                  <Card>
//                     <TeamBuilderUnitTable/>
//                     <CardActions>
//                        <Button label='add_player' onClick={this.togglePlayerOptions} />
//                     </CardActions>
//                  </Card>
//                  <Dialog
//                     actions={this.dialogActions}
//                     active={this.state.showPlayerOptions}
//                     onEscKeyDown={this.togglePlayerOptions}
//                     onOverlayClick={this.togglePlayerOptions}
//                     title='add_player'>
//                     <LoadableUnitOptionTable/>
//                  </Dialog>
//               </div>
//            </Panel>
//         </Layout>
      );
   }
}

export default SponsorTeamView;