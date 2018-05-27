import React from 'react';

import PropTypes from 'prop-types';

import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

import AutosizedRatedPlayersDataList from 'builder/players/containers/AutosizedRatedPlayersDataList';

import { selectRatedPlayers as selectPlayers } from 'players/selectors';
import { selectCanLoadRatedPlayer as selectCanLoad } from 'players/selectors/request';
import { selectSmallScreen } from 'views/selectors';

import AddIcon from 'grommet/components/icons/base/AddCircle';

import { moveNextPage } from 'players/actions/ratedPlayers';
import { addTeamPlayer } from 'builder/players/actions';

const AffinityPlayersOptions = (props) =>
   <AutosizedRatedPlayersDataList source={props.source} onMore={props.canLoad ? () => props.nextPage() : null} buttonAction={props.buttonAction} buttonIcon={<AddIcon />} />;

AffinityPlayersOptions.propTypes = {
   canLoad: PropTypes.bool.isRequired,
   nextPage: PropTypes.func.isRequired,
   smallView: PropTypes.bool.isRequired,
   buttonAction: PropTypes.func.isRequired,
   source: PropTypes.array.isRequired
};

const mapStateToProps = (state) => {
   return {
      source: selectPlayers(state),
      canLoad: selectCanLoad(state),
      smallView: selectSmallScreen(state)
   };
};

const mapDispatchToProps = (dispatch) => {
   return {
      nextPage: bindActionCreators(moveNextPage, dispatch),
      buttonAction: bindActionCreators(addTeamPlayer, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(AffinityPlayersOptions);
