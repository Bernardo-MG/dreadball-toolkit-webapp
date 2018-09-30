import paginate from 'api/pagination/reducers';

/**
 * Returns the ids from a request response.
 *
 * @param payload the response payload
 */
const getPlayerIds = (payload) => {
   let result;

   if ((payload) && (payload.entities) && (payload.entities.players)) {
      // The ids are the map keys
      result = Object.keys(payload.entities.players);
   } else {
      // The payload is missing the required data
      result = [];
   }

   return result;
};

/**
 * Players pagination reducer.
 */
export const players = paginate({
   idsMapping: (payload) => getPlayerIds(payload),
   store: 'PLAYERS'
});

/**
 * Rated players pagination reducer.
 */
export const ratedPlayers = paginate({
   idsMapping: (payload) => getPlayerIds(payload),
   store: 'RATED_PLAYERS'
});
