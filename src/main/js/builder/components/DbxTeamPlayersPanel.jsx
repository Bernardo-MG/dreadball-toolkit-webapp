import React, { Component } from 'react';

import PropTypes from 'prop-types';

import Box from 'grommet/components/Box';
import Split from 'grommet/components/Split';

import DbxUnitPanel from 'builder/components/DbxUnitPanel';
import NextPageButton from 'builder/containers/button/NextPageButton';
import PreviousPageButton from 'builder/containers/button/PreviousPageButton';

import DbxUnitList from 'codex/components/DbxUnitList';

import AddUnitButton from 'builder/containers/button/AddUnitButton';

import SponsorTeamCost from 'builder/components/SponsorTeamCost';

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
      let addButton;
      if (this.state.selected) {
         details = <DbxUnitPanel source={this.state.selected} />;
         addButton = <AddUnitButton unit={this.state.selected.templateName} />;
      } else {
         details = <h1>pick_player</h1>;
         addButton = null;
      }

      return (
            <Split flex='right' showOnResponsive='both' separator={true}>
               <Box justify='center' align='center' pad='medium'>
                  <SponsorTeamCost />
                  <DbxUnitList onSelect={this.selectUnit} source={this.props.units} />
                  { addButton }
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
