import team from 'builder/reducers/sponsors';
import * as types from 'builder/actions/actionTypes';

describe('Sponsor reducer', () => {
   it('sets rank', () => {
      expect(
         team({}, {
            type: types.SET_RANK,
            payload: 1
         })
      ).toEqual(
            { 'rank': 1 }
      )
   }),
   it('sets rank to zero', () => {
      expect(
         team({'rank': 1 }, {
            type: types.SET_RANK,
            payload: 0
         })
      ).toEqual(
            { 'rank': 0 }
      )
   }),
   it('sets base rank', () => {
      expect(
         team({}, {
            type: types.SET_BASE_RANK,
            payload: 1
         })
      ).toEqual(
            { 'baseRank': 1 }
      )
   }),
   it('sets base rank to zero', () => {
      expect(
         team({'baseRank': 1 }, {
            type: types.SET_BASE_RANK,
            payload: 0
         })
      ).toEqual(
            { 'baseRank': 0 }
      )
   })
});
