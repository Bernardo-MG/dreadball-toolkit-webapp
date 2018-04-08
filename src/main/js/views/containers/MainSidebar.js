import React from 'react';

import PropTypes from 'prop-types';

import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

import Anchor from 'grommet/components/Anchor';
import Button from 'grommet/components/Button';
import Footer from 'grommet/components/Footer';
import Header from 'grommet/components/Header';
import Menu from 'grommet/components/Menu';
import Paragraph from 'grommet/components/Paragraph';
import Sidebar from 'grommet/components/Sidebar';

import CloseIcon from 'grommet/components/icons/base/Close';

import SocialGithubIcon from 'grommet/components/icons/base/SocialGithub';

import { toggleNavBar, hideNavBarOnSmallScreen } from 'views/actions';

import { selectNavbarVisible } from 'views/selectors';

const MainSidebar = (props) =>
   <Sidebar size="small" colorIndex="light-2">
      <Header size="large" justify="between" pad={ { horizontal: 'medium' } }>
         {props.title}
         {<Button onClick={() => props.toggleNavBar()} icon={<CloseIcon/>} />}
      </Header>
      <Menu fill={true} primary={true}>
         { props.links.map((option, i) =>
            <Anchor key={i} path={option.path} label={option.label} onClick={props.onClickLink} />
         )}
      </Menu>
      <Footer pad={ { horizontal: 'medium', vertical: 'small' } }>
         <Paragraph>Dreadball © Mantic</Paragraph>
      </Footer>
      <Footer pad={ { horizontal: 'medium', vertical: 'small' } }>
         <Paragraph>{APP_VERSION}</Paragraph> <Button href={REPO_URL} icon={<SocialGithubIcon/>} />
      </Footer>
   </Sidebar>;

MainSidebar.propTypes = {
   toggleNavBar: PropTypes.func.isRequired,
   onClickLink: PropTypes.func.isRequired,
   title: PropTypes.string,
   links: PropTypes.arrayOf(PropTypes.shape({
      label: PropTypes.string,
      path: PropTypes.string
   }))
};

const mapStateToProps = (state) => {
   return {
      navbarVisible: selectNavbarVisible(state)
   };
};

const mapDispatchToProps = (dispatch) => {
   return {
      toggleNavBar: bindActionCreators(toggleNavBar, dispatch),
      onClickLink: bindActionCreators(hideNavBarOnSmallScreen, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(MainSidebar);
