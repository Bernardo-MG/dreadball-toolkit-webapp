import React from 'react';

import SimpleView from 'views/containers/SimpleView';
import PlayersScrollPanel from 'codex/containers/PlayersScrollPanel';

const PlayersListView = () =>
   <SimpleView>
      <PlayersScrollPanel />
   </SimpleView>;

PlayersListView.propTypes = {};

export default PlayersListView;
