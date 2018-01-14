import React from 'react';

import PropTypes from 'prop-types';

import { injectIntl } from 'react-intl';

import Accordion from 'grommet/components/Accordion';
import AccordionPanel from 'grommet/components/AccordionPanel';
import Box from 'grommet/components/Box';

import UnitPanel from 'codex/components/UnitPanel';

import unitNameMessages from 'i18n/unitName';

const UnitList = (props) =>
   <Accordion>
      { props.source.map((unit, i) =>
         <AccordionPanel heading={props.intl.formatMessage(unitNameMessages[unit.name])} key={i}>
            <Box pad='small'>
               <UnitPanel source={unit} />
            </Box>
         </AccordionPanel>
      )}
   </Accordion>;

UnitList.propTypes = {
   source: PropTypes.array.isRequired,
   intl: PropTypes.object.isRequired
};

export default injectIntl(UnitList);
