import React, { Component } from 'react';

import PropTypes from 'prop-types';

import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

import { fetch } from 'models/actions/sponsorUnit';
import { selectRatedUnits } from 'models/selectors';
import { selectAffinities } from 'builder/affinities/selectors';

import DbxTeamPlayersPanel from 'builder/views/components/DbxTeamPlayersPanel';

class BoundDbxTeamPlayersPanel extends Component {

   componentDidMount() {
      this.props.action();
   }

   render() {
      return (
         <DbxTeamPlayersPanel units={this.props.source} />
      );
   }
}

BoundDbxTeamPlayersPanel.propTypes = {
   action: PropTypes.func.isRequired,
   source: PropTypes.array.isRequired
};

const mapStateToProps = (state) => {
   return {
      source: selectRatedUnits(state)
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
)(BoundDbxTeamPlayersPanel);
