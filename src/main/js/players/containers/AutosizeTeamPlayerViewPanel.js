import React from 'react';

import PropTypes from 'prop-types';

import { connect } from 'react-redux';

import TeamPlayerViewPanel from 'players/components/TeamPlayerViewPanel';
import TeamPlayerViewPanelSmall from 'players/components/TeamPlayerViewPanelSmall';

import { selectSmallScreen } from 'views/selectors';

const AutosizeTeamPlayerViewPanel = (props) => {
   let view;

   if (props.smallView) {
      view = <TeamPlayerViewPanelSmall source={props.source} onMore={props.onMore} buttonAction={props.buttonAction} buttonIcon={props.buttonIcon} />;
   } else {
      view = <TeamPlayerViewPanel source={props.source} onMore={props.onMore} buttonAction={props.buttonAction} buttonIcon={props.buttonIcon} />;
   }

   return view;
};

AutosizeTeamPlayerViewPanel.propTypes = {
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
)(AutosizeTeamPlayerViewPanel);
