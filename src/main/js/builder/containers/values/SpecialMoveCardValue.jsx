import React from 'react';
import { connect } from 'react-redux';
import Value from 'grommet/components/Value';

const SpecialMoveCardValue = (props) => {
   return (
      <Value value={props.rank} label='special_move_card' />
   );
};

const mapStateToProps = (state) => {
   return {
      rank: state.builder.sponsor.specialMoveCards
   }
};

const mapDispatchToProps = (dispatch) => ({
});

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(SpecialMoveCardValue);
