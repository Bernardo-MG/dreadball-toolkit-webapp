import React from 'react';
import { Route, IndexRoute } from 'react-router';
import UnitsScrollPanel from 'codex/containers/UnitsScrollPanel';
import ContainerDbxTeamBuilder from 'builder/views/containers/ContainerDbxTeamBuilder';
import BaseLayout from 'components/layout/BaseLayout';
import Home from 'components/views/Home';

export default <Route path="/" component={BaseLayout}>
   <IndexRoute component={Home}/>
   <Route path="/players" activeClassName="dbxPlayersLink" component={UnitsScrollPanel}/>
   <Route path="/dbx" activeClassName="dbxTeamBuilderLink" component={ContainerDbxTeamBuilder}/>
</Route>;
