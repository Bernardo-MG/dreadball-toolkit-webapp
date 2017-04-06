import { createStore, applyMiddleware, compose } from 'redux'
import thunk from 'redux-thunk'
import createLogger from 'redux-logger'
import dreadballApp from '../reducers'
import DevTools from '../containers/DevTools';

const middleware = [
   thunk, 
   createLogger()
]

const buildStoreMiddleware = (production) => {
   var enhancer;
   
   if (production) {
      enhancer = applyMiddleware(...middleware);
   } else {
      enhancer = compose(
         applyMiddleware(...middleware),
         // Dev tools are included
         DevTools.instrument()
      );
   }
   
   return enhancer;
}

const enhancer = buildStoreMiddleware(process.env.NODE_ENV === 'production');

const configureStore = initialState => createStore(
   dreadballApp,
   initialState,
   enhancer
)

export default configureStore