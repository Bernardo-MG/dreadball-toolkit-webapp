'use strict';

const React = require('react');
const ReactDOM = require('react-dom')
import { Router, Route, browserHistory, IndexRoute } from 'react-router'
import Home from './Home';
import DbxPlayers from './DbxPlayers';
import MainLayout from './layout/main';

require('./theme/style.scss');

ReactDOM.render((
      <Router history={browserHistory}>
        <Route path="/dreadball/" component={MainLayout}>
          <IndexRoute component={Home}/>
          <Route path="/players" activeClassName="dbxPlayersLink" component={DbxPlayers}/>
        </Route>
      </Router>
    ), document.getElementById('root'))
