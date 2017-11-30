import { createStore, applyMiddleware } from 'redux';
import createSagaMiddleware from 'redux-saga';
import rootReducer from 'reducers';
import paginatedApi from 'middleware/pagination';
import statusApi from 'middleware/statusFetch';
import rootSaga from 'sagas';

const sagaMiddleware = createSagaMiddleware();

const middleware = [
   sagaMiddleware,
   paginatedApi,
   statusApi
];

const enhancer = applyMiddleware(...middleware);

const configureStore = (initialState) => createStore(
   rootReducer,
   initialState,
   enhancer
);

sagaMiddleware.run(generateUnitSaga);

export default () => {
   const store = configureStore();

   sagaMiddleware.run(rootSaga);

   return store;
};
