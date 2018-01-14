import React from 'react';

import PropTypes from 'prop-types';

import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

import Button from 'grommet/components/Button';

import { requestTeamReport } from 'report/actions';

const TeamReportButton = (props) =>
   <Button onClick={props.requestReport} label='report' />;

TeamReportButton.propTypes = {
   requestReport: PropTypes.func.isRequired
};

const mapStateToProps = () => {
   return {};
};

const mapDispatchToProps = (dispatch) => {
   return {
      requestReport: bindActionCreators(requestTeamReport, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(TeamReportButton);
