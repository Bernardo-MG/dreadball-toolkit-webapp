
export const assetsSelector = (state) => state.builder.assets;

export const cheerleadersSelector = (state) => assetsSelector(state).cheerleaders;

export const coachingDiceSelector = (state) => assetsSelector(state).coachingDice;

export const mediBotsSelector = (state) => assetsSelector(state).mediBots;

export const nastySurpriseCardsSelector = (state) => assetsSelector(state).nastySurpriseCards;

export const specialMoveCardsSelector = (state) => assetsSelector(state).specialMoveCards;

export const wagersSelector = (state) => assetsSelector(state).wagers;
