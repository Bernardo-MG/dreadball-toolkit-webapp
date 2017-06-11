import React from 'react';
import StatefulInput from 'components/StatefulInput';
import SponsorUnitTable from 'builder/containers/SponsorUnitTable';
import SponsorAddUnitTable from 'builder/containers/SponsorAddUnitTable';
import SponsorAffinityList from 'builder/containers/SponsorAffinityList';
import Form from 'grommet/components/Form';
import FormField from 'grommet/components/FormField';
import TextInput from 'grommet/components/TextInput';
import NumberInput from 'grommet/components/NumberInput';
import SponsorRankValue from 'builder/containers/SponsorRankValue';
import Value from 'grommet/components/Value';
import Button from 'grommet/components/Button';

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
                  <SponsorAffinityList />
                  <SponsorRankValue />
                  <h1>spend_rank</h1>
                  <Button label='additional_affinity' />
                  <FormField label='coaching_dice'>
                     <NumberInput id='coaching_dice' name='coaching_dice' max={100}/>
                  </FormField>
                  <FormField label='special_move_card'>
                     <NumberInput id='special_move_card' name='special_move_card' max={100}/>
                  </FormField>
                  <FormField label='nasty_surprise_card'>
                     <NumberInput id='nasty_surprise_card' name='nasty_surprise_card' max={100}/>
                  </FormField>
                  <FormField label='wager'>
                     <NumberInput id='wager' name='wager' max={100}/>
                  </FormField>
                  <FormField label='medibot'>
                     <NumberInput id='medibot' name='medibot' max={100}/>
                  </FormField>
                  <FormField label='cheerleaders'>
                     <NumberInput id='cheerleaders' name='cheerleaders' max={100}/>
                  </FormField>
               </Form>
               <SponsorUnitTable />
               <h1>add_player</h1>
               <SponsorAddUnitTable />
            </div>
//         <Layout>
//            <Panel>
//               <div>
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