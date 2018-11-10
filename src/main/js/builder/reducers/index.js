import { combineReducers } from 'redux';
import assets from 'builder/reducers/assets';
import affinities from 'builder/reducers/affinities';
import sponsor from 'builder/reducers/sponsors';

const dbxBuilderReducer = combineReducers({ sponsor, assets, affinities });

export default dbxBuilderReducer;
