import React from 'react';

import PropTypes from 'prop-types';

import { injectIntl } from 'react-intl';

import BoundDbxPlayersPanel from 'codex/containers/BoundDbxPlayersPanel';

const DbxPlayers = () =>
   <BoundDbxPlayersPanel />;

DbxPlayers.propTypes = {
   intl: PropTypes.object.isRequired
};


export default injectIntl(DbxPlayers);
