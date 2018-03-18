import React from 'react';

import PropTypes from 'prop-types';

import Anchor from 'grommet/components/Anchor';
import Button from 'grommet/components/Button';
import Header from 'grommet/components/Header';
import Menu from 'grommet/components/Menu';
import Sidebar from 'grommet/components/Sidebar';
import Footer from 'grommet/components/Footer';

import SocialGithubIcon from 'grommet/components/icons/base/SocialGithub';

const MainSidebar = (props) =>
   <Sidebar size="small" colorIndex="light-2">
      <Header size="large" justify="between" pad={ { horizontal: 'medium' } }>
         {props.title}
         {props.menuButton}
      </Header>
      <Menu fill={true} primary={true}>
         { props.links.map((option, i) =>
            <Anchor key={i} path={option.path} label={option.label} onClick={props.onClickLink} />
         )}
      </Menu>
      <Footer pad={ { horizontal: 'medium', vertical: 'small' } }>
         <p>{APP_VERSION}</p> <Button href={REPO_URL} icon={<SocialGithubIcon/>} />
      </Footer>
   </Sidebar>;

MainSidebar.propTypes = {
   menuButton: PropTypes.object.isRequired,
   onClickLink: PropTypes.func.isRequired,
   title: PropTypes.string,
   links: PropTypes.arrayOf(PropTypes.shape({
      label: PropTypes.string,
      path: PropTypes.string
   }))
};

export default MainSidebar;
