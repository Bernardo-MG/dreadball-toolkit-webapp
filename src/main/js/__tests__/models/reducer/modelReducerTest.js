import model from 'models/reducers';
import * as types from 'models/actions/actionTypes';

describe('Model reducer', () => {
   it('creates units', () => {
      expect(
         model({}, {
            type: types.CREATE_UNITS,
            payload: { unit1 : 'values', unit2 : 'values', unit3 : 'values' }
         })
      ).toEqual(
         { units: { unit1 : 'values', unit2 : 'values', unit3 : 'values' } }
      )
   }),
   it('adds units', () => {
      expect(
         model({ units: { unit1 : 'values', unit2 : 'values', unit3 : 'values' } }, {
            type: types.CREATE_UNITS,
            payload: { unit3 : 'values', unit4 : 'values', unit5 : 'values' }
         })
      ).toEqual(
         { units: { unit1 : 'values', unit2 : 'values', unit3 : 'values', unit4 : 'values', unit5 : 'values' } }
      )
   }),
   it('creates abilities', () => {
      expect(
         model({}, {
            type: types.CREATE_ABILITIES,
            payload: { ability1 : 'values', ability2 : 'values', ability3 : 'values' }
         })
      ).toEqual(
         { abilities: { ability1 : 'values', ability2 : 'values', ability3 : 'values' } }
      )
   }),
   it('adds abilities', () => {
      expect(
         model({ abilities: { ability1 : 'values', ability2 : 'values', ability3 : 'values' } }, {
            type: types.CREATE_ABILITIES,
            payload: { ability3 : 'values', ability4 : 'values', ability5 : 'values' }
         })
      ).toEqual(
         { abilities: { ability1 : 'values', ability2 : 'values', ability3 : 'values', ability4 : 'values', ability5 : 'values' } }
      )
   }),
   it('creates affinities', () => {
      expect(
         model({}, {
            type: types.CREATE_AFFINITIES,
            payload: { affinity1 : 'values', affinity2 : 'values', affinity3 : 'values' }
         })
      ).toEqual(
         { affinities: { affinity1 : 'values', affinity2 : 'values', affinity3 : 'values' } }
      )
   }),
   it('adds affinities', () => {
      expect(
         model({ affinities: { affinity1 : 'values', affinity2 : 'values', affinity3 : 'values' } }, {
            type: types.CREATE_AFFINITIES,
            payload: { affinity3 : 'values', affinity4 : 'values', affinity5 : 'values' }
         })
      ).toEqual(
         { affinities: { affinity1 : 'values', affinity2 : 'values', affinity3 : 'values', affinity4 : 'values', affinity5 : 'values' } }
      )
   }),
   it('creates rated units', () => {
      expect(
         model({}, {
            type: types.CREATE_RATED_UNITS,
            payload: { unit1 : 'values', unit2 : 'values', unit3 : 'values' }
         })
      ).toEqual(
         { ratedUnits: { unit1 : 'values', unit2 : 'values', unit3 : 'values' } }
      )
   }),
   it('adds rated units', () => {
      expect(
         model({ ratedUnits: { unit1 : 'values', unit2 : 'values', unit3 : 'values' } }, {
            type: types.CREATE_RATED_UNITS,
            payload: { unit3 : 'values', unit4 : 'values', unit5 : 'values' }
         })
      ).toEqual(
         { ratedUnits: { unit1 : 'values', unit2 : 'values', unit3 : 'values', unit4 : 'values', unit5 : 'values' } }
      )
   })
});
