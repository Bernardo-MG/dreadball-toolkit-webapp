'use strict';

// tag::vars[]
const React = require('react');
const ReactDOM = require('react-dom')
const Header = require('./template/header');
// end::vars[]

//import 'resources/css/style.scss';
require('./css/style.scss');

// tag::app[]
class App extends React.Component {

        constructor(props) {
                super(props);
        }

        render() {
                return (
                        <Header />
                )
        }
}
// end::app[]

// tag::render[]
ReactDOM.render(
        <App />,
        document.getElementById('react')
)
// end::render[]
