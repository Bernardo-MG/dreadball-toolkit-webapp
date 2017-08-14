import React, { Component } from 'react';

import PropTypes from 'prop-types';

import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

import * as actions from 'requests/actions/unit';
import { unitsPaginated } from 'models/selectors';

import DbxUnitTable from 'codex/components/DbxUnitTable';

class LoadableDbxUnitTable extends Component {

   componentDidMount() {
      this.props.actions.fetch();
   }

   sort = (fetch) => (index, descending) => {
      let order;
      let field;

      if (descending) {
         order = 'DESC';
      } else {
         order = 'ASC';
      }

      switch (index) {
      case 0:
         // Name
         field = 'name';
         break;
      case 1:
         // Role
         field = 'position';
         break;
      case 2:
         // Movement
         field = 'move';
         break;
      case 3:
         // Strength
         field = 'strength';
         break;
      case 4:
         // Speed
         field = 'speed';
         break;
      case 5:
         // Skill
         field = 'skill';
         break;
      case 6:
         // Armor
         field = 'armor';
         break;
      case 7:
         // Abilities
         field = 'abilities';
         break;
      default:
         // Name
         field = 'name';
      }

      fetch(0, field, order, true);
   }

   render() {
      return (
         <DbxUnitTable onSort={this.sort(this.props.actions.fetch)} source={this.props.source} />
      );
   }
}

LoadableDbxUnitTable.propTypes = {
   actions: PropTypes.object.isRequired,
   source: PropTypes.array.isRequired
};

const mapStateToProps = (state) => {
   return {
      source: unitsPaginated(state)
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
)(LoadableDbxUnitTable);
