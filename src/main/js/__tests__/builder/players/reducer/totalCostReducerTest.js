import team from 'builder/reducers';
import * as types from 'builder/actions/actionTypes';

describe('Team reducer', () => {
   it('sets total cost', () => {
      expect(
         team({}, {
            type: types.SET_TOTAL_COST,
            payload: 1
         })
      ).toEqual(
            {"affinities": {"chosen": [], "options": []}, "assets": {"cheerleaders": 0, "coachingDice": 0, "mediBots": 0, "nastySurpriseCards": 0, "specialMoveCards": 0, "wagers": 0}, "sponsor": {"baseRank": 0, "cheerleaders": 0, "coachingDice": 0, "mediBots": 0, "nastySurpriseCards": 0, "rank": 0, "specialMoveCards": 0, "sponsorName": "Sponsor name",
               "totalCost": 1,
               "players": [], "wagers": 0}}
      )
   }),
   it('sets total cost to zero', () => {
      expect(
         team({ "sponsor": { "totalCost": 1 } }, {
            type: types.SET_TOTAL_COST,
            payload: 0
         })
      ).toEqual(
            {"affinities": {"chosen": [], "options": []}, "assets": {"cheerleaders": 0, "coachingDice": 0, "mediBots": 0, "nastySurpriseCards": 0, "specialMoveCards": 0, "wagers": 0},
               "sponsor": {"totalCost": 0}}
      )
   })
});
