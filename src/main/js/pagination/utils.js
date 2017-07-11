
export const filterById = (model, idSelector, loader) => (session, payload) => {
   let ids;
   let result;

   ids = getIds(payload);   
   if (ids.length) {
      result = filterByIds(model, idSelector, loader, session, ids);
   } else {
      result = [];
   }

   return result;
};

const getIds = (payload) => {
   let ids;

   if (payload && payload.ids) {
      if (payload.page === undefined){
         ids = payload.ids;
      } else {
         ids = getSlice(payload);
      }
   } else {
      ids = [];
   }

   return ids;
};

const getSlice = (pagination) => {
   const start = pagination.page * pagination.numberOfElements;
   const end = start + pagination.numberOfElements;
   const ids = pagination.ids.slice(start, end);

   return ids;
};

const filterByIds = (model, idSelector, loader, session, ids) => {
   let entityLoader;
   let all;

   if (loader){
      entityLoader = loader;
   } else {
      entityLoader = (entity) => entity;
   }

   all = model(session).all().toModelArray();
   return all.filter(entity => ids.includes(idSelector(entity))).map(entity => {
      return entityLoader(entity);
   });
};
