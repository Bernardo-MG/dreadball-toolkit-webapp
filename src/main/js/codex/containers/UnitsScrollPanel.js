import React, { Component } from 'react';

import PropTypes from 'prop-types';

import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

import { fetch, moveNextPage } from 'models/actions/unit';
import { selectUnits } from 'models/selectors';
import { selectLastUnitPage as selectLastPage } from 'models/selectors/page';

import UnitsViewPanel from 'codex/components/UnitsViewPanel';

class UnitsScrollPanel extends Component {

   componentDidMount() {
      this.props.load();
   }

   render() {
      return (
         <UnitsViewPanel source={this.props.units} onMore={!this.props.lastPage ? () => this.props.nextPage() : null} />
      );
   }
}

UnitsScrollPanel.propTypes = {
   load: PropTypes.func.isRequired,
   lastPage: PropTypes.bool.isRequired,
   nextPage: PropTypes.func.isRequired,
   units: PropTypes.array.isRequired
};

const mapStateToProps = (state) => {
   return {
      units: selectUnits(state),
      lastPage: selectLastPage(state)
   };
};

const mapDispatchToProps = (dispatch) => {
   return {
      load: bindActionCreators(fetch, dispatch),
      nextPage: bindActionCreators(moveNextPage, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(UnitsScrollPanel);
