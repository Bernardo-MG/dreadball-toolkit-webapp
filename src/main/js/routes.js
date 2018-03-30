import React from 'react';
import { Route, IndexRoute } from 'react-router';
import PlayersListView from 'codex/views/PlayersListView';
import ContainerDbxTeamBuilder from 'builder/views/containers/ContainerDbxTeamBuilder';
import BaseLayout from 'views/containers/BaseLayout';

export default <Route path="/" component={BaseLayout}>
   <IndexRoute component={ContainerDbxTeamBuilder}/>
   <Route path="/players" activeClassName="dbxPlayersLink" component={PlayersListView}/>
   <Route path="/dbx" activeClassName="dbxTeamBuilderLink" component={ContainerDbxTeamBuilder}/>
</Route>;
