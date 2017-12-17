import { CREATE_ABILITIES, CREATE_AFFINITIES, CREATE_UNITS, CREATE_RATED_UNITS, CREATE_SPONSOR_AFFINITY_GROUP_AVAILABILITIES } from 'models/actions/ActionTypes';

const model = (state = { sponsorAffinityAvailabilities: [], abilities: [], affinities: [], units: [], ratedUnits: [] }, action) => {
   const { type, payload } = action;

   switch (type) {
   case CREATE_SPONSOR_AFFINITY_GROUP_AVAILABILITIES: {
      return {
         ...state,
         sponsorAffinityAvailabilities: payload
      };
   }
   case CREATE_ABILITIES: {
      return {
         ...state,
         abilities: payload
      };
   }
   case CREATE_AFFINITIES: {
      return {
         ...state,
         affinities: payload
      };
   }
   case CREATE_UNITS: {
      return {
         ...state,
         units: payload
      };
   }
   case CREATE_RATED_UNITS: {
      return {
         ...state,
         ratedUnits: payload
      };
   }
   default:
      return state;
   }
};

export default model;
