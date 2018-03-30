import React from 'react';

import PropTypes from 'prop-types';

import { injectIntl } from 'react-intl';

import Box from 'grommet/components/Box';
import Button from 'grommet/components/Button';
import Form from 'grommet/components/Form';
import Heading from 'grommet/components/Heading';

import SponsorAffinityAvailabilitySelectionPanel from 'builder/views/containers/SponsorAffinityAvailabilitySelectionPanel';
import SimpleView from 'views/containers/SimpleView';

import labelMessages from 'i18n/label';
import teamBuilderMessages from 'i18n/teamBuilder';

const SponsorAffinitiesView = (props) =>
   <SimpleView>
      <Form>
         <Heading>{props.intl.formatMessage(teamBuilderMessages.choose_affinities)}</Heading>
         <SponsorAffinityAvailabilitySelectionPanel />
         <Box justify='center' align='center' margin='small'>
            <Button onClick={ props.onClick } label={props.intl.formatMessage(labelMessages.accept)} />
         </Box>
      </Form>
   </SimpleView>;

SponsorAffinitiesView.propTypes = {
   onClick: PropTypes.func.isRequired,
   intl: PropTypes.object.isRequired
};

export default injectIntl(SponsorAffinitiesView);
