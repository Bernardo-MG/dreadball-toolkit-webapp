import { createStore, applyMiddleware } from 'redux'
import thunk from 'redux-thunk'
import rootReducer from 'reducers'
import api from 'pagination/middleware/api'

const middleware = [
   thunk,
   api
]

const enhancer = applyMiddleware(...middleware);

const configureStore = initialState => createStore(
   rootReducer,
   initialState,
   enhancer
)

export default configureStore