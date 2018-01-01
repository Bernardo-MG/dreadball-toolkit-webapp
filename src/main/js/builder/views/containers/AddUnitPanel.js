import React, { Component } from 'react';

import PropTypes from 'prop-types';

import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

import { fetch } from 'models/actions/sponsorUnit';
import { selectRatedUnits } from 'models/selectors';

import Box from 'grommet/components/Box';

import NextPageButton from 'builder/units/containers/buttons/NextPageButton';
import PreviousPageButton from 'builder/units/containers/buttons/PreviousPageButton';

import AddUnitList from 'builder/units/components/AddUnitList';

import SponsorTeamCost from 'builder/views/components/SponsorTeamCost';

class AddUnitPanel extends Component {

   componentDidMount() {
      this.props.action();
   }

   render() {
      return (
         <Box margin='small'>
            <Box margin='small'>
               <SponsorTeamCost />
            </Box>
            <AddUnitList source={this.props.units} />
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

AddUnitPanel.propTypes = {
   action: PropTypes.func.isRequired,
   units: PropTypes.array.isRequired
};

const mapStateToProps = (state) => {
   return {
      units: selectRatedUnits(state)
   };
};

const mapDispatchToProps = (dispatch) => {
   return {
      action: bindActionCreators(fetch, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(AddUnitPanel);
