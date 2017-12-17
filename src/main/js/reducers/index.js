import { combineReducers } from 'redux';
import { routerReducer as routing } from 'react-router-redux';
import builder from 'builder/reducers';
import model from 'models/reducers';
import paginate from 'api/pagination/reducers';

const pagination = combineReducers({
   units: paginate({
      idsMapping: (payload) => Object.keys(payload.entities.units),
      store: 'UNITS'
   }),
   ratedUnits: paginate({
      idsMapping: (payload) => Object.keys(payload.entities.units),
      store: 'TEAM_UNITS'
   })
});

const dreadballApp = combineReducers({
   pagination,
   builder,
   routing,
   model
});

export default dreadballApp;
