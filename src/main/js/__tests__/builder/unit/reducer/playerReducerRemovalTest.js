import team from 'builder/reducers';
import * as types from 'builder/actions/actionTypes';

describe('Team reducer', () => {
   it('does nothing when removing without units', () => {
      expect(
         team({}, {
            type: types.REMOVE_TEAM_UNIT,
            payload: 'unit1'
         })
      ).toEqual(
         { "affinities": {"chosen": [], "options": []}, "assets": {"cheerleaders": 0, "coachingDice": 0, "mediBots": 0, "nastySurpriseCards": 0, "specialMoveCards": 0, "wagers": 0}, "sponsor": {"baseRank": 0, "cheerleaders": 0, "coachingDice": 0, "mediBots": 0, "nastySurpriseCards": 0, "rank": 0, "specialMoveCards": 0, "sponsorName": "Sponsor name", "teamValue": 0,
            units: [],
            "wagers": 0 }}
      )
   }),
   it('removes units', () => {
      expect(
         team({ "sponsor": { units: [ 'unit1', 'unit2', 'unit3' ] } }, {
            type: types.REMOVE_TEAM_UNIT,
            payload: 'unit1'
         })
      ).toEqual(
         { "affinities": {"chosen": [], "options": []}, "assets": {"cheerleaders": 0, "coachingDice": 0, "mediBots": 0, "nastySurpriseCards": 0, "specialMoveCards": 0, "wagers": 0}, "sponsor": {
            units: [ 'unit2', 'unit3' ] }}
      )
   }),
   it('ignores undefined units on removal', () => {
      expect(
         team({ "sponsor": { units: [ 'unit1', 'unit2', 'unit3' ] } }, {
            type: types.REMOVE_TEAM_UNIT,
            payload: undefined
         })
      ).toEqual(
         { "affinities": {"chosen": [], "options": []}, "assets": {"cheerleaders": 0, "coachingDice": 0, "mediBots": 0, "nastySurpriseCards": 0, "specialMoveCards": 0, "wagers": 0}, "sponsor": {
            units: [ 'unit1', 'unit2', 'unit3' ] }}
      )
   }),
   it('removes a single instance of a unit', () => {
      expect(
         team({ "sponsor": { units: [ 'unit1', 'unit2', 'unit3', 'unit1' ] } }, {
            type: types.REMOVE_TEAM_UNIT,
            payload: 'unit1'
         })
      ).toEqual(
         { "affinities": {"chosen": [], "options": []}, "assets": {"cheerleaders": 0, "coachingDice": 0, "mediBots": 0, "nastySurpriseCards": 0, "specialMoveCards": 0, "wagers": 0}, "sponsor": {
            units: [ 'unit2', 'unit3', 'unit1' ] }}
      )
   })
});
