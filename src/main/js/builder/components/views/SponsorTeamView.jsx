import React from 'react';
import SponsorTeamUnitTable from 'builder/containers/SponsorTeamUnitTable';
import SponsorAddUnitTable from 'builder/containers/SponsorAddUnitTable';
import SponsorAffinityList from 'builder/containers/SponsorAffinityList';
import Form from 'grommet/components/Form';
import FormField from 'grommet/components/FormField';
import TextInput from 'grommet/components/TextInput';
import NumberInput from 'grommet/components/NumberInput';
import SponsorRankValue from 'builder/containers/SponsorRankValue';
import Button from 'grommet/components/Button';

const SponsorTeamView = (props) => {
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
            <SponsorTeamUnitTable />
            <h1>add_player</h1>
            <SponsorAddUnitTable />
         </div>
   );
}

export default SponsorTeamView;
