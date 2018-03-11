import React from 'react';
import { render } from 'react-dom';

import Root from 'containers/Root';
import { createHistory } from 'history';
import { syncHistoryWithStore } from 'react-router-redux';
import { useRouterHistory } from 'react-router';
import configureStore from 'store/configureStore';

import 'theme/style.css';

const store = configureStore();

const browserHistory = useRouterHistory(createHistory)({
   basename: ROUTE_BASE
});

const history = syncHistoryWithStore(browserHistory, store);

const rootElement = document.getElementById('root');

render(<Root store={store} history={history} />, rootElement);
