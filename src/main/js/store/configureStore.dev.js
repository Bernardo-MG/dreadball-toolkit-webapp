import { createStore, applyMiddleware, compose } from 'redux';
import createSagaMiddleware, { END } from 'redux-saga';
import { createLogger } from 'redux-logger';
import rootReducer from 'reducers';
import DevTools from 'components/DevTools';
import paginatedApi from 'api/middleware/pagination';
import movePage from 'api/middleware/move';

export default function configureStore(initialState) {
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

   const store = createStore(
      rootReducer,
      initialState,
      enhancer
   );

   store.runSaga = sagaMiddleware.run;
   store.close = () => store.dispatch(END);
   return store;
}
