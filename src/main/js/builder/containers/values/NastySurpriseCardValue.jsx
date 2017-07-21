import React from 'react';
import { connect } from 'react-redux';
import Value from 'grommet/components/Value';

const NastySurpriseCardValue = (props) => {
   return (
      <Value value={props.rank} label='nasty_surprise_card' />
   );
};

const mapStateToProps = (state) => {
   return {
      rank: state.builder.sponsor.nastySurpriseCards
   }
};

const mapDispatchToProps = (dispatch) => ({
});

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(NastySurpriseCardValue);
