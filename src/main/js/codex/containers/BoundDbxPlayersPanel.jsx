import React, { Component } from 'react';

import PropTypes from 'prop-types';

import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

import * as actions from 'requests/actions/unit';
import { unitsPaginated } from 'models/selectors';

import DbxPlayersPanel from 'codex/components/DbxPlayersPanel';

class BoundDbxPlayersPanel extends Component {

   componentDidMount() {
      this.props.actions.fetch();
   }

   render() {
      return (
         <DbxPlayersPanel units={this.props.units} />
      );
   }
}

BoundDbxPlayersPanel.propTypes = {
   actions: PropTypes.object.isRequired,
   units: PropTypes.array.isRequired
};

const mapStateToProps = (state) => {
   return {
      units: unitsPaginated(state)
   };
};

const mapDispatchToProps = (dispatch) => {
   return {
      actions: bindActionCreators(actions, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(BoundDbxPlayersPanel);
