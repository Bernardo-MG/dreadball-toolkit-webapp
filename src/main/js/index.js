'use strict';

const React = require('react');
const ReactDOM = require('react-dom')
import { Router, Route, hashHistory } from 'react-router'
import DreadballApp from './DreadballApp';

require('./theme/style.scss');

ReactDOM.render((
      <Router history={hashHistory}>
        <Route path="/" component={DreadballApp}/>
      </Router>
    ), document.getElementById('root'))
