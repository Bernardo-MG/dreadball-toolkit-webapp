import React, { Component } from 'react';

import PropTypes from 'prop-types';

import Box from 'grommet/components/Box';
import Button from 'grommet/components/Button';
import Menu from 'grommet/components/Menu';
import Sidebar from 'grommet/components/Sidebar';


class SponsorTeamViewSidebar extends Component {

   render() {
      return (
         <Sidebar size="small" colorIndex="light-3">
            <Box pad="medium">
               <Menu>
                  <Button align="start" plain={true} label="assets" onClick={this.props.onSelectAssets} />
                  <Button align="start" plain={true} label="add_players" onClick={this.props.onSelectAddPlayers} />
                  <Button align="start" plain={true} label="players" onClick={this.props.onSelectPlayers} />
               </Menu>
            </Box>
         </Sidebar>
      );
   }
}

SponsorTeamViewSidebar.propTypes = {
   onSelectAssets: PropTypes.func.isRequired,
   onSelectAddPlayers: PropTypes.func.isRequired,
   onSelectPlayers: PropTypes.func.isRequired
};

export default SponsorTeamViewSidebar;
