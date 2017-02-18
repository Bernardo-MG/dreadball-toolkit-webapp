import { combineReducers } from 'redux'
import { routerReducer as routing } from 'react-router-redux'
import units from './codex'

const dreadballApp = combineReducers({
  units,
  routing
})

export default dreadballApp