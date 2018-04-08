import { TOGGLE_SIDE_BAR, TOGGLE_NAV_BAR, SET_SMALL_SCREEN_STATUS, HIDE_NAV_ON_SMALL_SCREEN, HIDE_SIDE_ON_SMALL_SCREEN } from 'views/actions/actionTypes';

const views = (state = { navbarVisible: true, smallScreen: false }, action) => {
   const { type, payload } = action;

   switch (type) {
   case TOGGLE_NAV_BAR: {
      return {
         ...state,
         navbarVisible: !state.navbarVisible
      };
   }
   case TOGGLE_SIDE_BAR: {
      return {
         ...state,
         sidebarVisible: !state.sidebarVisible
      };
   }
   case SET_SMALL_SCREEN_STATUS: {
      return {
         ...state,
         smallScreen: payload,
         sidebarVisible: !payload,
         navbarVisible: !payload
      };
   }
   case HIDE_NAV_ON_SMALL_SCREEN: {
      return {
         ...state,
         navbarVisible: !state.smallScreen
      };
   }
   case HIDE_SIDE_ON_SMALL_SCREEN: {
      return {
         ...state,
         sidebarVisible: !state.smallScreen
      };
   }
   default:
      return state;
   }
};

export default views;
