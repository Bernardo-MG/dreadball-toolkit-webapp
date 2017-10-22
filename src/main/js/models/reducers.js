import { CREATE_ABILITIES, CREATE_AFFINITIES, CREATE_UNITS, CREATE_RATED_UNITS, CREATE_SPONSOR_AFFINITY_GROUP_AVAILABILITIES } from 'models/actions/ActionTypes';

const model = (state = { sponsorAffinityAvailabilities: [], abilities: [], affinities: [], units: [], ratedUnits: [] }, action) => {
   const { type, payload } = action;

   switch (type) {
   case CREATE_SPONSOR_AFFINITY_GROUP_AVAILABILITIES: {
      const sponsorAffinityAvailabilities = payload.entities.sponsorAffinityAvailabilities;

      return {
         ...state,
         sponsorAffinityAvailabilities
      };
   }
   case CREATE_ABILITIES: {
      const abilities = payload.entities.abilities;

      return {
         ...state,
         abilities
      };
   }
   case CREATE_AFFINITIES: {
      const affinities = payload.entities.affinities;

      return {
         ...state,
         affinities
      };
   }
   case CREATE_UNITS: {
      const units = payload.entities.units;

      return {
         ...state,
         units
      };
   }
   case CREATE_RATED_UNITS: {
      const ratedUnits = payload.entities.units;

      return {
         ...state,
         ratedUnits
      };
   }
   default:
      return state;
   }
};

export default model;
