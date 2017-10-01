import { combineReducers } from 'redux';
import { routerReducer as routing } from 'react-router-redux';
import builder from 'builder/reducers';
import orm from 'models/reducers';
import paginate from 'api/pagination/reducers';
import { REQUEST_UNITS, REQUEST_UNITS_SUCCESS, REQUEST_UNITS_FAILURE, REQUEST_SPONSOR_UNITS, REQUEST_SPONSOR_UNITS_SUCCESS, REQUEST_SPONSOR_UNITS_FAILURE } from 'requests/actions/ActionTypes';

const pagination = combineReducers({
   units: paginate({
      idsMapping: (payload) => Object.keys(payload.entities.units),
      types: [
         REQUEST_UNITS,
         REQUEST_UNITS_SUCCESS,
         REQUEST_UNITS_FAILURE
      ]
   }),
   ratedUnits: paginate({
      idsMapping: (payload) => Object.keys(payload.entities.units),
      types: [
         REQUEST_SPONSOR_UNITS,
         REQUEST_SPONSOR_UNITS_SUCCESS,
         REQUEST_SPONSOR_UNITS_FAILURE
      ]
   })
});

const dreadballApp = combineReducers({
   pagination,
   builder,
   routing,
   orm
});

export default dreadballApp;
