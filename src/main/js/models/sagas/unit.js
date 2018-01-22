import { put, takeLatest, call, select } from 'redux-saga/effects';
import * as types from 'models/actions/actionTypes';
import { fetcherUnit as fetcher } from 'models/requests/fetchers';
import { selectCurrentUnitPage as currentPageSelector, selectLastUnitPage as lastPageSelector } from 'models/selectors/page';
import { selectUnitIsFetching as fetchingSelector } from 'models/selectors/request';
import { requestSuccess } from 'models/actions/unit';

export function fetch(params) {
   return fetcher.fetch(params);
}

function* request(action, pageStep) {
   const fetching = yield select(fetchingSelector);
   const lastPage = yield select(lastPageSelector);
   if (!fetching && !lastPage) {
      yield put({ type: types.FETCHING_UNITS });
      const currentPage = yield select(currentPageSelector);
      const page = currentPage + pageStep;
      const response = yield call(fetch, { page, ...action.params });
      yield put(requestSuccess(response.payload, response.pagination));
   }
}

function* requestCurrent(action) {
   yield call(request, action, 0);
}

function* requestNext(action) {
   yield call(request, action, 1);
}

function* build(action) {
   yield put({ type: types.CREATE_ABILITIES, payload: action.payload.entities.abilities });
   yield put({ type: types.CREATE_AFFINITIES, payload: action.payload.entities.affinities });
   yield put({ type: types.CREATE_UNITS, payload: action.payload.entities.units });
}

export const unitSagas = [
   takeLatest(types.REQUEST_UNITS, requestCurrent),
   takeLatest(types.REQUEST_SUCCESS_UNITS, build),
   takeLatest(types.CHANGE_PAGE_NEXT_UNITS, requestNext)
];
