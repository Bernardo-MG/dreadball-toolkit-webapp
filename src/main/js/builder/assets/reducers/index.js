import * as ActionTypes from 'builder/actions/actionTypes';

const assets = (
   state = { coachingDice: 0, specialMoveCards: 0, nastySurpriseCards: 0, wagers: 0, mediBots: 0, cheerleaders: 0 },
   action) => {
   const { type, payload } = action;
   switch (type) {
   case ActionTypes.CLEAR_TEAM:
      return {
         coachingDice: 0,
         specialMoveCards: 0,
         nastySurpriseCards: 0,
         wagers: 0,
         mediBots: 0,
         cheerleaders: 0
      };
   case ActionTypes.SET_CHEERLEADERS: {
      return {
         ...state,
         cheerleaders: payload
      };
   }
   case ActionTypes.SET_COACHING_DICE: {
      return {
         ...state,
         coachingDice: payload
      };
   }
   case ActionTypes.SET_MEDIBOT: {
      return {
         ...state,
         mediBots: payload
      };
   }
   case ActionTypes.SET_NASTY_SURPRISE_CARD: {
      return {
         ...state,
         nastySurpriseCards: payload
      };
   }
   case ActionTypes.SET_SPECIAL_MOVE_CARD: {
      return {
         ...state,
         specialMoveCards: payload
      };
   }
   case ActionTypes.SET_WAGER: {
      return {
         ...state,
         wagers: payload
      };
   }
   default:
      return state;
   }
};

export default assets;
