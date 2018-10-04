import affinities from 'builder/affinities/reducers';
import * as ActionTypes from 'builder/actions/actionTypes';

describe('Team reducer', () => {
   it('clears affinities', () => {
      expect(
         affinities({ options: ['a', 'b'], chosen: ['c'] }, {
            type: ActionTypes.CLEAR_TEAM
         })
      ).toEqual(
         { 'chosen': [], 'options': ['a', 'b'] }
      )
   }),
   it('sets affinities', () => {
      expect(
         affinities({ options: ['a', 'b'], chosen: [] }, {
            type: ActionTypes.SET_AFFINITY_OPTIONS,
            payload: ['c']
         })
      ).toEqual(
         { 'chosen': [], 'options': ['c'] }
      )
   }),
   it('sets chosen affinities', () => {
      expect(
         affinities({ chosen: ['a', 'b'] }, {
            type: ActionTypes.SET_CHOSEN_AFFINITIES,
            payload: ['c']
         })
      ).toEqual(
         { 'chosen': ['c'] }
      )
   }),
   it('when choosing overrides chosen', () => {
      expect(
         affinities({ chosen: ['a', 'b'] }, {
            type: ActionTypes.CHOOSE_SPONSOR_AFFINITY,
            payload: 'c',
            index: 0
         })
      ).toEqual(
         { 'chosen': ['c', 'b'] }
      )
   }),
   it('when choosing overrides adds chosen', () => {
      expect(
         affinities({ chosen: ['a', 'b'] }, {
            type: ActionTypes.CHOOSE_SPONSOR_AFFINITY,
            payload: 'c',
            index: 2
         })
      ).toEqual(
         { 'chosen': ['a', 'b', 'c'] }
      )
   })
});
