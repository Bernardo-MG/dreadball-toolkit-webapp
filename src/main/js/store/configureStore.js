import { createStore, applyMiddleware } from 'redux'
import thunk from 'redux-thunk'
import createLogger from 'redux-logger'
import dreadballApp from '../reducers'

const middleware = [ thunk, createLogger() ]

const configureStore = preloadedState => createStore(
   dreadballApp,
   preloadedState,
   applyMiddleware(...middleware)
)

export default configureStore