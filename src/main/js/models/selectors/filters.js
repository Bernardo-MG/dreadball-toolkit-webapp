
const getSlice = (pagination) => {
   const start = pagination.page * pagination.pageSize;
   const end = start + pagination.numberOfElements;
   const ids = pagination.ids.slice(start, end);

   return ids;
};

const getIdsPaginated = (payload) => {
   let ids;

   if (payload === undefined) {
      ids = [];
   } else if (payload.ids) {
      if (payload.page === undefined) {
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

const filterByIds = (modelSelector, idSelector, loader, session, ids) => {
   let entityLoader;

   if (loader) {
      entityLoader = loader;
   } else {
      entityLoader = (entity) => entity;
   }

   const all = modelSelector(session).all().toModelArray();
   return all
      .filter((entity) => ids.includes(idSelector(entity)))
      .map((entity) => entityLoader(entity));
};

export const filterById = (idSelector, loader, modelSelector, idProcessor) => (session, payload) => {
   let result;
   let processor;

   if (idProcessor) {
      processor = idProcessor;
   } else {
      processor = getIdsPaginated;
   }

   const ids = processor(payload);
   if (ids.length) {
      result = filterByIds(modelSelector, idSelector, loader, session, ids);
   } else {
      result = [];
   }

   return result;
};
