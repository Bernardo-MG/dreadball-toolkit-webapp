import React from 'react';

import PropTypes from 'prop-types';

import { connect } from 'react-redux';

import RatedPlayersDataList from 'builder/players/components/RatedPlayersDataList';
import RatedPlayersDataSmallList from 'builder/players/components/RatedPlayersDataSmallList';

import { selectSmallScreen } from 'views/selectors';

const AutosizedRatedPlayersDataList = (props) => {
   let view;

   if (props.smallView) {
      view = <RatedPlayersDataSmallList source={props.source} onMore={props.onMore} buttonAction={props.buttonAction} buttonIcon={props.buttonIcon} />;
   } else {
      view = <RatedPlayersDataList source={props.source} onMore={props.onMore} buttonAction={props.buttonAction} buttonIcon={props.buttonIcon} />;
   }

   return view;
};

AutosizedRatedPlayersDataList.propTypes = {
   source: PropTypes.array.isRequired,
   onMore: PropTypes.func,
   buttonAction: PropTypes.func.isRequired,
   buttonIcon: PropTypes.object.isRequired,
   smallView: PropTypes.bool.isRequired
};

const mapStateToProps = (state) => {
   return {
      smallView: selectSmallScreen(state)
   };
};

const mapDispatchToProps = () => {
   return {};
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(AutosizedRatedPlayersDataList);
