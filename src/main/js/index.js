'use strict';

const React = require('react');
const ReactDOM = require('react-dom')

import Router from './router';

require('./theme/style.scss');

ReactDOM.render(Router, document.getElementById('root'));
