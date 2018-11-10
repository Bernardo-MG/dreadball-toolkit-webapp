import * as ActionTypes from 'builder/actions/actionTypes';

const affinities = (
   state = { options: [], chosen: [] }, action) => {
   const { type } = action;
   const affs = state.chosen.slice();
   let { payload } = action;

   if (payload === undefined) {
      payload = [];
   }

   switch (type) {
   case ActionTypes.CLEAR_TEAM:
      return {
         ...state,
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
