import React from 'react';
import { Link } from 'react-router';

class MainDrawerContent extends React.Component {
   render() {
         return (
            <Link to="players" className="dbxPlayersLink">Players</Link>
         );
     };
};

export default MainDrawerContent;
module.exports = MainDrawerContent;