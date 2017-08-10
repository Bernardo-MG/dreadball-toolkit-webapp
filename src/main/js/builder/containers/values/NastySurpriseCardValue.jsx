import React from 'react';

import PropTypes from 'prop-types';

import { connect } from 'react-redux';

import Value from 'grommet/components/Value';

const NastySurpriseCardValue = (props) => {
   return (
      <Value value={props.cards} label='nasty_surprise_card' />
   );
};

NastySurpriseCardValue.propTypes = {
   cards: PropTypes.number.isRequired
};

const mapStateToProps = (state) => {
   return {
      cards: state.builder.sponsor.nastySurpriseCards
   };
};

const mapDispatchToProps = () => {
   return {};
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(NastySurpriseCardValue);
