'use strict';

const React = require('react');
const ReactDOM = require('react-dom')
import DreadballApp from './DreadballApp';

require('./theme/style.scss');

ReactDOM.render(
        <DreadballApp/>,
        document.getElementById('root')
)
