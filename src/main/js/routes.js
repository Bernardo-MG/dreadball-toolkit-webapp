import React from 'react';
import { Route, IndexRoute } from 'react-router';
import DbxPlayers from 'codex/components/views/DbxPlayers';
import ContainerDbxTeamBuilder from 'builder/containers/views/ContainerDbxTeamBuilder';
import MainLayout from 'components/layout/MainLayout';
import Home from 'components/views/Home';

export default <Route path="/" component={MainLayout}>
   <IndexRoute component={Home}/>
   <Route path="/players" activeClassName="dbxPlayersLink" component={DbxPlayers}/>
   <Route path="/dbx" activeClassName="dbxTeamBuilderLink" component={ContainerDbxTeamBuilder}/>
</Route>
