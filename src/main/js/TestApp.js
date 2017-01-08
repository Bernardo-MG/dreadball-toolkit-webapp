import React from 'react';

import Anchor from 'grommet/components/Anchor';
import App from 'grommet/components/App';
import Box from 'grommet/components/Box';
import Footer from 'grommet/components/Footer';
import Header from 'grommet/components/Header';
import Title from 'grommet/components/Title';

const TodoApp = () => {
  return (
    <App centered={false}>
      <Box full={true}>
        <Header direction="row" justify="between" pad={{horizontal: 'medium'}}>
          <Title>Test App</Title>
        </Header>
        <Footer primary={true} appCentered={true} direction="column"
           align="center" pad="small" colorIndex="grey-1">
           <p>
             Test footer
           </p>
         </Footer>
      </Box>
    </App>
  );
};

export default TodoApp;
module.exports = TodoApp;