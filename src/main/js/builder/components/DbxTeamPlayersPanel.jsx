import React, { Component } from 'react';

import PropTypes from 'prop-types';

import Box from 'grommet/components/Box';
import Split from 'grommet/components/Split';

import NextPageButton from 'containers/NextPageButton';
import PreviousPageButton from 'containers/PreviousPageButton';

import DbxUnitList from 'codex/components/DbxUnitList';
import DbxUnitPanel from 'codex/components/DbxUnitPanel';

class DbxTeamPlayersPanel extends Component {

   state = { selected: '' };

   units = [];

   selectUnit = (selected) => {
      const unit = this.units[selected];

      this.setState({ selected: unit });
   }

   constructor(props) {
      super(props);

      this.units = props.units;
   }

   componentWillReceiveProps(props) {
      this.units = props.units;
   }

   render() {
      let details;
      if (this.state.selected) {
         details = <DbxUnitPanel source={this.state.selected} />;
      } else {
         details = <div/>;
      }

      return (
            <Split flex='right' showOnResponsive='both' separator={true}>
               <Box justify='center' align='center' pad='medium'>
                  <DbxUnitList onSelect={this.selectUnit} source={this.props.units} />
                  <Box direction='row'>
                     <Box margin='small'>
                        <PreviousPageButton />
                     </Box>
                     <Box margin='small'>
                        <NextPageButton />
                     </Box>
                  </Box>
               </Box>
               <Box pad='small'>
                  { details }
               </Box>
             </Split>
      );
   }
}

DbxTeamPlayersPanel.propTypes = {
   units: PropTypes.array.isRequired
};

export default DbxTeamPlayersPanel;
