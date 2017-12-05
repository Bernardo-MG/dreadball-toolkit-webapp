
export const fetch = () => {
   return {
      type: 'REQUEST_SPONSOR_UNITS'
   };
};

export const movePrevPage = () => {
   return {
      type: 'CHANGE_PAGE_PREV_SPONSOR_UNITS'
   };
};

export const moveNextPage = () => {
   return {
      type: 'CHANGE_PAGE_NEXT_SPONSOR_UNITS'
   };
};
