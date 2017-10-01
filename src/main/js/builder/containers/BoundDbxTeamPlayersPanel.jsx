import React, { Component } from 'react';

import PropTypes from 'prop-types';

import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

import * as actions from 'models/actions/sponsorUnit';
import { ratedUnitsPaginated } from 'models/selectors';

import DbxTeamPlayersPanel from 'builder/components/DbxTeamPlayersPanel';

class BoundDbxTeamPlayersPanel extends Component {

   componentDidMount() {
      this.props.actions.fetch(this.props.affinities);
   }

   render() {
      return (
         <DbxTeamPlayersPanel units={this.props.source} />
      );
   }
}

BoundDbxTeamPlayersPanel.propTypes = {
   actions: PropTypes.object.isRequired,
   affinities: PropTypes.array.isRequired,
   source: PropTypes.array.isRequired
};

const mapStateToProps = (state) => {
   return {
      source: ratedUnitsPaginated(state),
      affinities: state.builder.sponsor.affinities
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
)(BoundDbxTeamPlayersPanel);
