import { createStore, applyMiddleware, compose } from 'redux';
import createSagaMiddleware from 'redux-saga';
import { createLogger } from 'redux-logger';
import rootReducer from 'reducers';
import DevTools from 'components/DevTools';
import paginatedApi from 'api/middleware/pagination';
import movePage from 'api/middleware/move';
import rootSaga from 'sagas';

const sagaMiddleware = createSagaMiddleware();

const middleware = [
   sagaMiddleware,
   movePage,
   paginatedApi,
   // Redux logger is included
   createLogger()
];

const enhancer = compose(
   applyMiddleware(...middleware),
   // Dev tools are included
   DevTools.instrument()
);

const configureStore = (initialState) => createStore(
   rootReducer,
   initialState,
   enhancer
);

export default () => {
   const store = configureStore();

   sagaMiddleware.run(rootSaga);

   return store;
};
