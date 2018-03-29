import { TOGGLE_NAV_BAR, HIDE_NAV_ON_SMALL_SCREEN, SET_NAV_BAR_VISIBLE_STATUS, SET_SMALL_SCREEN_STATUS } from 'views/actions/actionTypes';

export const toggleNavBar = () => {
   return {
      type: TOGGLE_NAV_BAR
   };
};

export const hideNavBarOnSmallScreen = () => {
   return {
      type: HIDE_NAV_ON_SMALL_SCREEN
   };
};

export const setNavBarVisibleStatus = (visible) => {
   return {
      type: SET_NAV_BAR_VISIBLE_STATUS,
      payload: visible
   };
};

export const setSmallScreenStatus = (visible) => {
   return {
      type: SET_SMALL_SCREEN_STATUS,
      payload: visible
   };
};
