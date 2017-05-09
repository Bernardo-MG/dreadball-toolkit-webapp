
export const nextPage = (fetch, current, last) => {
   var page = current;
   
   if(!last){
      page++;
   }
   
   fetch(page);
}

export const previousPage = (fetch, current, first) => {
   var page = current;
   
   if(!first){
      page--;
   }
   
   fetch(page);
}

export const filterPaginated = (model, idSelector, loader) => (session, pagination) => {
   var ids;
   var result;
   
   ids = getIds(pagination);   
   if(ids.length) {
      result = filterByIds(model, idSelector, loader, session, ids);
   } else {
      result = [];
   }
   
   return result;
};

const getIds = (pagination) => {
   var ids;
   
   if(pagination && pagination.ids) {
      if(pagination.page === undefined){
         ids = pagination.ids;
      } else {
         ids = getSlice(pagination);
      }
   } else {
      ids = [];
   }
   
   return ids;
}

const getSlice = (pagination) => {
   const start = pagination.page * pagination.elements;
   const end = start + pagination.elements;
   const ids = pagination.ids.slice(start, end);
   
   return ids;
}

const filterByIds = (model, idSelector, loader, session, ids) => {
   var entityLoader;
   var all;
   
   if(loader){
      entityLoader = loader;
   } else {
      entityLoader = (entity) => entity;
   }

   all = model(session).all().toModelArray();
   return all.filter(entity => ids.includes(idSelector(entity))).map(entity => {
      return entityLoader(entity);
   });
}
