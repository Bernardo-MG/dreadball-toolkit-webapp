
export const nextPage = (fetch, current, last) => {
   let page = current;

   if (!last) {
      page += 1;
      fetch(page);
   }
};

export const previousPage = (fetch, current, first) => {
   let page = current;

   if (!first) {
      page -= 1;
      fetch(page);
   }
};
