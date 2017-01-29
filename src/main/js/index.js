'use strict';

const React = require('react');
const ReactDOM = require('react-dom')
import { Router, Route, hashHistory } from 'react-router'
import DreadballApp from './DreadballApp';
import DbxPlayers from './DbxPlayers';
import MainLayout from './layout/main';

require('./theme/style.scss');

ReactDOM.render((
      <Router history={hashHistory}>
        <Route component={MainLayout}>
          <Route path="/" component={DreadballApp}/>
          <Route path="/players" component={DbxPlayers}/>
        </Route>
      </Router>
    ), document.getElementById('root'))
