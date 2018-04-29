import React from 'react';

import PropTypes from 'prop-types';

import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

import TeamPlayerScrollPanel from 'builder/players/components/TeamPlayerScrollPanel';

import { selectRatedPlayers as selectPlayers } from 'models/selectors';
import { selectCanLoadRatedPlayer as selectCanLoad } from 'models/selectors/request';

import AddIcon from 'grommet/components/icons/base/AddCircle';

import { moveNextPage } from 'models/actions/affinityPlayers';
import { addTeamPlayer } from 'builder/players/actions';

const affinityPlayerOptions = (props) =>
   <TeamPlayerScrollPanel source={props.source} onMore={props.canLoad ? () => props.nextPage() : null}
      buttonAction={props.buttonAction} buttonIcon={<AddIcon />} />;

affinityPlayerOptions.propTypes = {
   canLoad: PropTypes.bool.isRequired,
   nextPage: PropTypes.func.isRequired,
   buttonAction: PropTypes.func.isRequired,
   source: PropTypes.array.isRequired
};

const mapStateToProps = (state) => {
   return {
      source: selectPlayers(state),
      canLoad: selectCanLoad(state)
   };
};

const mapDispatchToProps = (dispatch) => {
   return {
      nextPage: bindActionCreators(moveNextPage, dispatch),
      buttonAction: bindActionCreators(addTeamPlayer, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(affinityPlayerOptions);
