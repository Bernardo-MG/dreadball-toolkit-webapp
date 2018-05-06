import React from 'react';
import { render } from 'react-dom';

import Root from 'containers/Root';
import { createHistory } from 'history';
import { syncHistoryWithStore } from 'react-router-redux';
import { useRouterHistory } from 'react-router';
import configureStore from 'store/configureStore';

import 'theme/style.scss';

const store = configureStore();

const browserHistory = useRouterHistory(createHistory)();

const history = syncHistoryWithStore(browserHistory, store);

const rootElement = document.getElementById('root');

render(<Root store={store} history={history} />, rootElement);

document.body.classList.remove('loader');
