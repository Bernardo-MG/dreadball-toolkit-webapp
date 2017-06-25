import React from 'react';

import Button from 'grommet/components/Button';
import Form from 'grommet/components/Form';
import FormField from 'grommet/components/FormField';
import TextInput from 'grommet/components/TextInput';
import NumberInput from 'grommet/components/NumberInput';

import SponsorTeamUnitTable from 'builder/containers/SponsorTeamUnitTable';
import SponsorAddUnitTable from 'builder/containers/SponsorAddUnitTable';
import SponsorAffinityList from 'builder/containers/SponsorAffinityList';
import CheerleadersInput from 'builder/containers/CheerleadersInput';
import CoachingDiceInput from 'builder/containers/CoachingDiceInput';
import MediBotInput from 'builder/containers/MediBotInput';
import NastySurpriseCardInput from 'builder/containers/NastySurpriseCardInput';
import SpecialMoveCardInput from 'builder/containers/SpecialMoveCardInput';
import WagerInput from 'builder/containers/WagerInput';
import SponsorRankValue from 'builder/containers/SponsorRankValue';

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
                  <CoachingDiceInput id='coaching_dice' name='coaching_dice' min={0} max={100}/>
               </FormField>
               <FormField label='special_move_card'>
                  <SpecialMoveCardInput id='special_move_card' name='special_move_card' min={0} max={100}/>
               </FormField>
               <FormField label='nasty_surprise_card'>
                  <NastySurpriseCardInput id='nasty_surprise_card' name='nasty_surprise_card' min={0} max={100}/>
               </FormField>
               <FormField label='wager'>
                  <WagerInput id='wager' name='wager' min={0} max={100}/>
               </FormField>
               <FormField label='medibot'>
                  <MediBotInput id='medibot' name='medibot' min={0} max={100}/>
               </FormField>
               <FormField label='cheerleaders'>
                  <CheerleadersInput id='cheerleaders' name='cheerleaders' min={0} max={100}/>
               </FormField>
            </Form>
            <SponsorTeamUnitTable />
            <h1>add_player</h1>
            <SponsorAddUnitTable />
         </div>
   );
};

export default SponsorTeamView;
