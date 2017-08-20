import React, { Component } from 'react';

import PropTypes from 'prop-types';

import FormField from 'grommet/components/FormField';
import TextInput from 'grommet/components/TextInput';

import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

import * as actions from 'builder/actions';

class SponsorNameInput extends Component {

   update;

   updateValue = (event) => {
      this.update(event.target.value);
   };

   constructor(props) {
      super(props);

      this.update = props.actions.updateSponsorName;
   }

   render() {
      return (
         <FormField label='sponsor_name'>
            <TextInput id='sponsor_name' name='sponsor_name' value={this.props.sponsorName} onDOMChange={this.updateValue}/>
         </FormField>
      );
   }
}

SponsorNameInput.propTypes = {
   actions: PropTypes.object.isRequired,
   sponsorName: PropTypes.string.isRequired
};

const mapStateToProps = (state) => {
   return {
      sponsorName: state.builder.sponsor.sponsorName
   };
};

const mapDispatchToProps = (dispatch) => {
   return {
      actions: bindActionCreators(actions, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(SponsorNameInput);
