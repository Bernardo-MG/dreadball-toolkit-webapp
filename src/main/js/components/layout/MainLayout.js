import React from 'react';
import BaseLayout from 'components/layout/BaseLayout';
import MainDrawerContent from 'components/MainDrawerContent';

import GithubIcon from 'icons';

const MainLayout = (props) => {
   return (
      <BaseLayout drawerContent={ <MainDrawerContent/> } rightIcon={ <GithubIcon/> }>
         {props.children}
      </BaseLayout>
   );
};

export default MainLayout;