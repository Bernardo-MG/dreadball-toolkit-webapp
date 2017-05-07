
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
   var entityLoader;
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
   
   if(loader){
      entityLoader = loader;
   } else {
      entityLoader = (entity) => entity;
   }
   
   if(ids.length > 0) {
      var result = model(session).all().toModelArray();
      result = result.filter(entity => ids.includes(idSelector(entity))).map(entity => {
         return entityLoader(entity);
      });
   } else {
      result = [];
   }
   
   return result;
};

const getSlice = (pagination) => {
   const start = pagination.page * pagination.elements;
   const end = start + pagination.elements;
   const ids = pagination.ids.slice(start, end);
   
   return ids;
}