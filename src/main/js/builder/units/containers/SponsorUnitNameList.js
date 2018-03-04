import React from 'react';

import PropTypes from 'prop-types';

import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

import { injectIntl } from 'react-intl';

import AddUnitScrollablePanel from 'builder/units/components/AddUnitScrollablePanel';

import { removeTeamUnit } from 'builder/units/actions';

import { selectSponsorRatedUnits } from 'builder/units/selectors';

import SubtractIcon from 'grommet/components/icons/base/SubtractCircle';

const SponsorUnitNameList = (props) =>
   <AddUnitScrollablePanel source={props.source}
      buttonAction={props.buttonAction} buttonIcon={<SubtractIcon />} />;

SponsorUnitNameList.propTypes = {
   source: PropTypes.array.isRequired,
   buttonAction: PropTypes.func.isRequired,
   intl: PropTypes.object.isRequired
};

const mapStateToProps = (state) => {
   return {
      source: selectSponsorRatedUnits(state)
   };
};

const mapDispatchToProps = (dispatch) => {
   return {
      buttonAction: bindActionCreators(removeTeamUnit, dispatch)
   };
};

export default injectIntl(connect(
   mapStateToProps,
   mapDispatchToProps
)(SponsorUnitNameList));
