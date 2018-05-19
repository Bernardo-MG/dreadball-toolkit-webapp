import { combineReducers } from 'redux';
import { routerReducer as routing } from 'react-router-redux';
import builder from 'builder/reducers';
import model from 'players/reducers';
import views from 'views/reducers';
import { players, ratedPlayers } from 'players/reducers/pagination';

const pagination = combineReducers({
   players,
   ratedPlayers
});

const dreadballApp = combineReducers({
   pagination,
   builder,
   routing,
   model,
   views
});

export default dreadballApp;
