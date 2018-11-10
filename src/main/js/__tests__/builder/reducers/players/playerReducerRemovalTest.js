import team from 'builder/reducers/sponsors';
import * as types from 'builder/actions/actionTypes';

describe('Team reducer', () => {
   it('does nothing when removing without players', () => {
      expect(
         team({ players: [] }, {
            type: types.REMOVE_TEAM_PLAYER,
            payload: 'player1'
         })
      ).toEqual(
         { players: [] }
      )
   }),
   it('removes players', () => {
      expect(
         team({ players: [ 'player1', 'player2', 'player3' ] }, {
            type: types.REMOVE_TEAM_PLAYER,
            payload: 'player1'
         })
      ).toEqual(
         { players: [ 'player2', 'player3' ] }
      )
   }),
   it('removes last player', () => {
      expect(
         team({ players: [ 'player1' ] }, {
            type: types.REMOVE_TEAM_PLAYER,
            payload: 'player1'
         })
      ).toEqual(
         { players: []}
      )
   }),
   it('removes a single instance of a player', () => {
      expect(
         team({ players: [ 'player1', 'player2', 'player3', 'player1' ] }, {
            type: types.REMOVE_TEAM_PLAYER,
            payload: 'player1'
         })
      ).toEqual(
         { players: [ 'player2', 'player3', 'player1' ] }
      )
   }),
   it('ignores undefined players on removal', () => {
      expect(
         team({ players: [ 'player1', 'player2', 'player3' ] }, {
            type: types.REMOVE_TEAM_PLAYER,
            payload: undefined
         })
      ).toEqual(
         { players: [ 'player1', 'player2', 'player3' ] }
      )
   })
});
