import React from 'react';

import PropTypes from 'prop-types';

import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

import { injectIntl } from 'react-intl';

import TeamPlayerScrollPanel from 'builder/players/components/TeamPlayerScrollPanel';

import { removeTeamPlayer } from 'builder/players/actions';

import { selectSponsorRatedPlayers } from 'builder/players/selectors';

import SubtractIcon from 'grommet/components/icons/base/SubtractCircle';

const SponsorTeamPlayers = (props) =>
   <TeamPlayerScrollPanel source={props.source}
      buttonAction={props.buttonAction} buttonIcon={<SubtractIcon />} />;

SponsorTeamPlayers.propTypes = {
   source: PropTypes.array.isRequired,
   buttonAction: PropTypes.func.isRequired,
   intl: PropTypes.object.isRequired
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

export default injectIntl(connect(
   mapStateToProps,
   mapDispatchToProps
)(SponsorTeamPlayers));
