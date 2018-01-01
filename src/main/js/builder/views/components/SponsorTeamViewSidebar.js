import React, { Component } from 'react';

import PropTypes from 'prop-types';

import Box from 'grommet/components/Box';
import Button from 'grommet/components/Button';
import Menu from 'grommet/components/Menu';
import Sidebar from 'grommet/components/Sidebar';


class SponsorTeamViewSidebar extends Component {

   render() {
      return (
         <Sidebar size="medium" colorIndex="light-2">
            <Box pad="medium">
               <Menu>
                  <Button align="start" plain={true} label="assets" onClick={this.props.onSelectAssets} />
                  <Button align="start" plain={true} label="add_units" onClick={this.props.onSelectAddUnits} />
                  <Button align="start" plain={true} label="units" onClick={this.props.onSelectUnits} />
               </Menu>
            </Box>
         </Sidebar>
      );
   }
}

SponsorTeamViewSidebar.propTypes = {
   onSelectAssets: PropTypes.func.isRequired,
   onSelectAddUnits: PropTypes.func.isRequired,
   onSelectUnits: PropTypes.func.isRequired
};

export default SponsorTeamViewSidebar;
