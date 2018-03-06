import { CREATE_ABILITIES, CREATE_AFFINITIES, CREATE_PLAYERS, CREATE_RATED_PLAYERS } from 'models/actions/actionTypes';

const model = (state = { abilities: {}, affinities: {}, players: {}, ratedPlayers: {} }, action) => {
   const { type, payload } = action;

   switch (type) {
   case CREATE_ABILITIES: {
      return {
         ...state,
         abilities: { ...state.abilities, ...payload }
      };
   }
   case CREATE_AFFINITIES: {
      return {
         ...state,
         affinities: { ...state.affinities, ...payload }
      };
   }
   case CREATE_PLAYERS: {
      return {
         ...state,
         players: { ...state.players, ...payload }
      };
   }
   case CREATE_RATED_PLAYERS: {
      return {
         ...state,
         ratedPlayers: { ...state.ratedPlayers, ...payload }
      };
   }
   default:
      return state;
   }
};

export default model;
