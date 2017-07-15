import React from 'react';

import EditIcon from 'grommet/components/icons/base/Edit';
import Button from 'grommet/components/Button';

const EditionButton = (props) => {
  return (
      <Button onClick={ props.onClick } icon={ <EditIcon /> } a11yTitle={ props.a11yTitle } />
  );
};

export default EditionButton;
