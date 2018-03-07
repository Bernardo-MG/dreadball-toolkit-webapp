import React from 'react';

import PropTypes from 'prop-types';

import Box from 'grommet/components/Box';
import Button from 'grommet/components/Button';
import Menu from 'grommet/components/Menu';
import Sidebar from 'grommet/components/Sidebar';


const ButtonsSidebar = (props) =>
   <Sidebar size="small" colorIndex="light-3">
      <Box pad="medium">
         <Menu>
            { props.options.map((option, i) =>
               <Button key={i} align="start" plain={true} label={option.label} onClick={option.action} />
            )}
         </Menu>
      </Box>
   </Sidebar>;

ButtonsSidebar.propTypes = {
   options: PropTypes.arrayOf(PropTypes.shape({
      label: PropTypes.string,
      action: PropTypes.func
   }))
};

export default ButtonsSidebar;
