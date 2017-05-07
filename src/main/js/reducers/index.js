import { combineReducers } from 'redux'
import { routerReducer as routing } from 'react-router-redux'
import { createReducer } from 'redux-orm';
import dbxBuilder from 'reducers/dbxBuilder'
import orm from 'models';
import { paginate } from 'pagination/reducers'
import { REQUEST_UNITS, REQUEST_UNITS_SUCCESS, REQUEST_UNITS_FAILURE } from 'requests/actions/ActionTypes'
import { dictionaryIds } from 'utils'

const pagination = combineReducers({
   units: paginate({
      idsMapping: payload => dictionaryIds(payload.entities.units),
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