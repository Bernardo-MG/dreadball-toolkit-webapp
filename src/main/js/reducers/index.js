import { combineReducers } from 'redux'
import { routerReducer as routing } from 'react-router-redux'
import codex from './codex'

const dreadballApp = combineReducers({
  codex,
  routing
})

export default dreadballApp