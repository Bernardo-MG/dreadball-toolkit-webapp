'use strict';

const React = require('react');
const ReactDOM = require('react-dom')
import TestApp from './TestApp';

require('./css/style.scss');

class App extends React.Component {

        constructor(props) {
                super(props);
        }

        render() {
                return (
                        <TestApp />
                )
        }
}

ReactDOM.render(
        <App />,
        document.getElementById('react')
)
