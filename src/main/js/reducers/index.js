import { combineReducers } from 'redux'
import { routerReducer as routing } from 'react-router-redux'
import entities from 'reducers/entities'
import dbxBuilder from 'reducers/dbxBuilder'
import schema from 'models/schema';

const dreadballApp = combineReducers({
   entities,
   dbxBuilder,
   routing,
   orm : schema.reducer()
})

export default dreadballApp