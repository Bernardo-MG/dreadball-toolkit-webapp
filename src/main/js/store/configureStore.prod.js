import { createStore, applyMiddleware } from 'redux'
import thunk from 'redux-thunk'
import rootReducer from 'reducers'

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