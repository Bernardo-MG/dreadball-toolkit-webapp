import * as ActionTypes from 'builder/affinities/actions/actionTypes';

const affinities = (
   state = { options: [], chosen: [] }, action) => {
   const { type, payload } = action;
   const affs = state.chosen.slice();

   if (payload === undefined) {
      return { ...state };
   }

   switch (type) {
   case ActionTypes.CLEAR_TEAM:
      return {
         options: [],
         chosen: []
      };
   case ActionTypes.SET_AFFINITY_OPTIONS: {
      return {
         ...state,
         options: payload
      };
   }
   case ActionTypes.SET_CHOSEN_AFFINITIES: {
      return {
         ...state,
         chosen: payload
      };
   }
   case ActionTypes.CHOOSE_SPONSOR_AFFINITY:
      affs[action.index] = payload;

      return {
         ...state,
         chosen: affs
      };
   default:
      return state;
   }
};

export default affinities;
