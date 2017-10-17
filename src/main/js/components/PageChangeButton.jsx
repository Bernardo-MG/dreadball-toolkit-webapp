import React, { Component } from 'react';

import PropTypes from 'prop-types';

import Button from 'grommet/components/Button';

class PageChangeButton extends Component {

   changePage;

   move = () => {
      this.changePage();
   };

   constructor(props) {
      super(props);

      this.changePage = this.props.changePage;
   }

   render() {
      return (
         <Button onClick={this.move} icon={this.props.icon} />
      );
   }
}

PageChangeButton.propTypes = {
   changePage: PropTypes.func.isRequired,
   icon: PropTypes.object
};

export default PageChangeButton;
