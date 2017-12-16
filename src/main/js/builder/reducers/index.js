import * as ActionTypes from 'builder/actions/ActionTypes';
import { combineReducers } from 'redux';

const sponsor = (
   state = { sponsorName: 'Sponsor name', rank: 0, baseRank: 0, teamValue: 0, affinities: [], units: [], coachingDice: 0, specialMoveCards: 0, nastySurpriseCards: 0, wagers: 0, mediBots: 0, cheerleaders: 0 },
   action) => {
   const { type, payload } = action;
   const affinities = state.affinities.slice();
   switch (type) {
   case ActionTypes.CLEAR_TEAM:
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
   case ActionTypes.ADD_TEAM_UNIT:
      return {
         ...state,
         units: [...state.units, payload]
      };
   case ActionTypes.REMOVE_TEAM_UNIT:
      return {
         ...state,
         units: state.units.filter((unit) => unit !== payload)
      };
   case ActionTypes.SET_BASE_RANK:
      return {
         ...state,
         baseRank: payload
      };
   case ActionTypes.SET_RANK:
      return {
         ...state,
         rank: payload
      };
   case ActionTypes.SET_TEAM_VALUE:
      return {
         ...state,
         teamValue: payload
      };
   case ActionTypes.SET_SPONSOR_NAME: {
      return {
         ...state,
         sponsorName: payload
      };
   }
   case ActionTypes.SET_SPONSOR_CHEERLEADERS: {
      return {
         ...state,
         cheerleaders: payload
      };
   }
   case ActionTypes.SET_SPONSOR_COACHING_DICE: {
      return {
         ...state,
         coachingDice: payload
      };
   }
   case ActionTypes.SET_SPONSOR_MEDIBOT: {
      return {
         ...state,
         mediBots: payload
      };
   }
   case ActionTypes.SET_SPONSOR_NASTY_SURPRISE_CARD: {
      return {
         ...state,
         nastySurpriseCards: payload
      };
   }
   case ActionTypes.SET_SPONSOR_SPECIAL_MOVE_CARD: {
      return {
         ...state,
         specialMoveCards: payload
      };
   }
   case ActionTypes.SET_SPONSOR_WAGER: {
      return {
         ...state,
         wagers: payload
      };
   }
   default:
      return state;
   }
};

const dbxBuilderReducer = combineReducers({ sponsor });

export default dbxBuilderReducer;
