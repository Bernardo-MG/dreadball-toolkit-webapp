import team from 'builder/reducers';
import * as types from 'builder/actions/actionTypes';

describe('Team reducer', () => {
   it('does nothing when removing without players', () => {
      expect(
         team({}, {
            type: types.REMOVE_TEAM_PLAYER,
            payload: 'player1'
         })
      ).toEqual(
         { "affinities": {"chosen": [], "options": []}, "assets": {"cheerleaders": 0, "coachingDice": 0, "mediBots": 0, "nastySurpriseCards": 0, "specialMoveCards": 0, "wagers": 0}, "sponsor": {"baseRank": 0, "cheerleaders": 0, "coachingDice": 0, "mediBots": 0, "nastySurpriseCards": 0, "rank": 0, "specialMoveCards": 0, "sponsorName": "Sponsor name", "totalCost": 0,
            players: [],
            "wagers": 0 }}
      )
   }),
   it('removes players', () => {
      expect(
         team({ "sponsor": { players: [ 'player1', 'player2', 'player3' ] } }, {
            type: types.REMOVE_TEAM_PLAYER,
            payload: 'player1'
         })
      ).toEqual(
         { "affinities": {"chosen": [], "options": []}, "assets": {"cheerleaders": 0, "coachingDice": 0, "mediBots": 0, "nastySurpriseCards": 0, "specialMoveCards": 0, "wagers": 0}, "sponsor": {
            players: [ 'player2', 'player3' ] }}
      )
   }),
   it('removes last player', () => {
      expect(
         team({ "sponsor": { players: [ 'player1' ] } }, {
            type: types.REMOVE_TEAM_PLAYER,
            payload: 'player1'
         })
      ).toEqual(
         { "affinities": {"chosen": [], "options": []}, "assets": {"cheerleaders": 0, "coachingDice": 0, "mediBots": 0, "nastySurpriseCards": 0, "specialMoveCards": 0, "wagers": 0}, "sponsor": {
            players: [] }}
      )
   }),
   it('removes a single instance of a player', () => {
      expect(
         team({ "sponsor": { players: [ 'player1', 'player2', 'player3', 'player1' ] } }, {
            type: types.REMOVE_TEAM_PLAYER,
            payload: 'player1'
         })
      ).toEqual(
         { "affinities": {"chosen": [], "options": []}, "assets": {"cheerleaders": 0, "coachingDice": 0, "mediBots": 0, "nastySurpriseCards": 0, "specialMoveCards": 0, "wagers": 0}, "sponsor": {
            players: [ 'player2', 'player3', 'player1' ] }}
      )
   }),
   it('ignores undefined players on removal', () => {
      expect(
         team({ "sponsor": { players: [ 'player1', 'player2', 'player3' ] } }, {
            type: types.REMOVE_TEAM_PLAYER,
            payload: undefined
         })
      ).toEqual(
         { "affinities": {"chosen": [], "options": []}, "assets": {"cheerleaders": 0, "coachingDice": 0, "mediBots": 0, "nastySurpriseCards": 0, "specialMoveCards": 0, "wagers": 0}, "sponsor": {
            players: [ 'player1', 'player2', 'player3' ] }}
      )
   })
});
