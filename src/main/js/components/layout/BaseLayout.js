import React from 'react';

import PropTypes from 'prop-types';

import App from 'grommet/components/App';
import Split from 'grommet/components/Split';

import MainSidebar from 'components/layout/MainSidebar';

const BaseLayout = (props) =>
   <App centered={false}>
      <Split flex="right" separator={true} >
         <MainSidebar />
         {props.children}
      </Split>
   </App>;

BaseLayout.propTypes = {
   children: PropTypes.object.isRequired
};

export default BaseLayout;
