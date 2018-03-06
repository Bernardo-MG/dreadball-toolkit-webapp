import React, { Component } from 'react';

import PropTypes from 'prop-types';

import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

import SponsorPlayersOptions from 'builder/players/containers/SponsorPlayersOptions';

import { fetch } from 'models/actions/sponsorPlayer';

class AddPlayerPanel extends Component {

   componentDidMount() {
      this.props.load();
   }

   render() {
      return (
         <SponsorPlayersOptions />
      );
   }
}

AddPlayerPanel.propTypes = {
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

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(AddPlayerPanel);
