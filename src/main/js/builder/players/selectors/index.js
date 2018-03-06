import { createSelector } from 'reselect';
import { filterByKeys } from 'models/selectors/utils';

export const selectPlayers = (state) => state.builder.sponsor.players;

export const selectSponsorRatedPlayers = createSelector(
   (state) => state.model.ratedPlayers,
   (state) => state.builder.sponsor.players,
   (data, ids) => filterByKeys(data, ids)
);
