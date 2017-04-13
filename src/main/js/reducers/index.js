import { combineReducers } from 'redux'
import { routerReducer as routing } from 'react-router-redux'
import { createReducer } from 'redux-orm';
import entities from 'reducers/entities'
import dbxBuilder from 'reducers/dbxBuilder'
import orm from 'models';

const dreadballApp = combineReducers({
   entities,
   dbxBuilder,
   routing,
   orm : createReducer(orm)
})

export default dreadballApp