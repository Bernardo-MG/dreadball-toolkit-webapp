import React, { Component } from 'react';

import PropTypes from 'prop-types';

import { injectIntl } from 'react-intl';

import Box from 'grommet/components/Box';
import Split from 'grommet/components/Split';

import NextPageButton from 'codex/containers/NextPageButton';
import PreviousPageButton from 'codex/containers/PreviousPageButton';

import DbxUnitList from 'codex/components/DbxUnitList';
import DbxUnitPanel from 'codex/components/DbxUnitPanel';

import labelMessages from 'i18n/label';

class DbxPlayersPanel extends Component {

   state = { selected: '' };

   units = [];

   selectUnit = (selected) => {
      const unit = this.units[selected];

      this.setState({ selected: unit });
   }

   constructor(props) {
      super(props);

      this.units = props.units;
   }

   componentWillReceiveProps(props) {
      this.units = props.units;
   }

   render() {
      let details;
      if (this.state.selected) {
         details = <DbxUnitPanel source={this.state.selected} />;
      } else {
         details = <h1>{this.props.intl.formatMessage(labelMessages.pickPlayer)}</h1>;
      }

      return (
            <Split flex='right' showOnResponsive='both' separator={true}>
               <Box justify='center' align='center'>
                  <DbxUnitList onSelect={this.selectUnit} source={this.props.units} />
                  <Box direction='row'>
                     <Box margin='small'>
                        <PreviousPageButton />
                     </Box>
                     <Box margin='small'>
                        <NextPageButton />
                     </Box>
                  </Box>
               </Box>
               <Box pad='medium'>
                  { details }
               </Box>
            </Split>
      );
   }
}

DbxPlayersPanel.propTypes = {
   units: PropTypes.array.isRequired,
   intl: PropTypes.object.isRequired
};

export default injectIntl(DbxPlayersPanel);
