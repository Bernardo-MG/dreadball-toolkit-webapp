import { combineReducers } from 'redux';
import { routerReducer as routing } from 'react-router-redux';
import builder from 'builder/reducers';
import model from 'players/reducers';
import paginate from 'api/pagination/reducers';
import views from 'views/reducers';

const getPlayerIds = (payload) => {
   let result;

   if ((payload) && (payload.entities) && (payload.entities.players)) {
      result = Object.keys(payload.entities.players);
   } else {
      result = [];
   }

   return result;
};

const pagination = combineReducers({
   players: paginate({
      idsMapping: (payload) => getPlayerIds(payload),
      store: 'PLAYERS'
   }),
   ratedPlayers: paginate({
      idsMapping: (payload) => getPlayerIds(payload),
      store: 'TEAM_PLAYERS'
   })
});

const dreadballApp = combineReducers({
   pagination,
   builder,
   routing,
   model,
   views
});

export default dreadballApp;
