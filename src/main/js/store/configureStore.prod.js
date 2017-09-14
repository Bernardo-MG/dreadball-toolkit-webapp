import { createStore, applyMiddleware } from 'redux';
import thunk from 'redux-thunk';
import rootReducer from 'reducers';
import paginatedApi from 'middleware/pagination';
import statusApi from 'middleware/statusFetch';

const middleware = [
   thunk,
   paginatedApi,
   statusApi
];

const enhancer = applyMiddleware(...middleware);

const configureStore = (initialState) => createStore(
   rootReducer,
   initialState,
   enhancer
);

export default configureStore;
