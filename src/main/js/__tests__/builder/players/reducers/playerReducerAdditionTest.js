import team from 'builder/sponsors/reducers';
import * as types from 'builder/actions/actionTypes';

describe('Team reducer', () => {
   it('adds player when empty', () => {
      expect(
         team({ players: [] }, {
            type: types.ADD_TEAM_PLAYER,
            payload: 'player1'
         })
      ).toEqual(
         { players: [ 'player1' ] }
      )
   }),
   it('adds player', () => {
      expect(
         team({ players: [ 'player1', 'player2', 'player3' ] }, {
            type: types.ADD_TEAM_PLAYER,
            payload: 'player4'
         })
      ).toEqual(
         { players: [ 'player1', 'player2', 'player3', 'player4' ] }
      )
   }),
   it('adds already existing player', () => {
      expect(
         team({ players: [ 'player1', 'player2', 'player3' ] }, {
            type: types.ADD_TEAM_PLAYER,
            payload: 'player1'
         })
      ).toEqual(
         { players: [ 'player1', 'player2', 'player3', 'player1' ] }
      )
   }),
   it('ignores undefined players on addition', () => {
      expect(
         team({ players: [ 'player1', 'player2', 'player3' ] }, {
            type: types.ADD_TEAM_PLAYER,
            payload: undefined
         })
      ).toEqual(
         { players: [ 'player1', 'player2', 'player3' ] }
      )
   })
});
