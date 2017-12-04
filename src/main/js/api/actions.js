import { CALL_API } from 'api/ActionTypes';

export const callApi = (data = {}) => {
   return {
      [CALL_API]: {
         ...data
      }
   };
};
