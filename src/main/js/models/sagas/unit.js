import { put, takeLatest, call } from 'redux-saga/effects';
import { AFFINITY_UNITS_REST_ENDPOINT as endpoint } from 'models/Endpoints';
import { CREATE_ABILITIES, CREATE_AFFINITIES, CREATE_UNITS } from 'models/actions/ActionTypes';
import { normalize } from 'normalizr';
import { fetchPaginated } from 'api/fetch';
import { unit } from 'models/schema';

const parse = (json) => normalize(json, [unit]);

const appendBase = (url) => {
   let result;

   if (url.indexOf(ROUTE_BASE) === -1) {
      result = ROUTE_BASE + url;
   } else {
      result = url;
   }

   return result;
};

export function fetchUnits() {
   return fetchPaginated(appendBase(endpoint), {}, parse).then(
      (response) => response,
      (error) => error.message || 'Request failed'
   );
}

function* requestUnits() {
   const units = yield call(fetchUnits);
   yield put({ type: 'REQUEST_SUCCESS_UNITS', ...units });
   yield put({ type: CREATE_ABILITIES, ...units });
   yield put({ type: CREATE_AFFINITIES, ...units });
   yield put({ type: CREATE_UNITS, ...units });
}

export function* generateUnitSaga() {
   yield takeLatest('REQUEST_UNITS', requestUnits);
}
