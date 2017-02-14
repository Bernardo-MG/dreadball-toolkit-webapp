import { createStore, applyMiddleware } from 'redux'
import thunk from 'redux-thunk'
import dreadballApp from '../reducers'

const configureStore = preloadedState => createStore(
  dreadballApp,
  preloadedState,
  applyMiddleware(thunk)
)

export default configureStore