import React from 'react';

import PropTypes from 'prop-types';

import { connect } from 'react-redux';

import { injectIntl } from 'react-intl';

import Box from 'grommet/components/Box';
import Button from 'grommet/components/Button';
import Form from 'grommet/components/Form';

import SponsorAffinityAvailabilitySelectionPanel from 'builder/views/containers/SponsorAffinityAvailabilitySelectionPanel';
import SimpleView from 'views/containers/SimpleView';

import { selectAllAffinitiesChosen as selectAllChosen } from 'builder/affinities/selectors';

import labelMessages from 'i18n/label';
import titleMessages from 'i18n/title';

const SponsorAffinitiesView = (props) =>
   <SimpleView title={props.intl.formatMessage(titleMessages.sponsorAffinities)}>
      <Box justify='center' align='center' margin='medium'>
         <Form>
            <SponsorAffinityAvailabilitySelectionPanel />
            <Box justify='center' align='center' margin='small'>
               <Button onClick={ props.allChosen ? props.onClick : null } label={props.intl.formatMessage(labelMessages.accept)} />
            </Box>
         </Form>
      </Box>
   </SimpleView>;

SponsorAffinitiesView.propTypes = {
   onClick: PropTypes.func.isRequired,
   allChosen: PropTypes.bool.isRequired,
   intl: PropTypes.object.isRequired
};

const mapStateToProps = (state) => {
   return {
      allChosen: selectAllChosen(state)
   };
};

const mapDispatchToProps = () => {
   return {};
};

export default injectIntl(connect(
   mapStateToProps,
   mapDispatchToProps
)(SponsorAffinitiesView));
