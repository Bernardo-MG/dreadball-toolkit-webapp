import React from 'react';
import { Link } from 'react-router';

const MainDrawerContent = () => {
   return (
      <div>
         <p><Link to="players" className="dbxPlayersLink">players</Link></p>
         <p><Link to="team/affinities" className="dbxPlayersLink">dbx_team_creation</Link></p>
      </div>
   );
};

export default MainDrawerContent;