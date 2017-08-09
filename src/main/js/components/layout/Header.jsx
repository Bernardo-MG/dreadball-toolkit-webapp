import React from 'react';
import Box from 'grommet/components/Box';
import Header from 'grommet/components/Header';
import Menu from 'grommet/components/Menu';
import NavAnchor from 'components/NavAnchor';

const AppHeader = (props) => {
  return (
    <Header justify="center" colorIndex="neutral-4">
      <Box size={ { width: { max: 'xxlarge' } } } direction="row"
        responsive={false} justify="start" align="center"
        pad={ { horizontal: 'medium' } } flex="grow">
        <Menu label="Label" inline={true} direction="row" flex="grow">
          <NavAnchor path="/dbx">dbx_team_creation</NavAnchor>
          <NavAnchor path="/players">units_list</NavAnchor>
        </Menu>
      </Box>
    </Header>
  );
};

export default AppHeader;
