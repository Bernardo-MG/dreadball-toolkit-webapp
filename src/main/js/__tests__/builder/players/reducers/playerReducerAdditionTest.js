import team from 'builder/reducers';
import * as types from 'builder/actions/actionTypes';

describe('Team reducer', () => {
   it('adds player when empty', () => {
      expect(
         team({}, {
            type: types.ADD_TEAM_PLAYER,
            payload: 'player1'
         })
      ).toEqual(
         { "affinities": {"chosen": [], "options": []}, "assets": {"cheerleaders": 0, "coachingDice": 0, "mediBots": 0, "nastySurpriseCards": 0, "specialMoveCards": 0, "wagers": 0}, "sponsor": {"baseRank": 0, "cheerleaders": 0, "coachingDice": 0, "mediBots": 0, "nastySurpriseCards": 0, "rank": 0, "specialMoveCards": 0, "sponsorName": "Sponsor name", "totalCost": 0,
            players: [ 'player1' ],
            "wagers": 0 }}
      )
   }),
   it('adds player', () => {
      expect(
         team({ "sponsor": { players: [ 'player1', 'player2', 'player3' ] } }, {
            type: types.ADD_TEAM_PLAYER,
            payload: 'player4'
         })
      ).toEqual(
         { "affinities": {"chosen": [], "options": []}, "assets": {"cheerleaders": 0, "coachingDice": 0, "mediBots": 0, "nastySurpriseCards": 0, "specialMoveCards": 0, "wagers": 0}, "sponsor": {
            players: [ 'player1', 'player2', 'player3', 'player4' ] }}
      )
   }),
   it('adds already existing player', () => {
      expect(
         team({ "sponsor": {players: [ 'player1', 'player2', 'player3' ] } }, {
            type: types.ADD_TEAM_PLAYER,
            payload: 'player1'
         })
      ).toEqual(
         { "affinities": {"chosen": [], "options": []}, "assets": {"cheerleaders": 0, "coachingDice": 0, "mediBots": 0, "nastySurpriseCards": 0, "specialMoveCards": 0, "wagers": 0}, "sponsor": {
            players: [ 'player1', 'player2', 'player3', 'player1' ] }}
      )
   }),
   it('ignores undefined players on addition', () => {
      expect(
         team({ "sponsor": {players: [ 'player1', 'player2', 'player3' ] } }, {
            type: types.ADD_TEAM_PLAYER,
            payload: undefined
         })
      ).toEqual(
         { "affinities": {"chosen": [], "options": []}, "assets": {"cheerleaders": 0, "coachingDice": 0, "mediBots": 0, "nastySurpriseCards": 0, "specialMoveCards": 0, "wagers": 0}, "sponsor": {
            players: [ 'player1', 'player2', 'player3' ] }}
      )
   })
});
