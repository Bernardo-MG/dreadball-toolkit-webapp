'use strict';

const React = require('react');

import { Router, Route, browserHistory, IndexRoute } from 'react-router'
import Home from './view/Home';
import DbxPlayers from './view/DbxPlayers';
import MainLayout from './layout/main';
import { Provider } from 'react-redux';
import { createStore } from 'redux'
import dreadballApp from './reducers'

require('./theme/style.scss');

const routes = (
	<Route path="/dreadball/" component={MainLayout}>
		<IndexRoute component={Home}/>
		<Route path="/players" activeClassName="dbxPlayersLink" component={DbxPlayers}/>
	</Route>
);

let store = createStore(dreadballApp)

const router = (
	<Provider store={store}>
	   <Router history={browserHistory}>{routes}</Router>
	</Provider>
);

export default (router);
