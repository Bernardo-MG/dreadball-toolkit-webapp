import * as types from 'builder/assets/actions/actionTypes';

export const setCoachingDice = (value) => {
   return {
      type: types.SET_COACHING_DICE,
      payload: value
   };
};

export const setSpecialMoveCard = (value) => {
   return {
      type: types.SET_SPECIAL_MOVE_CARD,
      payload: value
   };
};

export const setNastySurpriseCard = (value) => {
   return {
      type: types.SET_NASTY_SURPRISE_CARD,
      payload: value
   };
};

export const setWager = (value) => {
   return {
      type: types.SET_WAGER,
      payload: value
   };
};

export const setMediBot = (value) => {
   return {
      type: types.SET_MEDIBOT,
      payload: value
   };
};

export const setCheerleaders = (value) => {
   return {
      type: types.SET_CHEERLEADERS,
      payload: value
   };
};
