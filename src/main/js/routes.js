import React from 'react';
import { Route, IndexRoute } from 'react-router';
import DbxPlayers from 'codex/components/views/DbxPlayers';
import ContainerDbxTeamBuilder from 'builder/containers/views/ContainerDbxTeamBuilder';
import BaseLayout from 'components/layout/BaseLayout';
import Home from 'components/views/Home';

export default <Route path="/" component={BaseLayout}>
   <IndexRoute component={Home}/>
   <Route path="/players" activeClassName="dbxPlayersLink" component={DbxPlayers}/>
   <Route path="/dbx" activeClassName="dbxTeamBuilderLink" component={ContainerDbxTeamBuilder}/>
</Route>;
