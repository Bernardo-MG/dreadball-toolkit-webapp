
export const selectAssets = (state) => state.builder.assets;

export const selectCheerleaders = (state) => selectAssets(state).cheerleaders;

export const selectCoachingDice = (state) => selectAssets(state).coachingDice;

export const selectMediBots = (state) => selectAssets(state).mediBots;

export const selectNastySurpriseCards = (state) => selectAssets(state).nastySurpriseCards;

export const selectSpecialMoveCards = (state) => selectAssets(state).specialMoveCards;

export const selectWagers = (state) => selectAssets(state).wagers;
