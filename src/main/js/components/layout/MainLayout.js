import React from 'react';
import BaseLayout from './BaseLayout';
import MainDrawerContent from '../MainDrawerContent';

import GithubIcon from '../../icons';

const MainLayout = (props) => {
   return (
      <BaseLayout drawerContent={ <MainDrawerContent/> } rightIcon={ <GithubIcon/> }>
         {props.children}
      </BaseLayout>
   );
};

export default MainLayout;