import { createStore, applyMiddleware, compose } from 'redux'
import thunk from 'redux-thunk'
import createLogger from 'redux-logger'
import dreadballApp from '../reducers'
import DevTools from '../containers/DevTools';

const middleware = [
   thunk, 
   createLogger()
]

const configureStore = initialState => createStore(
   dreadballApp,
   initialState,
   compose(
      applyMiddleware(...middleware), 
      DevTools.instrument()
   )
)

export default configureStore