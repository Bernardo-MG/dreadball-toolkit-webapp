import React, { Component } from 'react';

import PropTypes from 'prop-types';

import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

import { injectIntl } from 'react-intl';

import { fetch } from 'players/actions/players';

import SimpleView from 'views/containers/SimpleView';
import PlayersScrollPanel from 'codex/containers/PlayersScrollPanel';

import titleMessages from 'i18n/title';

/**
 * View for the units codex.
 *
 * It also takes care of loading the initial data.
 */
class PlayersListView extends Component {

   componentDidMount() {
      this.props.load();
   }

   render() {
      return (
         <SimpleView title={this.props.intl.formatMessage(titleMessages.playersCodex)}>
            <PlayersScrollPanel />
         </SimpleView>
      );
   }
}

PlayersListView.propTypes = {
   intl: PropTypes.object.isRequired,
   load: PropTypes.func.isRequired
};

const mapStateToProps = () => {
   return {};
};

const mapDispatchToProps = (dispatch) => {
   return {
      load: bindActionCreators(fetch, dispatch)
   };
};

export default injectIntl(connect(
   mapStateToProps,
   mapDispatchToProps
)(PlayersListView));
