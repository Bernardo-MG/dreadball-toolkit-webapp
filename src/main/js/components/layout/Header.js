import React from 'react';
import Anchor from 'grommet/components/Anchor';
import Box from 'grommet/components/Box';
import Header from 'grommet/components/Header';
import Menu from 'grommet/components/Menu';
import SearchIcon from 'grommet/components/icons/base/Search';

export default function AppHeader (props) {
  return (
    <Header justify="center" colorIndex="neutral-4">
      <Box size={{width: {max: 'xxlarge'}}} direction="row"
        responsive={false} justify="start" align="center"
        pad={{horizontal: 'medium'}} flex="grow">
        <Menu label="Label" inline={true} direction="row" flex="grow">
          <Anchor href="#">DBX team creation</Anchor>
          <Anchor href="#">Players list</Anchor>
        </Menu>
      </Box>
    </Header>
  );
};
