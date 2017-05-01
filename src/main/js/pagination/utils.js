
export const nextPage = (fetch, current, max) => {
   var page = current;
   
   if(page < (max - 1)){
      page++;
   }
   
   fetch(page);
}

export const previousPage = (fetch, current) => {
   var page = current;
   
   if(page > 0){
      page--;
   }
   
   fetch(page);
}