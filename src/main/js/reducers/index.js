import { combineReducers } from 'redux'
import { routerReducer as routing } from 'react-router-redux'
import codex from './codex'
import dbxBuilder from './dbxBuilder'

const dreadballApp = combineReducers({
   codex,
   dbxBuilder,
   routing
})

export default dreadballApp