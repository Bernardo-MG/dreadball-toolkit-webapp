import * as ActionTypes from 'builder/actions/ActionTypes';
import { combineReducers } from 'redux';

const sponsor = (
      state = { sponsorName: 'Sponsor name', rank: 0, baseRank: 0, teamValue: 0, affinities: [], units: [], coachingDice: 0, specialMoveCards: 0, nastySurpriseCards: 0, wagers: 0, mediBots: 0, cheerleaders: 0 },
      action) => {
   const { type, payload } = action;
   const affinities = state.affinities.slice();
   const units = state.units.slice();
   switch (type) {
   case ActionTypes.BEGIN_DBX_TEAM_BUILDING:
      return {
         affinities: [],
         rank: 0,
         baseRank: 0,
         teamValue: 0,
         units: [],
         sponsorName: 'Sponsor name',
         coachingDice: 0,
         specialMoveCards: 0,
         nastySurpriseCards: 0,
         wagers: 0,
         mediBots: 0,
         cheerleaders: 0
      };
   case ActionTypes.CHOOSE_SPONSOR_AFFINITY:
      affinities[action.index] = payload;

      return {
         ...state,
         affinities
      };
   case ActionTypes.CHOOSE_SPONSOR_UNIT:
      units.push(payload);

      return {
         ...state,
         units
      };
   case ActionTypes.REQUEST_SPONSOR_TEAM_VALIDATION_SUCCESS:
      return {
         ...state,
         ...payload
      };
   case ActionTypes.REQUEST_SPONSOR_TEAM_VALIDATION_AFFINITIES_SUCCESS:
      return {
         ...state,
         ...payload
      };
   case ActionTypes.UPDATE_SPONSOR_CHEERLEADERS: {
      const cheerleaders = payload;

      return {
         ...state,
         cheerleaders
      };
   }
   case ActionTypes.UPDATE_SPONSOR_COACHING_DICE: {
      const coachingDice = payload;

      return {
         ...state,
         coachingDice
      };
   }
   case ActionTypes.UPDATE_SPONSOR_MEDIBOT: {
      const mediBots = payload;

      return {
         ...state,
         mediBots
      };
   }
   case ActionTypes.UPDATE_SPONSOR_NASTY_SURPRISE_CARD: {
      const nastySurpriseCards = payload;

      return {
         ...state,
         nastySurpriseCards
      };
   }
   case ActionTypes.UPDATE_SPONSOR_SPECIAL_MOVE_CARD: {
      const specialMoveCards = payload;

      return {
         ...state,
         specialMoveCards
      };
   }
   case ActionTypes.UPDATE_SPONSOR_WAGER: {
      const wagers = payload;

      return {
         ...state,
         wagers
      };
   }
   default:
      return state;
   }
};

const dbxBuilderReducer = combineReducers({ sponsor });

export default dbxBuilderReducer;
