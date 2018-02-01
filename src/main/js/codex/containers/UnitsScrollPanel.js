import React, { Component } from 'react';

import PropTypes from 'prop-types';

import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

import Box from 'grommet/components/Box';

import { fetch, moveNextPage } from 'models/actions/unit';
import { selectUnits } from 'models/selectors';
import { selectLastUnitPage } from 'models/selectors/page';

import UnitTable from 'codex/components/UnitTable';

class UnitsScrollPanel extends Component {

   componentDidMount() {
      this.props.load();
   }

   render() {
      return (
         <Box pad='medium' full={true}>
            <UnitTable source={this.props.units} onMore={!this.props.lastPage ? () => this.props.nextPage() : null} />
         </Box>
      );
   }
}

UnitsScrollPanel.propTypes = {
   load: PropTypes.func.isRequired,
   units: PropTypes.array.isRequired,
   lastPage: PropTypes.bool.isRequired,
   nextPage: PropTypes.func.isRequired
};

const mapStateToProps = (state) => {
   return {
      units: selectUnits(state),
      nextPage: PropTypes.func.isRequired,
      lastPage: selectLastUnitPage(state)
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
