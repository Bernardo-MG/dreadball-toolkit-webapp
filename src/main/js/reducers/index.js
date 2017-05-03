import { combineReducers } from 'redux'
import { routerReducer as routing } from 'react-router-redux'
import { createReducer } from 'redux-orm';
import dbxBuilder from 'reducers/dbxBuilder'
import orm from 'models';
import paginate from 'pagination/reducers/pagination'
import { REQUEST_UNITS, REQUEST_UNITS_SUCCESS, REQUEST_UNITS_FAILURE } from 'requests/actions/ActionTypes'

const pagination = combineReducers({
   units: paginate({
      idsMapping: entities => entities.map(unit => unit.templateName),
      types: [
         REQUEST_UNITS,
         REQUEST_UNITS_SUCCESS,
         REQUEST_UNITS_FAILURE
      ]
   })
})

const dreadballApp = combineReducers({
   pagination,
   dbxBuilder,
   routing,
   orm : createReducer(orm)
})

export default dreadballApp