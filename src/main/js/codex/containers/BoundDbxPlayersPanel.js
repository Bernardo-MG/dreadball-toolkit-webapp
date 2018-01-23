import React, { Component } from 'react';

import PropTypes from 'prop-types';

import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

import { fetch, moveNextPage, movePrevPage } from 'models/actions/unit';
import { selectUnits } from 'models/selectors';
import { selectCurrentUnitPageVisual, selectTotalUnitPages, selectLastUnitPage } from 'models/selectors/page';

import PlayersPagesPanel from 'codex/components/PlayersPagesPanel';

class BoundDbxPlayersPanel extends Component {

   componentDidMount() {
      this.props.load();
   }

   render() {
      return (
         <PlayersPagesPanel units={this.props.units}
            page={this.props.page} totalPages={this.props.totalPages}
            previousPage={this.props.previousPage} nextPage={this.props.nextPage}
            lastPage={this.props.lastPage}/>
      );
   }
}

BoundDbxPlayersPanel.propTypes = {
   load: PropTypes.func.isRequired,
   units: PropTypes.array.isRequired,
   previousPage: PropTypes.func.isRequired,
   nextPage: PropTypes.func.isRequired,
   page: PropTypes.number.isRequired,
   totalPages: PropTypes.number.isRequired,
   lastPage: PropTypes.bool.isRequired
};

const mapStateToProps = (state) => {
   return {
      units: selectUnits(state),
      page: selectCurrentUnitPageVisual(state),
      totalPages: selectTotalUnitPages(state),
      lastPage: selectLastUnitPage(state)
   };
};

const mapDispatchToProps = (dispatch) => {
   return {
      load: bindActionCreators(fetch, dispatch),
      previousPage: bindActionCreators(movePrevPage, dispatch),
      nextPage: bindActionCreators(moveNextPage, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(BoundDbxPlayersPanel);
