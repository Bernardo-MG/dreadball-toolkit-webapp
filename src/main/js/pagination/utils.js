
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