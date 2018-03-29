import { combineReducers } from 'redux';
import { routerReducer as routing } from 'react-router-redux';
import builder from 'builder/reducers';
import model from 'models/reducers';
import paginate from 'api/pagination/reducers';
import views from 'views/reducers';

const pagination = combineReducers({
   players: paginate({
      idsMapping: (payload) => Object.keys(payload.entities.players),
      store: 'PLAYERS'
   }),
   ratedPlayers: paginate({
      idsMapping: (payload) => Object.keys(payload.entities.players),
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
