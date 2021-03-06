import React from 'react';

import PropTypes from 'prop-types';

import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

import AutosizedRatedPlayersDataList from 'builder/players/containers/AutosizedRatedPlayersDataList';

import { removeTeamPlayer } from 'builder/players/actions';

import { selectSponsorRatedPlayers } from 'builder/players/selectors';

import SubtractIcon from 'grommet/components/icons/base/SubtractCircle';

const SponsorTeamPlayers = (props) =>
   <AutosizedRatedPlayersDataList source={props.source} buttonAction={props.buttonAction} buttonIcon={<SubtractIcon />} />;

SponsorTeamPlayers.propTypes = {
   source: PropTypes.array.isRequired,
   buttonAction: PropTypes.func.isRequired
};

const mapStateToProps = (state) => {
   return {
      source: selectSponsorRatedPlayers(state)
   };
};

const mapDispatchToProps = (dispatch) => {
   return {
      buttonAction: bindActionCreators(removeTeamPlayer, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(SponsorTeamPlayers);
