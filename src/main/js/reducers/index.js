import { combineReducers } from 'redux'
import { routerReducer as routing } from 'react-router-redux'
import { createReducer } from 'redux-orm';
import entities from 'reducers/entities'
import dbxBuilder from 'reducers/dbxBuilder'
import orm from 'models';
import paginate from 'reducers/pagination'
import * as ActionTypes  from 'constants/ActionTypes'

const pagination = combineReducers({
   units: paginate({
      mapActionToKey: action => 'units',
      types: [
         ActionTypes.REQUEST_UNITS,
         ActionTypes.REQUEST_UNITS_SUCCESS,
         ActionTypes.REQUEST_UNITS_FAILURE
      ]
   })
})

const dreadballApp = combineReducers({
   entities,
   pagination,
   dbxBuilder,
   routing,
   orm : createReducer(orm)
})

export default dreadballApp