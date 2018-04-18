import * as ActionTypes from 'builder/actions/actionTypes';
import { combineReducers } from 'redux';
import assets from 'builder/assets/reducers';
import affinities from 'builder/affinities/reducers';
import sponsor from 'builder/sponsors/reducers';

const dbxBuilderReducer = combineReducers({ sponsor, assets, affinities, sponsor });

export default dbxBuilderReducer;
