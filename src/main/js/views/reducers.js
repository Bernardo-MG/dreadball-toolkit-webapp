import { TOGGLE_NAV_BAR, SET_NAV_BAR_VISIBLE_STATUS, SET_SMALL_SCREEN_STATUS, HIDE_NAV_ON_SMALL_SCREEN } from 'views/actions/actionTypes';

const views = (state = { navbarVisible: true, smallScreen: false }, action) => {
   const { type, payload } = action;

   switch (type) {
   case TOGGLE_NAV_BAR: {
      return {
         ...state,
         navbarVisible: !state.navbarVisible
      };
   }
   case SET_NAV_BAR_VISIBLE_STATUS: {
      return {
         ...state,
         navbarVisible: payload
      };
   }
   case SET_SMALL_SCREEN_STATUS: {
      return {
         ...state,
         smallScreen: payload
      };
   }
   case HIDE_NAV_ON_SMALL_SCREEN: {
      return {
         ...state,
         navbarVisible: !state.smallScreen
      };
   }
   default:
      return state;
   }
};

export default views;
