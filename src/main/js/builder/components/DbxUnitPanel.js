import React from 'react';

import PropTypes from 'prop-types';

import Box from 'grommet/components/Box';
import Columns from 'grommet/components/Columns';
import Heading from 'grommet/components/Heading';
import Label from 'grommet/components/Label';
import Value from 'grommet/components/Value';

import AddUnitButton from 'builder/containers/button/AddUnitButton';

const DbxUnitPanel = (props) =>
   <Box>
      <AddUnitButton unit={props.source.name} />
      <Box direction='row'>
         <Heading tag='h1'>{props.source.name}</Heading>
      </Box>
      <Label>{props.source.role}</Label>
      <Heading tag='h2'>abilities</Heading>
      <Label>{props.source.abilities}</Label>
      <Heading tag='h2'>attributes</Heading>
      <Box>
         <Columns size='small'>
            <Box pad='small'>
               <Value value={props.source.movement} label='movement' />
            </Box>
            <Box pad='small'>
               <Value value={props.source.strength} label='strength' />
            </Box>
            <Box pad='small'>
               <Value value={props.source.speed} label='speed' />
            </Box>
            <Box pad='small'>
               <Value value={props.source.skill} label='skill' />
            </Box>
            <Box pad='small'>
               <Value value={props.source.armor} label='armor' />
            </Box>
         </Columns>
      </Box>
      <Columns size='small'>
         <Box pad='small'>
            <Value value={props.source.cost} label='cost' />
         </Box>
      </Columns>
   </Box>;

DbxUnitPanel.propTypes = {
   source: PropTypes.object.isRequired
};

export default DbxUnitPanel;
