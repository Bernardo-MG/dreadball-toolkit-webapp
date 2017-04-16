import { createStore, applyMiddleware, compose } from 'redux'
import thunk from 'redux-thunk'
import createLogger from 'redux-logger'
import rootReducer from 'reducers'
import DevTools from 'containers/DevTools';
import api from 'middleware/api'

const middleware = [
   thunk,
   api,
   createLogger()
]

const enhancer = compose(
   applyMiddleware(...middleware),
   // Dev tools are included
   DevTools.instrument()
);

const configureStore = initialState => createStore(
   rootReducer,
   initialState,
   enhancer
)

export default configureStore