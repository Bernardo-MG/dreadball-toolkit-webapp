import { combineReducers } from 'redux';
import { routerReducer as routing } from 'react-router-redux';
import builder from 'builder/reducers';
import model from 'models/reducers';
import paginate from 'api/pagination/reducers';
import { REQUEST_UNITS, REQUEST_UNITS_SUCCESS, REQUEST_UNITS_FAILURE, REQUEST_SPONSOR_UNITS, REQUEST_SPONSOR_UNITS_SUCCESS, REQUEST_SPONSOR_UNITS_FAILURE } from 'models/actions/ActionTypes';

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
   model
});

export default dreadballApp;
