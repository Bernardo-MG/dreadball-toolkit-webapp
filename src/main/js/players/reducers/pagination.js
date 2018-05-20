import paginate from 'api/pagination/reducers';

const getPlayerIds = (payload) => {
   let result;

   if ((payload) && (payload.entities) && (payload.entities.players)) {
      result = Object.keys(payload.entities.players);
   } else {
      result = [];
   }

   return result;
};

export const players = paginate({
   idsMapping: (payload) => getPlayerIds(payload),
   store: 'PLAYERS'
});

export const ratedPlayers = paginate({
   idsMapping: (payload) => getPlayerIds(payload),
   store: 'TEAM_PLAYERS'
});
