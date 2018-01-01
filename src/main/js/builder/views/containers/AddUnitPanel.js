import React, { Component } from 'react';

import PropTypes from 'prop-types';

import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

import { selectRatedUnits } from 'models/selectors';

import Box from 'grommet/components/Box';
import Button from 'grommet/components/Button';

import AddUnitList from 'builder/units/components/AddUnitList';

import BackIcon from 'grommet/components/icons/base/CaretBack';
import NextIcon from 'grommet/components/icons/base/CaretNext';

import { fetch, movePrevPage, moveNextPage } from 'models/actions/sponsorUnit';

class AddUnitPanel extends Component {

   componentDidMount() {
      this.props.load();
   }

   render() {
      return (
         <Box margin='small' full={true}>
            <AddUnitList source={this.props.units} />
            <Box direction='row'>
               <Box margin='small'>
                  <Button onClick={this.props.pageBack} icon={<BackIcon/>} />
               </Box>
               <Box margin='small'>
                  <Button onClick={this.props.pageForward} icon={<NextIcon/>} />
               </Box>
            </Box>
         </Box>
      );
   }
}

AddUnitPanel.propTypes = {
   load: PropTypes.func.isRequired,
   pageBack: PropTypes.func.isRequired,
   pageForward: PropTypes.func.isRequired,
   units: PropTypes.array.isRequired
};

const mapStateToProps = (state) => {
   return {
      units: selectRatedUnits(state)
   };
};

const mapDispatchToProps = (dispatch) => {
   return {
      load: bindActionCreators(fetch, dispatch),
      pageBack: bindActionCreators(movePrevPage, dispatch),
      pageForward: bindActionCreators(moveNextPage, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(AddUnitPanel);
