import React, { Component } from 'react';

import PropTypes from 'prop-types';

import Box from 'grommet/components/Box';

import NextPageButton from 'builder/units/containers/buttons/NextPageButton';
import PreviousPageButton from 'builder/units/containers/buttons/PreviousPageButton';

import AddDbxUnitList from 'builder/units/components/AddDbxUnitList';

import SponsorTeamCost from 'builder/views/components/SponsorTeamCost';

class DbxTeamPlayersPanel extends Component {

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
         <Box margin='small'>
            <Box margin='small'>
               <SponsorTeamCost />
            </Box>
            <AddDbxUnitList source={this.props.units} />
            <Box direction='row'>
               <Box margin='small'>
                  <PreviousPageButton />
               </Box>
               <Box margin='small'>
                  <NextPageButton />
               </Box>
            </Box>
         </Box>
      );
   }

}

DbxTeamPlayersPanel.propTypes = {
   units: PropTypes.array.isRequired
};

export default DbxTeamPlayersPanel;
