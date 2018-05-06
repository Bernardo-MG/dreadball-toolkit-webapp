import team from 'builder/sponsors/reducers';
import * as types from 'builder/actions/actionTypes';

describe('Team reducer', () => {
   it('sets total cost', () => {
      expect(
         team({}, {
            type: types.SET_TOTAL_COST,
            payload: 1
         })
      ).toEqual(
            { 'totalCost': 1 }
      )
   }),
   it('sets total cost to zero', () => {
      expect(
         team({'totalCost': 1 }, {
            type: types.SET_TOTAL_COST,
            payload: 0
         })
      ).toEqual(
            { 'totalCost': 0 }
      )
   })
});
