import * as ActionTypes from 'builder/actions/ActionTypes';
import { combineReducers } from 'redux';

const sponsor = (state = { rank: 0, affinities: [], ranks: [] }, action) => {
   const { type } = action;
   const ranks = state.ranks.slice();
   const affinities = state.affinities.slice();
   switch (type) {
   case ActionTypes.BEGIN_DBX_TEAM_BUILDING:
      return {
         affinities: [],
         ranks: [],
         rank: 0
      }
   case ActionTypes.CHOOSE_SPONSOR_AFFINITY:
      affinities[action.index] = action.payload.affinity;
      ranks[action.index] = action.payload.rank;
      
      return {
         ...state,
         affinities,
         ranks
      };
   case ActionTypes.UPDATE_SPONSOR_AFFINITY_RANK:
      const len = ranks.length;
      var rank;
      
      rank = 0;
      for (var i = 0; i < len; i++) {
         if(ranks[i]) {
            rank++;
         }
      }
      
      return {
         ...state,
         rank
      };
   default:
      return state;
   }
};

const defaults = (state = { initialRank: 0 }, action) => {
   const { type } = action;
   switch (type) {
   case ActionTypes.REQUEST_BUILDER_DEFAULTS_SUCCESS:
      const initialRank = action.payload.initialRank;
      
      return {
         ...state,
         initialRank
      };
   default:
      return state;
   }
};

const dbxBuilderReducer = combineReducers({
  sponsor,
  defaults
});

export default dbxBuilderReducer