import model from 'players/reducers';
import * as types from 'players/actions/actionTypes';

describe('Model reducer', () => {
   it('creates players', () => {
      expect(
         model({}, {
            type: types.CREATE_PLAYERS,
            payload: { player1 : 'values', player2 : 'values', player3 : 'values' }
         })
      ).toEqual(
         { players: { player1 : 'values', player2 : 'values', player3 : 'values' } }
      )
   }),
   it('adds players', () => {
      expect(
         model({ players: { player1 : 'values', player2 : 'values', player3 : 'values' } }, {
            type: types.CREATE_PLAYERS,
            payload: { player3 : 'values', player4 : 'values', player5 : 'values' }
         })
      ).toEqual(
         { players: { player1 : 'values', player2 : 'values', player3 : 'values', player4 : 'values', player5 : 'values' } }
      )
   }),
   it('ignores undefined players', () => {
      expect(
         model({ players: { player1 : 'values', player2 : 'values', player3 : 'values' } }, {
            type: types.CREATE_PLAYERS,
            payload: undefined
         })
      ).toEqual(
         { players: { player1 : 'values', player2 : 'values', player3 : 'values' } }
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
   it('ignores undefined abilities', () => {
      expect(
         model({ abilities: { ability1 : 'values', ability2 : 'values', ability3 : 'values' } }, {
            type: types.CREATE_ABILITIES,
            payload: undefined
         })
      ).toEqual(
         { abilities: { ability1 : 'values', ability2 : 'values', ability3 : 'values' } }
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
   it('ignores undefined affinities', () => {
      expect(
         model({ affinities: { affinity1 : 'values', affinity2 : 'values', affinity3 : 'values' } }, {
            type: types.CREATE_AFFINITIES,
            payload: undefined
         })
      ).toEqual(
         { affinities: { affinity1 : 'values', affinity2 : 'values', affinity3 : 'values' } }
      )
   }),
   it('creates rated players', () => {
      expect(
         model({}, {
            type: types.CREATE_RATED_PLAYERS,
            payload: { player1 : 'values', player2 : 'values', player3 : 'values' }
         })
      ).toEqual(
         { ratedPlayers: { player1 : 'values', player2 : 'values', player3 : 'values' } }
      )
   }),
   it('adds rated players', () => {
      expect(
         model({ ratedPlayers: { player1 : 'values', player2 : 'values', player3 : 'values' } }, {
            type: types.CREATE_RATED_PLAYERS,
            payload: { player3 : 'values', player4 : 'values', player5 : 'values' }
         })
      ).toEqual(
         { ratedPlayers: { player1 : 'values', player2 : 'values', player3 : 'values', player4 : 'values', player5 : 'values' } }
      )
   }),
   it('ignores undefined players', () => {
      expect(
         model({ ratedPlayers: { player1 : 'values', player2 : 'values', player3 : 'values' } }, {
            type: types.CREATE_RATED_PLAYERS,
            payload: undefined
         })
      ).toEqual(
         { ratedPlayers: { player1 : 'values', player2 : 'values', player3 : 'values' } }
      )
   })
});
