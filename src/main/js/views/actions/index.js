import { TOGGLE_SIDE_BAR, TOGGLE_NAV_BAR, HIDE_SIDE_ON_SMALL_SCREEN, HIDE_NAV_ON_SMALL_SCREEN, SET_SMALL_SCREEN_STATUS } from 'views/actions/actionTypes';

export const toggleSideBar = () => {
   return {
      type: TOGGLE_SIDE_BAR
   };
};

export const toggleNavBar = () => {
   return {
      type: TOGGLE_NAV_BAR
   };
};

export const hideSideBarOnSmallScreen = () => {
   return {
      type: HIDE_SIDE_ON_SMALL_SCREEN
   };
};

export const hideNavBarOnSmallScreen = () => {
   return {
      type: HIDE_NAV_ON_SMALL_SCREEN
   };
};

export const setSmallScreenStatus = (visible) => {
   return {
      type: SET_SMALL_SCREEN_STATUS,
      payload: visible
   };
};
