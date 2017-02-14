import { combineReducers } from 'redux'
import { routerReducer as routing } from 'react-router-redux'
import players from './codex'

const dreadballApp = combineReducers({
  players,
  routing
})

export default dreadballApp