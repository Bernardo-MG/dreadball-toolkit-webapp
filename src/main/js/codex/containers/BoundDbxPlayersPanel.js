import React, { Component } from 'react';

import PropTypes from 'prop-types';

import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

import { fetch } from 'models/actions/unit';
import { selectUnits } from 'models/selectors';

import PlayersPagesPanel from 'codex/components/PlayersPagesPanel';

class BoundDbxPlayersPanel extends Component {

   componentDidMount() {
      this.props.action();
   }

   render() {
      return (
         <PlayersPagesPanel units={this.props.units} />
      );
   }
}

BoundDbxPlayersPanel.propTypes = {
   action: PropTypes.func.isRequired,
   units: PropTypes.array.isRequired
};

const mapStateToProps = (state) => {
   return {
      units: selectUnits(state)
   };
};

const mapDispatchToProps = (dispatch) => {
   return {
      action: bindActionCreators(fetch, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(BoundDbxPlayersPanel);
