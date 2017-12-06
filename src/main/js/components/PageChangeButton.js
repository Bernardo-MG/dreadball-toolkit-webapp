import React from 'react';

import PropTypes from 'prop-types';

import Button from 'grommet/components/Button';

const PageChangeButton = (props) =>
   <Button onClick={props.changePage} icon={props.icon} />;

PageChangeButton.propTypes = {
   changePage: PropTypes.func.isRequired,
   icon: PropTypes.object.isRequired
};

export default PageChangeButton;
