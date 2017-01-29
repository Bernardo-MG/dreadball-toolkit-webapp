'use strict';

const React = require('react');

import { Router, Route, browserHistory, IndexRoute } from 'react-router'
import Home from './Home';
import DbxPlayers from './DbxPlayers';
import MainLayout from './layout/main';

require('./theme/style.scss');

const routes = (
	<Route path="/dreadball/" component={MainLayout}>
		<IndexRoute component={Home}/>
		<Route path="/players" activeClassName="dbxPlayersLink" component={DbxPlayers}/>
	</Route>
);

const router = (
	<Router history={browserHistory}>{routes}</Router>
);

export default (router);
