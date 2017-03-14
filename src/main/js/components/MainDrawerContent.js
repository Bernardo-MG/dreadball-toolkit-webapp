import React from 'react';
import { Link } from 'react-router';

const MainDrawerContent = () => {
   return (
      <nav>
         <p><Link to="/players" className="dbxPlayersLink">players</Link></p>
         <p><Link to="/dbx" className="dbxTeamBuilderLink">dbx_team_creation</Link></p>
      </nav>
   );
};

export default MainDrawerContent;