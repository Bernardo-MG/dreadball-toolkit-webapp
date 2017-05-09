import { combineReducers } from 'redux'
import { routerReducer as routing } from 'react-router-redux'
import { createReducer } from 'redux-orm';
import builder from 'builder/reducers'
import orm from 'models';
import { paginate } from 'pagination/reducers'
import { REQUEST_UNITS, REQUEST_UNITS_SUCCESS, REQUEST_UNITS_FAILURE } from 'requests/actions/ActionTypes'
import { REQUEST_SPONSOR_AFFINITY_GROUP_AVAILABILITIES, REQUEST_SPONSOR_AFFINITY_GROUP_AVAILABILITIES_SUCCESS, REQUEST_SPONSOR_AFFINITY_GROUP_AVAILABILITIES_FAILURE } from 'requests/actions/ActionTypes'
import { dictionaryIds } from 'utils'

const pagination = combineReducers({
   units: paginate({
      idsMapping: payload => dictionaryIds(payload.entities.units),
      types: [
         REQUEST_UNITS,
         REQUEST_UNITS_SUCCESS,
         REQUEST_UNITS_FAILURE
      ]
   }),
   sponsorAffAvas: paginate({
      idsMapping: payload => dictionaryIds(payload.entities.sponsorAffinityAvailabilities),
      types: [
         REQUEST_SPONSOR_AFFINITY_GROUP_AVAILABILITIES,
         REQUEST_SPONSOR_AFFINITY_GROUP_AVAILABILITIES_SUCCESS,
         REQUEST_SPONSOR_AFFINITY_GROUP_AVAILABILITIES_FAILURE
      ]
   })
})

const dreadballApp = combineReducers({
   pagination,
   builder,
   routing,
   orm : createReducer(orm)
})

export default dreadballApp