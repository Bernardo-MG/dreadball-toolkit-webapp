import React from 'react';

import PropTypes from 'prop-types';

import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

import { moveNextPage } from 'players/actions/players';
import { selectPlayers } from 'players/selectors';
import { selectCanLoadPlayer as selectCanLoad } from 'players/selectors/request';

import PlayersDataList from 'players/components/PlayersDataList';

/**
 * Scroll panel showing all the players.
 */
const PlayersScrollPanel = (props) =>
   <PlayersDataList source={props.players} onMore={props.canLoad ? () => props.nextPage() : null} />;

PlayersScrollPanel.propTypes = {
   canLoad: PropTypes.bool.isRequired,
   nextPage: PropTypes.func.isRequired,
   players: PropTypes.array.isRequired
};

const mapStateToProps = (state) => {
   return {
      players: selectPlayers(state),
      canLoad: selectCanLoad(state)
   };
};

const mapDispatchToProps = (dispatch) => {
   return {
      nextPage: bindActionCreators(moveNextPage, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(PlayersScrollPanel);
