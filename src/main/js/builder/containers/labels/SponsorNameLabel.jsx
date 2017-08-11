import React from 'react';

import PropTypes from 'prop-types';

import { connect } from 'react-redux';

import Label from 'grommet/components/Label';

const SponsorNameLabel = (props) => <Label>{ props.sponsorName }</Label>;

SponsorNameLabel.propTypes = {
   sponsorName: PropTypes.string.isRequired
};

const mapStateToProps = (state) => {
   return {
      sponsorName: state.builder.sponsor.sponsorName
   };
};

const mapDispatchToProps = () => {
   return {};
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(SponsorNameLabel);
