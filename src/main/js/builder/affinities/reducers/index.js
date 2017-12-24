import * as ActionTypes from 'builder/affinities/actions/actionTypes';

const affinities = (
   state = { options: [] }, action) => {
   const { type, payload } = action;
   switch (type) {
   case ActionTypes.CLEAR_TEAM:
      return {
         options: []
      };
   case ActionTypes.SET_AFFINITY_OPTIONS: {
      return {
         ...state,
         options: payload
      };
   }
   default:
      return state;
   }
};

export default affinities;
