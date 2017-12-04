import { CREATE_ABILITIES, CREATE_AFFINITIES, CREATE_UNITS } from 'models/actions/ActionTypes';
import { AFFINITY_UNITS_REST_ENDPOINT as endpoint } from 'models/Endpoints';
import { normalize } from 'normalizr';
import { unit } from 'models/schema';
import { fetchPaginated } from 'api/fetch';
import { callApi, previousPage, nextPage } from 'api/actions';

const parse = (json) => normalize(json, [unit]);

const tag = 'UNITS';

export const fetch = (affinity, index) => {
   return {
      type: 'REQUEST_UNITS'
   };
};

export const movePrevPage = () => previousPage({
   tag,
   storeSelector: (state) => state.pagination.units,
   fetch
});

export const moveNextPage = () => nextPage({
   tag,
   storeSelector: (state) => state.pagination.units,
   fetch
});
