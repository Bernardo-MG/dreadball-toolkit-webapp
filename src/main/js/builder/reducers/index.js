import * as ActionTypes from 'builder/actions/ActionTypes';
import { combineReducers } from 'redux';

const sponsor = (state = { sponsorName: 'Sponsor name',
                           rank: 0, initialRank: 0, teamValue: 0,
                           affinities: [], units: [],
                           coachingDice: 0, specialMoveCard: 0, nastySurpriseCard: 0, wager: 0, mediBot: 0, cheerleaders: 0 }, action) => {
   const { type, payload } = action;
   const affinities = state.affinities.slice();
   const units = state.units.slice();
   let cost;
   let rank;
   switch (type) {
   case ActionTypes.BEGIN_DBX_TEAM_BUILDING:
      return {
         affinities: [],
         rank: 0,
         initialRank: 0,
         teamValue: 0,
         units: [],
         sponsorName: 'Sponsor name',
         coachingDice: 0,
         specialMoveCard: 0,
         nastySurpriseCard: 0,
         wager: 0,
         mediBot: 0,
         cheerleaders: 0
      }
   case ActionTypes.REQUEST_BUILDER_DEFAULTS_SUCCESS:
      const { cheerleaderCost, dieCost, medibotCost, moveCost, sabotageCost, wagerCost } = payload;
      const { cheerleaderRank, dieRank, medibotRank, moveRank, sabotageRank, wagerRank } = payload;
      const receivedRank = payload.initialRank;
      
      const costs = {
         cheerleader: cheerleaderCost,
         die: dieCost,
         medibot: medibotCost,
         move: moveCost,
         sabotage: sabotageCost,
         wager: wagerCost
      }
      
      const rankCosts = {
         cheerleader: cheerleaderRank,
         die: dieRank,
         medibot: medibotRank,
         move: moveRank,
         sabotage: sabotageRank,
         wager: wagerRank
      }
      
      return {
         ...state,
         initialRank: receivedRank,
         defaults: { cost: costs, rankCost: rankCosts }
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
   case ActionTypes.RELOAD_SPONSOR_TEAM_VALUE:
      const assetTeamValueCosts = state.defaults.cost;
      let teamValue;
      
      teamValue = 0;
   
      // Adds assets cost
      cost = state.cheerleaders * assetTeamValueCosts.cheerleader;
      teamValue = teamValue + cost;

      cost = state.coachingDice * assetTeamValueCosts.die;
      teamValue = teamValue + cost;

      cost = state.mediBot * assetTeamValueCosts.medibot;
      teamValue = teamValue + cost;

      cost = state.specialMoveCard * assetTeamValueCosts.move;
      teamValue = teamValue + cost;

      cost = state.nastySurpriseCard * assetTeamValueCosts.sabotage;
      teamValue = teamValue + cost;

      cost = state.wager * assetTeamValueCosts.wager;
      teamValue = teamValue + cost;
   
      return {
         ...state,
         teamValue
      };
   case ActionTypes.RELOAD_SPONSOR_RANK:
      const initialRank = state.initialRank;
      const assetRankCosts = state.defaults.rankCost;

      // Begins as the initial rank
      rank = initialRank;

      // Removes assets cost
      cost = state.cheerleaders * assetRankCosts.cheerleader;
      rank = rank - cost;

      cost = state.coachingDice * assetRankCosts.die;
      rank = rank - cost;

      cost = state.mediBot * assetRankCosts.medibot;
      rank = rank - cost;

      cost = state.specialMoveCard * assetRankCosts.move;
      rank = rank - cost;

      cost = state.nastySurpriseCard * assetRankCosts.sabotage;
      rank = rank - cost;

      cost = state.wager * assetRankCosts.wager;
      rank = rank - cost;

      return {
         ...state,
         rank
      };
   case ActionTypes.REQUEST_AFFINITIES_VALIDATION_SUCCESS:
      let affs = payload.affinities;

      rank = payload.rank;

      return {
         ...state,
         rank,
         affinities: affs
      };
   case ActionTypes.UPDATE_SPONSOR_CHEERLEADERS:
      const cheerleaders = payload;

      return {
         ...state,
         cheerleaders
      };
   case ActionTypes.UPDATE_SPONSOR_COACHING_DICE:
      const coachingDice = payload;

      return {
         ...state,
         coachingDice
      };
   case ActionTypes.UPDATE_SPONSOR_MEDIBOT:
      const mediBot = payload;

      return {
         ...state,
         mediBot
      };
   case ActionTypes.UPDATE_SPONSOR_NASTY_SURPRISE_CARD:
      const nastySurpriseCard = payload;

      return {
         ...state,
         nastySurpriseCard
      };
   case ActionTypes.UPDATE_SPONSOR_SPECIAL_MOVE_CARD:
      const specialMoveCard = payload;

      return {
         ...state,
         specialMoveCard
      };
   case ActionTypes.UPDATE_SPONSOR_WAGER:
      const wager = payload;

      return {
         ...state,
         wager
      };
   default:
      return state;
   }
};

const dbxBuilderReducer = combineReducers({
  sponsor
});

export default dbxBuilderReducer