
export const fetch = () => {
   return {
      type: 'REQUEST_UNITS'
   };
};
export const movePrevPage = () => {
   return {
      type: 'CHANGE_PAGE_PREV_UNITS'
   };
};

export const moveNextPage = () => {
   return {
      type: 'CHANGE_PAGE_NEXT_UNITS'
   };
};
