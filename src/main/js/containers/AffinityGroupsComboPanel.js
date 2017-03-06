import React, { Component } from 'react'
import ComboPanel from '../components/ComboPanel';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import * as Actions from '../actions/dbxBuilder';
import { injectIntl } from 'react-intl';

const affinities = [
   { value: 'affinity1', label: 'affinity1' },
   { value: 'affinity2', label: 'affinity2' },
   { value: 'affinity3', label: 'affinity3' },
   { value: 'affinity4', label: 'affinity4' },
   { value: 'affinity5', label: 'affinity5' },
   { value: 'affinity6', label: 'affinity6' }
];

const values = [ affinities, affinities, affinities, affinities, affinities ];

class AffinityGroupsComboPanel extends Component {
   
   componentDidMount() {
      this.props.actions.fetchAffinityGroups(this.props.intl);
   }
   
   render() {
      return (
         <ComboPanel source={values} />
      )
   }
}

const mapStateToProps = (state) => ({
   source: state.codex.units
});

const mapDispatchToProps = (dispatch) => ({
   actions: bindActionCreators(Actions, dispatch)
})

export default injectIntl(connect(
   mapStateToProps,
   mapDispatchToProps
)(AffinityGroupsComboPanel));
