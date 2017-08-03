
export const filterById = (idSelector, loader, modelSelector, idProcessor) => (session, payload) => {
   let ids;
   let result;
   let processor;
   
   if(idProcessor) {
      processor = idProcessor;
   } else {
      processor = getIdsPaginated;
   }

   ids = processor(payload);   
   if (ids.length) {
      result = filterByIds(modelSelector, idSelector, loader, session, ids);
   } else {
      result = [];
   }

   return result;
};

const getIdsPaginated = (payload) => {
   let ids;

   if (payload === undefined) {
      ids = [];
   } else if (payload.ids) {
      if (payload.page === undefined){
         // The payload isn't paginated
         ids = payload.ids;
      } else {
         ids = getSlice(payload);
      }
   } else {
      ids = payload;
   }

   return ids;
};

const getSlice = (pagination) => {
   const start = pagination.page * pagination.numberOfElements;
   const end = start + pagination.numberOfElements;
   const ids = pagination.ids.slice(start, end);

   return ids;
};

const filterByIds = (modelSelector, idSelector, loader, session, ids) => {
   let entityLoader;
   let all;

   if (loader){
      entityLoader = loader;
   } else {
      entityLoader = (entity) => entity;
   }

   all = modelSelector(session).all().toModelArray();
   return all.filter(entity => ids.includes(idSelector(entity))).map(entity => {
      return entityLoader(entity);
   });
};
