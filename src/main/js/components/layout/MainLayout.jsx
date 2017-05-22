import React from 'react';
import BaseLayout from 'components/layout/BaseLayout';

const MainLayout = (props) => {
   return (
      <BaseLayout>
         {props.children}
      </BaseLayout>
   );
};

export default MainLayout;
