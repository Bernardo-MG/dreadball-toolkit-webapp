import { put, takeLatest, call, select } from 'redux-saga/effects';
import * as types from 'models/actions/actionTypes';
import { fetcherPlayer as fetcher } from 'models/requests/fetchers';
import { selectCanLoadPlayer as canLoadSelector } from 'models/selectors/request';
import { selectCurrentPlayerPage as currentPageSelector } from 'models/selectors/page';
import { requestSuccess } from 'models/actions/player';

export function fetch(params) {
   return fetcher.fetch(params);
}

function* request(action, pageStep) {
   const canLoad = yield select(canLoadSelector);
   if (canLoad) {
      yield put({ type: types.FETCHING_PLAYERS });
      const currentPage = yield select(currentPageSelector);
      const page = currentPage + pageStep;
      const params = { ...action.params, page };
      const response = yield call(fetch, params);
      yield put(requestSuccess(response.payload, response.pagination));
   }
}

function* requestCurrentPage(action) {
   yield call(request, action, 0);
}

function* requestNext(action) {
   yield call(request, action, 1);
}

function* build(action) {
   if (action.payload) {
      const entities = action.payload.entities;

      yield put({ type: types.CREATE_ABILITIES, payload: entities.abilities });
      yield put({ type: types.CREATE_AFFINITIES, payload: entities.affinities });
      yield put({ type: types.CREATE_PLAYERS, payload: entities.players });
   } else {
      console.error('Missing payload');
   }
}

export const playerSagas = [
   takeLatest(types.REQUEST_PLAYERS, requestCurrentPage),
   takeLatest(types.REQUEST_SUCCESS_PLAYERS, build),
   takeLatest(types.CHANGE_PAGE_NEXT_PLAYERS, requestNext)
];
