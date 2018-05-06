import React from 'react';
import { Route, IndexRoute } from 'react-router';

import AboutView from 'about/views/AboutView';
import PlayersListView from 'codex/views/PlayersListView';
import ContainerDbxTeamBuilder from 'builder/views/containers/ContainerDbxTeamBuilder';

import BaseLayout from 'views/containers/BaseLayout';

export default <Route path='/' component={BaseLayout}>
   <IndexRoute component={ContainerDbxTeamBuilder}/>
   <Route path='/about' activeClassName='aboutLink' component={AboutView}/>
   <Route path='/dbx' activeClassName='dbxTeamBuilderLink' component={ContainerDbxTeamBuilder}/>
   <Route path='/players' activeClassName='playersLink' component={PlayersListView}/>
</Route>;
