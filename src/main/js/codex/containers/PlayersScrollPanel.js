import React, { Component } from 'react';

import PropTypes from 'prop-types';

import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

import { fetch, moveNextPage } from 'models/actions/players';
import { selectPlayers } from 'models/selectors';
import { selectCanLoadPlayer as selectCanLoad } from 'models/selectors/request';

import PlayersViewPanel from 'codex/components/PlayersViewPanel';

class PlayersScrollPanel extends Component {

   componentDidMount() {
      this.props.load();
   }

   render() {
      return (
         <PlayersViewPanel source={this.props.players} onMore={this.props.canLoad ? () => this.props.nextPage() : null} />
      );
   }
}

PlayersScrollPanel.propTypes = {
   load: PropTypes.func.isRequired,
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
      load: bindActionCreators(fetch, dispatch),
      nextPage: bindActionCreators(moveNextPage, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(PlayersScrollPanel);
