'use strict';

const React = require('react');
import { render } from 'react-dom'

import Root from './containers/Root'
import { createHistory } from 'history'
import { syncHistoryWithStore } from 'react-router-redux'
import { useRouterHistory } from 'react-router'
import configureStore from './store/configureStore'
import { loadPlayers } from './actions/codex';

require('./theme/style.scss');

let store = configureStore()

const browserHistory = useRouterHistory(createHistory)({
   basename: '/dreadball'
})
const history = syncHistoryWithStore(browserHistory, store)

render(<Root store={store} history={history} />, document.getElementById('root'));
