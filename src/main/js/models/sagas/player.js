import { put, takeLatest, call, select } from 'redux-saga/effects';
import * as types from 'models/actions/actionTypes';
import { fetcherPlayer as fetcher } from 'models/requests/fetchers';
import { selectCurrentPlayerPage as currentPageSelector, selectLastPlayerPage as lastPageSelector } from 'models/selectors/page';
import { selectPlayerIsFetching as fetchingSelector } from 'models/selectors/request';
import { requestSuccess } from 'models/actions/player';

export function fetch(params) {
   return fetcher.fetch(params);
}

function* request(action, pageStep) {
   const fetching = yield select(fetchingSelector);
   const lastPage = yield select(lastPageSelector);
   if (!fetching && !lastPage) {
      yield put({ type: types.FETCHING_PLAYERS });
      const currentPage = yield select(currentPageSelector);
      const page = currentPage + pageStep;
      const params = { ...action.params, page };
      const response = yield call(fetch, params);
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
   yield put({ type: types.CREATE_PLAYERS, payload: action.payload.entities.players });
}

export const playerSagas = [
   takeLatest(types.REQUEST_PLAYERS, requestCurrent),
   takeLatest(types.REQUEST_SUCCESS_PLAYERS, build),
   takeLatest(types.CHANGE_PAGE_NEXT_PLAYERS, requestNext)
];
