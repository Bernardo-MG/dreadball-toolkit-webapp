import React, { Component } from 'react';

import PropTypes from 'prop-types';

import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

import Button from 'grommet/components/Button';

import * as actions from 'builder/actions';

class AddUnitButton extends Component {

   unit;
   action;

   chooseUnit = () => {
      this.action(this.unit);
   };

   constructor(props) {
      super(props);

      this.unit = props.unit;

      this.action = props.actions.chooseSponsorUnit;
   }

   componentWillReceiveProps(props) {
      this.unit = props.unit;
   }

   render() {
      return (
         <Button label='add' onClick={this.chooseUnit} />
      );
   }

}

AddUnitButton.propTypes = {
   unit: PropTypes.string.isRequired,
   actions: PropTypes.object.isRequired
};

const mapStateToProps = () => {
   return {};
};

const mapDispatchToProps = (dispatch) => {
   return {
      actions: bindActionCreators(actions, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(AddUnitButton);
