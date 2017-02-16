'use strict';

const React = require('react');
import { render } from 'react-dom'

import Root from './containers/Root'
import { syncHistoryWithStore } from 'react-router-redux'
import { browserHistory } from 'react-router'
import configureStore from './store/configureStore'
import { loadPlayers } from './actions/codex';

require('./theme/style.scss');

let store = configureStore()
const history = syncHistoryWithStore(browserHistory, store)

render(<Root store={store} history={history} />, document.getElementById('root'));
