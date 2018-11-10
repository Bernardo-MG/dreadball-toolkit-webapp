import team from 'builder/reducers/sponsors';
import * as types from 'builder/actions/actionTypes';

describe('Sponsor reducer', () => {
   it('sets sponsor name', () => {
      expect(
         team({}, {
            type: types.SET_SPONSOR_NAME,
            payload: 'name'
         })
      ).toEqual(
            { 'sponsorName': 'name' }
      )
   }),
   it('overwrites sponsor name', () => {
      expect(
         team({ 'sponsorName': 'name' }, {
            type: types.SET_SPONSOR_NAME,
            payload: ''
         })
      ).toEqual(
            { 'sponsorName': '' }
      )
   })
});
