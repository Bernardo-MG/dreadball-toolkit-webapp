
export const nextPage = (fetch, last) => {
   var page = current;
   
   if(!last){
      page++;
   }
   
   fetch(page);
}

export const previousPage = (fetch, first) => {
   var page = current;
   
   if(!first){
      page--;
   }
   
   fetch(page);
}