
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

export const filterById = (idSelector, loader, modelSelector, idProcessor) => (session, payload) => {
   let result;

   const ids = idProcessor(payload);
   if (ids.length) {
      const all = modelSelector(session).all().toModelArray();
      result = all
         .filter((entity) => ids.includes(idSelector(entity)))
         .map((entity) => loader(entity));
   } else {
      result = [];
   }

   return result;
};

export const filterByIdPaginated = (idSelector, loader, modelSelector) => filterById(idSelector, loader, modelSelector, getIdsPaginated);

export const filterAll = (idSelector, loader, modelSelector) => (session) => modelSelector(session).all().toModelArray().map((entity) => loader(entity));
