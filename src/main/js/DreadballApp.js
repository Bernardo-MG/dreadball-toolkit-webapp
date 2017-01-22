import React from 'react';
import ReactDOM from 'react-dom';
import MainLayout from './layout/main';

class DreadballApp extends React.Component {
   state = {
         drawerActive: false
     };

   toggleDrawerActive = () => {
       this.setState({ drawerActive: !this.state.drawerActive });
   };
   
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