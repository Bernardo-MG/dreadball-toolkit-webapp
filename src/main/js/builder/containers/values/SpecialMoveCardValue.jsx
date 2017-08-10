import React from 'react';

import PropTypes from 'prop-types';

import { connect } from 'react-redux';

import Value from 'grommet/components/Value';

const SpecialMoveCardValue = (props) => {
   return (
      <Value value={props.cards} label='special_move_card' />
   );
};

SpecialMoveCardValue.propTypes = {
   cards: PropTypes.number.isRequired
};

const mapStateToProps = (state) => {
   return {
      cards: state.builder.sponsor.specialMoveCards
   };
};

const mapDispatchToProps = (dispatch) => {
   return {};
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(SpecialMoveCardValue);
