import React from 'react';

import PropTypes from 'prop-types';

import { injectIntl } from 'react-intl';

import SimpleView from 'views/containers/SimpleView';
import PlayersScrollPanel from 'codex/containers/PlayersScrollPanel';

import titleMessages from 'i18n/title';

const PlayersListView = (props) =>
   <SimpleView title={props.intl.formatMessage(titleMessages.playersCodex)}>
      <PlayersScrollPanel />
   </SimpleView>;

PlayersListView.propTypes = {
   intl: PropTypes.object.isRequired
};

export default injectIntl(PlayersListView);
