import { createStore, applyMiddleware, compose } from 'redux'
import thunk from 'redux-thunk'
import createLogger from 'redux-logger'
import rootReducer from '../reducers'
import DevTools from '../containers/DevTools';

const middleware = [
   thunk,
   createLogger()
]

const enhancer = compose(
   applyMiddleware(...middleware),
   // Dev tools are included
   DevTools.instrument()
);

const configureStore = initialState => {
   const store = createStore(
      rootReducer,
      initialState,
      enhancer
   )
   
   if (module.hot) {
      // Enable Webpack hot module replacement for reducers
      module.hot.accept('../reducers', () => {
         const nextRootReducer = require('../reducers').default
         store.replaceReducer(nextRootReducer)
      })
   }
  
  return store
}

export default configureStore