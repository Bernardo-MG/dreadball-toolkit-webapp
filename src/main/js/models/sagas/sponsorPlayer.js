import { put, takeLatest, call, select } from 'redux-saga/effects';
import * as types from 'models/actions/actionTypes';
import { fetcherSponsorPlayer as fetcher } from 'models/requests/fetchers';
import { selectCurrentRatedPlayerPage as currentPageSelector, selectLastRatedPlayerPage as lastPageSelector } from 'models/selectors/page';
import { selectRatedPlayerIsFetching as fetchingSelector } from 'models/selectors/request';
import { requestSuccess } from 'models/actions/sponsorPlayer';
import { selectSponsorAffinities } from 'models/selectors';

export function fetch(params) {
   return fetcher.fetch(params);
}

function* request(action, pageStep) {
   const fetching = yield select(fetchingSelector);
   const lastPage = yield select(lastPageSelector);
   if (!fetching && !lastPage) {
      yield put({ type: types.FETCHING_TEAM_PLAYERS });
      const currentPage = yield select(currentPageSelector);
      const page = currentPage + pageStep;
      const affinities = yield select(selectSponsorAffinities);
      const params = { ...action.params, affinities, page };
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
   if (action.payload) {
      const entities = action.payload.entities;

      yield put({ type: types.CREATE_ABILITIES, payload: entities.abilities });
      yield put({ type: types.CREATE_RATED_PLAYERS, payload: entities.players });
   } else {
      console.error('Missing payload');
   }
}

export const sponsorPlayerSagas = [
   takeLatest(types.REQUEST_TEAM_PLAYERS, requestCurrent),
   takeLatest(types.REQUEST_SUCCESS_TEAM_PLAYERS, build),
   takeLatest(types.CHANGE_PAGE_NEXT_TEAM_PLAYERS, requestNext)
];
