import React from 'react';

import PropTypes from 'prop-types';

import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

import UnitScrollablePanel from 'builder/units/components/UnitScrollablePanel';

import { selectRatedUnits as selectUnits } from 'models/selectors';
import { selectLastRatedUnitPage as selectLastPage } from 'models/selectors/page';

import AddIcon from 'grommet/components/icons/base/AddCircle';

import { moveNextPage } from 'models/actions/sponsorUnit';
import { addTeamUnit } from 'builder/units/actions';

const SponsorPlayerOptions = (props) =>
   <UnitScrollablePanel source={props.source} onMore={!props.lastPage ? () => props.nextPage() : null}
      buttonAction={props.buttonAction} buttonIcon={<AddIcon />} />;

SponsorPlayerOptions.propTypes = {
   lastPage: PropTypes.bool.isRequired,
   nextPage: PropTypes.func.isRequired,
   buttonAction: PropTypes.func.isRequired,
   source: PropTypes.array.isRequired
};

const mapStateToProps = (state) => {
   return {
      source: selectUnits(state),
      lastPage: selectLastPage(state)
   };
};

const mapDispatchToProps = (dispatch) => {
   return {
      nextPage: bindActionCreators(moveNextPage, dispatch),
      buttonAction: bindActionCreators(addTeamUnit, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(SponsorPlayerOptions);
