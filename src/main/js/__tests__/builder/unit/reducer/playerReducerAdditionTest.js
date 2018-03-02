import team from 'builder/reducers';
import * as types from 'builder/actions/actionTypes';

describe('Team reducer', () => {
   it('adds unit when empty', () => {
      expect(
         team({}, {
            type: types.ADD_TEAM_UNIT,
            payload: 'unit1'
         })
      ).toEqual(
         { "affinities": {"chosen": [], "options": []}, "assets": {"cheerleaders": 0, "coachingDice": 0, "mediBots": 0, "nastySurpriseCards": 0, "specialMoveCards": 0, "wagers": 0}, "sponsor": {"baseRank": 0, "cheerleaders": 0, "coachingDice": 0, "mediBots": 0, "nastySurpriseCards": 0, "rank": 0, "specialMoveCards": 0, "sponsorName": "Sponsor name", "totalCost": 0,
            units: [ 'unit1' ],
            "wagers": 0 }}
      )
   }),
   it('adds unit', () => {
      expect(
         team({ "sponsor": { units: [ 'unit1', 'unit2', 'unit3' ] } }, {
            type: types.ADD_TEAM_UNIT,
            payload: 'unit4'
         })
      ).toEqual(
         { "affinities": {"chosen": [], "options": []}, "assets": {"cheerleaders": 0, "coachingDice": 0, "mediBots": 0, "nastySurpriseCards": 0, "specialMoveCards": 0, "wagers": 0}, "sponsor": {
            units: [ 'unit1', 'unit2', 'unit3', 'unit4' ] }}
      )
   }),
   it('adds already existing unit', () => {
      expect(
         team({ "sponsor": {units: [ 'unit1', 'unit2', 'unit3' ] } }, {
            type: types.ADD_TEAM_UNIT,
            payload: 'unit1'
         })
      ).toEqual(
         { "affinities": {"chosen": [], "options": []}, "assets": {"cheerleaders": 0, "coachingDice": 0, "mediBots": 0, "nastySurpriseCards": 0, "specialMoveCards": 0, "wagers": 0}, "sponsor": {
            units: [ 'unit1', 'unit2', 'unit3', 'unit1' ] }}
      )
   }),
   it('ignores undefined units on addition', () => {
      expect(
         team({ "sponsor": {units: [ 'unit1', 'unit2', 'unit3' ] } }, {
            type: types.ADD_TEAM_UNIT,
            payload: undefined
         })
      ).toEqual(
         { "affinities": {"chosen": [], "options": []}, "assets": {"cheerleaders": 0, "coachingDice": 0, "mediBots": 0, "nastySurpriseCards": 0, "specialMoveCards": 0, "wagers": 0}, "sponsor": {
            units: [ 'unit1', 'unit2', 'unit3' ] }}
      )
   })
});
