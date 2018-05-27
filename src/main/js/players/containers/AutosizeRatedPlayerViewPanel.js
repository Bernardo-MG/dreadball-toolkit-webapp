import React from 'react';

import PropTypes from 'prop-types';

import { connect } from 'react-redux';

import RatedPlayerViewPanel from 'players/components/RatedPlayerViewPanel';
import RatedPlayerViewPanelSmall from 'players/components/RatedPlayerViewPanelSmall';

import { selectSmallScreen } from 'views/selectors';

const AutosizeRatedPlayerViewPanel = (props) => {
   let view;

   if (props.smallView) {
      view = <RatedPlayerViewPanelSmall source={props.source} onMore={props.onMore} buttonAction={props.buttonAction} buttonIcon={props.buttonIcon} />;
   } else {
      view = <RatedPlayerViewPanel source={props.source} onMore={props.onMore} buttonAction={props.buttonAction} buttonIcon={props.buttonIcon} />;
   }

   return view;
};

AutosizeRatedPlayerViewPanel.propTypes = {
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
)(AutosizeRatedPlayerViewPanel);
