'use strict';

const React = require('react');
const ReactDOM = require('react-dom')
import DreadballApp from './DreadballApp';

require('./css/style.scss');

ReactDOM.render(
        <DreadballApp />,
        document.getElementById('react')
)
