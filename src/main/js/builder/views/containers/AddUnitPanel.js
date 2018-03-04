import React, { Component } from 'react';

import PropTypes from 'prop-types';

import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

import { selectRatedUnits as selectUnits } from 'models/selectors';
import { selectLastRatedUnitPage as selectLastPage } from 'models/selectors/page';

import AddUnitScrollablePanel from 'builder/units/components/AddUnitScrollablePanel';

import AddIcon from 'grommet/components/icons/base/AddCircle';

import { fetch, moveNextPage } from 'models/actions/sponsorUnit';
import { addTeamUnit } from 'builder/units/actions';

class AddUnitPanel extends Component {

   componentDidMount() {
      this.props.load();
   }

   render() {
      return (
         <AddUnitScrollablePanel source={this.props.units} onMore={!this.props.lastPage ? () => this.props.nextPage() : null}
            buttonAction={this.props.buttonAction} buttonIcon={<AddIcon />} />
      );
   }
}

AddUnitPanel.propTypes = {
   load: PropTypes.func.isRequired,
   lastPage: PropTypes.bool.isRequired,
   nextPage: PropTypes.func.isRequired,
   buttonAction: PropTypes.func.isRequired,
   units: PropTypes.array.isRequired
};

const mapStateToProps = (state) => {
   return {
      units: selectUnits(state),
      lastPage: selectLastPage(state)
   };
};

const mapDispatchToProps = (dispatch) => {
   return {
      load: bindActionCreators(fetch, dispatch),
      nextPage: bindActionCreators(moveNextPage, dispatch),
      buttonAction: bindActionCreators(addTeamUnit, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(AddUnitPanel);
