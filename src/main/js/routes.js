import React from 'react';
import { Route, IndexRoute } from 'react-router';
import PlayersScrollPanel from 'codex/containers/PlayersScrollPanel';
import ContainerDbxTeamBuilder from 'builder/views/containers/ContainerDbxTeamBuilder';
import BaseLayout from 'views/containers/BaseLayout';

export default <Route path="/" component={BaseLayout}>
   <IndexRoute component={ContainerDbxTeamBuilder}/>
   <Route path="/players" activeClassName="dbxPlayersLink" component={PlayersScrollPanel}/>
   <Route path="/dbx" activeClassName="dbxTeamBuilderLink" component={ContainerDbxTeamBuilder}/>
</Route>;
