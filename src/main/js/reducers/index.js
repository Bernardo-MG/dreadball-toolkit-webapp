import { combineReducers } from 'redux'
import { routerReducer as routing } from 'react-router-redux'
import entities from './entities'
import dbxBuilder from './dbxBuilder'

const dreadballApp = combineReducers({
   entities,
   dbxBuilder,
   routing
})

export default dreadballApp