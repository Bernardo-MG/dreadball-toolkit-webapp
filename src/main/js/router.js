'use strict';

const React = require('react');

import { createStore } from 'redux'
import { loadPlayers } from './actions/codex';
import Root from './containers/Root'
import { syncHistoryWithStore } from 'react-router-redux'
import { browserHistory } from 'react-router'
import configureStore from './store/configureStore'

require('./theme/style.scss');

let store = configureStore()
const history = syncHistoryWithStore(browserHistory, store)

console.log(store.getState());

let unsubscribe = store.subscribe(() =>
  console.log(store.getState())
)

const units = [
  {name: 'Unit', role: 'Jack', cost: 10}
];

store.dispatch(loadPlayers(units));

export default <Root store={store} history={history} />;
