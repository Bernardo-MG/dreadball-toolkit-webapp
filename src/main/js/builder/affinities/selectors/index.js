
export const selectChosenAffinities = (state) => state.builder.affinities.chosen;

export const selectAffinityOptions = (state) => state.builder.affinities.options;

export const selectAllAffinitiesChosen = (state) => selectChosenAffinities(state).length === selectAffinityOptions(state).length;
