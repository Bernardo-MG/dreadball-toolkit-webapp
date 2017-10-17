import { CHANGE_PAGE } from 'api/ActionTypes';

const middleware = (state, next, action) => {
   const { type } = action;

   if (type !== CHANGE_PAGE) {
      return next(action);
   }

   const { fetch, direction, store, storeSelector } = action;
   const changePageType = `${CHANGE_PAGE}_${direction}_${store}`;

   const changeAction = {
      type: changePageType
   };

   // Processing page change action
   next(changeAction);

   const stateStore = storeSelector(state.getState());
   const page = stateStore.page;

   return next(fetch(page));
};

export default (state) => (next) => (action) => {
   middleware(state, next, action);
};
