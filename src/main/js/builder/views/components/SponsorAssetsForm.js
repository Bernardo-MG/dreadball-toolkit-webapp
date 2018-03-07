import React from 'react';

import PropTypes from 'prop-types';

import { injectIntl } from 'react-intl';

import Box from 'grommet/components/Box';
import Form from 'grommet/components/Form';
import FormField from 'grommet/components/FormField';

import CheerleadersInput from 'builder/assets/containers/CheerleadersInput';
import CoachingDiceInput from 'builder/assets/containers/CoachingDiceInput';
import MediBotInput from 'builder/assets/containers/MediBotInput';
import NastySurpriseCardInput from 'builder/assets/containers/NastySurpriseCardInput';
import SpecialMoveCardInput from 'builder/assets/containers/SpecialMoveCardInput';
import WagerInput from 'builder/assets/containers/WagerInput';

import teamBuilderMessages from 'i18n/teamBuilder';

const SponsorAssetsForm = (props) =>
   <Form>
      <Box direction='row'>
         <FormField label={props.intl.formatMessage(teamBuilderMessages.coaching_dice)}>
            <CoachingDiceInput id='coaching_dice' name='coaching_dice' min={0} max={100}/>
         </FormField>
         <FormField label={props.intl.formatMessage(teamBuilderMessages.special_move_cards)}>
            <SpecialMoveCardInput id='special_move_cards' name='special_move_cards' min={0} max={100}/>
         </FormField>
      </Box>
      <Box direction='row'>
         <FormField label={props.intl.formatMessage(teamBuilderMessages.nasty_surprise_cards)}>
            <NastySurpriseCardInput id='nasty_surprise_cards' name='nasty_surprise_cards' min={0} max={100}/>
         </FormField>
         <FormField label={props.intl.formatMessage(teamBuilderMessages.wagers)}>
            <WagerInput id='wagers' name='wagers' min={0} max={100}/>
         </FormField>
      </Box>
      <Box direction='row'>
         <FormField label={props.intl.formatMessage(teamBuilderMessages.medibots)}>
            <MediBotInput id='medibots' name='medibots' min={0} max={100}/>
         </FormField>
         <FormField label={props.intl.formatMessage(teamBuilderMessages.cheerleaders)}>
            <CheerleadersInput id='cheerleaders' name='cheerleaders' min={0} max={100}/>
         </FormField>
      </Box>
   </Form>;

SponsorAssetsForm.propTypes = {
   intl: PropTypes.object.isRequired
};

export default injectIntl(SponsorAssetsForm);
