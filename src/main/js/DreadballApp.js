import React from 'react';
import MainLayout from './layout/main';

class DreadballApp extends React.Component {
   render() {
         return (
             <MainLayout>
	            <h1>Main Content</h1>
	            <p>Main content goes here.</p>
             </MainLayout>
         );
     };
};

export default DreadballApp;
module.exports = DreadballApp;