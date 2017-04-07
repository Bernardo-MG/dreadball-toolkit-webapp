import { createStore, applyMiddleware, compose } from 'redux'
import thunk from 'redux-thunk'
import rootReducer from '../reducers'
import DevTools from '../containers/DevTools';

const middleware = [
   thunk
]

const enhancer = applyMiddleware(...middleware);

const configureStore = initialState => createStore(
   rootReducer,
   initialState,
   enhancer
)

export default configureStore