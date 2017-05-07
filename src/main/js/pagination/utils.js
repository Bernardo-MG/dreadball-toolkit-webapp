
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

export const filterPaginated = (loader, model) => (session, pagination) => {
   var result = model(session).all().toModelArray();
   const start = pagination.page * pagination.elements;
   const end = start + pagination.elements;
   const ids = pagination.ids.slice(start, end);
   
   result = result.filter(entity => ids.includes(entity.templateName)).map(entity => {
      return loader(entity);
   });
   
   return result;
};