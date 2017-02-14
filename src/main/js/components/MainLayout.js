import React from 'react';
import BaseLayout from './BaseLayout';
import MainDrawerContent from './MainDrawerContent';

import GithubIcon from '../icons';

class MainLayout extends React.Component {
   render() {
         return (
             <BaseLayout drawerContent={ <MainDrawerContent/> } rightIcon={ <GithubIcon/> }>
                {this.props.children}
             </BaseLayout>
         );
     };
};

export default MainLayout;
module.exports = MainLayout;