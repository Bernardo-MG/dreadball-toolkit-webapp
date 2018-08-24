import React from 'react';
import { Route, IndexRoute } from 'react-router';

import About from 'about/containers/About';
import PlayersListView from 'codex/views/PlayersListView';
import ContainerDbxTeamBuilder from 'builder/views/containers/ContainerDbxTeamBuilder';

import BaseLayout from 'layouts/containers/BaseLayout';

/**
 * All the routes for the application.
 * 
 * These are composed of three parts:
 * - Path
 * - Class name to mark links as active
 * - Component to show
 */
export default <Route path='/' component={BaseLayout}>
   <IndexRoute component={ContainerDbxTeamBuilder}/>
   <Route path='/about' activeClassName='aboutLink' component={About}/>
   <Route path='/dbx' activeClassName='dbxTeamBuilderLink' component={ContainerDbxTeamBuilder}/>
   <Route path='/players' activeClassName='playersLink' component={PlayersListView}/>
</Route>;
