'use strict';

const React = require('react');

import { Router, Route, browserHistory, IndexRoute } from 'react-router'
import Home from './view/Home';
import DbxPlayers from './view/DbxPlayers';
import MainLayout from './layout/main';
import { Provider } from 'react-redux';
import { createStore } from 'redux'
import dreadballApp from './reducers'
import loadPlayers from './actions/codex';

require('./theme/style.scss');

const routes = (
	<Route path="/dreadball/" component={MainLayout}>
		<IndexRoute component={Home}/>
		<Route path="/players" activeClassName="dbxPlayersLink" component={DbxPlayers}/>
	</Route>
);

let store = createStore(dreadballApp)

console.log(store.getState());

let unsubscribe = store.subscribe(() =>
  console.log(store.getState())
)

const units = [
  {name: 'Unit', role: 'Jack', cost: 10}
];

//store.dispatch(loadPlayers(units));
store.dispatch({
  type: 'LOAD_PLAYERS',
  units
});

const router = (
	<Provider store={store}>
	   <Router history={browserHistory}>{routes}</Router>
	</Provider>
);

export default (router);
