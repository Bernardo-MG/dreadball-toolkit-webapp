import React, { Component } from 'react';

import PropTypes from 'prop-types';

import { injectIntl } from 'react-intl';

import TableHeader from 'grommet/components/TableHeader';

class SortableTableHeader extends Component {

   state = {
      index: 0,
      ascending: true
   }

   sort = (index, ascending) => {
      this.setState({ index, ascending });

      this.onSort(index, ascending);
   }

   constructor(props) {
      super(props);

      this.onSort = props.onSort;
   }

   render() {
      return (
            <TableHeader sortIndex={this.state.index} sortAscending={this.state.ascending} onSort={this.sort} labels={this.props.labels} />
      );
   }
}

SortableTableHeader.propTypes = {
   intl: PropTypes.object.isRequired,
   labels: PropTypes.array.isRequired,
   onSort: PropTypes.func
};

export default injectIntl(SortableTableHeader);
