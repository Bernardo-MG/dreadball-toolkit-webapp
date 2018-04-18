import affinities from 'builder/affinities/reducers';
import * as types from 'builder/affinities/actions/actionTypes';

describe('Team reducer', () => {
   it('clears affinities', () => {
      expect(
         affinities({ options: ['a', 'b'], chosen: ['c'] }, {
            type: types.CLEAR_TEAM
         })
      ).toEqual(
         { "chosen": [], "options": [] }
      )
   }),
   it('sets affinities', () => {
      expect(
         affinities({ options: ['a', 'b'], chosen: [] }, {
            type: types.SET_AFFINITY_OPTIONS,
            payload: ['c']
         })
      ).toEqual(
         { "chosen": [], "options": ['c'] }
      )
   }),
   it('sets chosen affinities', () => {
      expect(
         affinities({ chosen: ['a', 'b'] }, {
            type: types.SET_CHOSEN_AFFINITIES,
            payload: ['c']
         })
      ).toEqual(
         { "chosen": ['c'] }
      )
   }),
   it('when choosing overrides chosen', () => {
      expect(
         affinities({ chosen: ['a', 'b'] }, {
            type: types.CHOOSE_SPONSOR_AFFINITY,
            payload: 'c',
            index: 0
         })
      ).toEqual(
         { "chosen": ['c', 'b'] }
      )
   }),
   it('when choosing overrides adds chosen', () => {
      expect(
         affinities({ chosen: ['a', 'b'] }, {
            type: types.CHOOSE_SPONSOR_AFFINITY,
            payload: 'c',
            index: 2
         })
      ).toEqual(
         { "chosen": ['a', 'b', 'c'] }
      )
   })
});
