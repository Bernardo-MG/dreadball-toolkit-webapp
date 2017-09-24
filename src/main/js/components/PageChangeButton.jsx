import React, { Component } from 'react';

import PropTypes from 'prop-types';

import Button from 'grommet/components/Button';

class PageChangeButton extends Component {

   changePage;

   move = () => {
      this.changePage(this.props.fetch, this.props.page, this.props.endingPage);
   };

   constructor(props) {
      super(props);

      this.changePage = this.props.changePage;
   }

   render() {
      return (
         <Button onClick={this.move} label={this.props.label} icon={this.props.icon} />
      );
   }
}

PageChangeButton.propTypes = {
   changePage: PropTypes.func.isRequired,
   fetch: PropTypes.func.isRequired,
   page: PropTypes.number.isRequired,
   endingPage: PropTypes.bool,
   label: PropTypes.string,
   icon: PropTypes.object
};

export default PageChangeButton;
