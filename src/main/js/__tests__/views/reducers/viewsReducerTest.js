import views from 'views/reducers';
import * as types from 'views/actions/actionTypes';

describe('Views reducer', () => {
   it('should return the initial state', () => {
      expect(
            views(undefined, {})
         ).toEqual(
         {
            "navbarVisible": true,
            "smallScreen": false
         }
      )
   }),
   it('should toggle navbar from visible to not visible', () => {
      expect(
         views({ "navbarVisible": true }, {
            type: types.TOGGLE_NAV_BAR
         })
      ).toEqual(
         {
            "navbarVisible": false
         }
      )
   }),
   it('should toggle navbar from not visible to visible', () => {
      expect(
         views({ "navbarVisible": false }, {
            type: types.TOGGLE_NAV_BAR
         })
      ).toEqual(
         {
            "navbarVisible": true
         }
      )
   }),
   it('should toggle side bar from visible to not visible', () => {
      expect(
         views({ "sidebarVisible": true }, {
            type: types.TOGGLE_SIDE_BAR
         })
      ).toEqual(
         {
            "sidebarVisible": false
         }
      )
   }),
   it('should toggle side bar from not visible to visible', () => {
      expect(
         views({ "sidebarVisible": false }, {
            type: types.TOGGLE_SIDE_BAR
         })
      ).toEqual(
         {
            "sidebarVisible": true
         }
      )
   }),
   it('should hide navbar on small screen', () => {
      expect(
         views({ "smallScreen": true }, {
            type: types.HIDE_NAV_ON_SMALL_SCREEN
         })
      ).toEqual(
         {
            "navbarVisible": false,
            "smallScreen": true
         }
      )
   }),
   it('should not hide navbar when not on small screen', () => {
      expect(
         views({ "smallScreen": false }, {
            type: types.HIDE_NAV_ON_SMALL_SCREEN
         })
      ).toEqual(
         {
            "navbarVisible": true,
            "smallScreen": false
         }
      )
   }),
   it('should hide side bar on small screen', () => {
      expect(
         views({ "smallScreen": true }, {
            type: types.HIDE_SIDE_ON_SMALL_SCREEN
         })
      ).toEqual(
         {
            "sidebarVisible": false,
            "smallScreen": true
         }
      )
   }),
   it('should not hide side bar when not on small screen', () => {
      expect(
         views({ "smallScreen": false }, {
            type: types.HIDE_SIDE_ON_SMALL_SCREEN
         })
      ).toEqual(
         {
            "sidebarVisible": true,
            "smallScreen": false
         }
      )
   })
});
