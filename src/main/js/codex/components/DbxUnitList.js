import React from 'react';

import PropTypes from 'prop-types';

import { injectIntl } from 'react-intl';

import Accordion from 'grommet/components/Accordion';
import AccordionPanel from 'grommet/components/AccordionPanel';
import Box from 'grommet/components/Box';

import DbxUnitPanel from 'codex/components/DbxUnitPanel';

import unitNameMessages from 'i18n/unitName';

const DbxUnitList = (props) =>
   <Accordion>
      { props.source.map((unit, i) =>
         <AccordionPanel heading={props.intl.formatMessage(unitNameMessages[unit.name])} key={i}>
            <Box pad='small'>
               <DbxUnitPanel source={unit} />
            </Box>
         </AccordionPanel>
      )}
   </Accordion>;

DbxUnitList.propTypes = {
   source: PropTypes.array.isRequired,
   intl: PropTypes.object.isRequired
};

export default injectIntl(DbxUnitList);
