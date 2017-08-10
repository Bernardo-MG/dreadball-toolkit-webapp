import React from 'react';

import PropTypes from 'prop-types';

import EditIcon from 'grommet/components/icons/base/Edit';
import Button from 'grommet/components/Button';

const EditionButton = (props) => {
   return (
      <Button onClick={ props.onClick } icon={ <EditIcon /> } a11yTitle={ props.a11yTitle } />
   );
};

EditionButton.propTypes = {
   onClick: PropTypes.func.isRequired,
   a11yTitle: PropTypes.string
};

export default EditionButton;
