import { combineReducers } from 'redux'
import { routerReducer as routing } from 'react-router-redux'
import entities from './entities'
import dbxBuilder from './dbxBuilder'
import schema from '../models/schema';

const dreadballApp = combineReducers({
   entities,
   dbxBuilder,
   routing,
   orm : schema.reducer()
})

export default dreadballApp