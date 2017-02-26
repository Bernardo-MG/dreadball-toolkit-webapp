import React from 'react';
import { Link } from 'react-router';

const MainDrawerContent = () => {
   return (
      <Link to="players" className="dbxPlayersLink">Players</Link>
   );
};

export default MainDrawerContent;