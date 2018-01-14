import React, { Component } from 'react';

import PropTypes from 'prop-types';

import Box from 'grommet/components/Box';
import Button from 'grommet/components/Button';
import Label from 'grommet/components/Label';
import Value from 'grommet/components/Value';

import UnitList from 'codex/components/UnitList';

import BackIcon from 'grommet/components/icons/base/CaretBack';
import NextIcon from 'grommet/components/icons/base/CaretNext';

class PlayersPagesPanel extends Component {

   units = [];

   constructor(props) {
      super(props);

      this.units = props.units;
   }

   componentWillReceiveProps(props) {
      this.units = props.units;
   }

   render() {
      return (
         <Box pad='medium' full={true}>
            <UnitList source={this.props.units} />
            <Box direction='row' justify='center' align='center'>
               <Box margin='small'>
                  <Button onClick={this.props.previousPage} icon={<BackIcon/>} />
               </Box>
               <Value value={this.props.page} />
               <Label>/</Label>
               <Value value={this.props.totalPages} />
               <Box margin='small'>
                  <Button onClick={this.props.nextPage} icon={<NextIcon/>} />
               </Box>
            </Box>
         </Box>
      );
   }
}

PlayersPagesPanel.propTypes = {
   units: PropTypes.array.isRequired,
   previousPage: PropTypes.func.isRequired,
   nextPage: PropTypes.func.isRequired,
   page: PropTypes.number.isRequired,
   totalPages: PropTypes.number.isRequired
};

export default PlayersPagesPanel;
