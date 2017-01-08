'use strict';

const React = require('react');
const ReactDOM = require('react-dom')
import App from './App';

require('./css/style.scss');

ReactDOM.render(
        <App />,
        document.getElementById('react')
)
