import React, { Component } from 'react';

import PropTypes from 'prop-types';

import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

import { fetch } from 'models/actions/sponsorUnit';
import { selectRatedUnits } from 'models/selectors';

import DbxTeamPlayersPanel from 'builder/views/components/DbxTeamPlayersPanel';

class BoundDbxTeamPlayersPanel extends Component {

   componentDidMount() {
      this.props.action(this.props.affinities);
   }

   render() {
      return (
         <DbxTeamPlayersPanel units={this.props.source} />
      );
   }
}

BoundDbxTeamPlayersPanel.propTypes = {
   action: PropTypes.func.isRequired,
   affinities: PropTypes.array.isRequired,
   source: PropTypes.array.isRequired
};

const mapStateToProps = (state) => {
   return {
      source: selectRatedUnits(state),
      affinities: state.builder.sponsor.affinities
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
