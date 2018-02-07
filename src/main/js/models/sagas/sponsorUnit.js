import { put, takeLatest, call, select } from 'redux-saga/effects';
import * as types from 'models/actions/actionTypes';
import { fetcherSponsorUnit as fetcher } from 'models/requests/fetchers';
import { selectCurrentRatedUnitPage as currentPageSelector, selectLastRatedUnitPage as lastPageSelector } from 'models/selectors/page';
import { selectRatedUnitIsFetching as fetchingSelector } from 'models/selectors/request';
import { requestSuccess } from 'models/actions/sponsorUnit';
import { selectSponsorAffinities } from 'models/selectors';

export function fetch(params) {
   return fetcher.fetch(params);
}

function* request(action, pageStep) {
   const fetching = yield select(fetchingSelector);
   const lastPage = yield select(lastPageSelector);
   if (!fetching && !lastPage) {
      yield put({ type: types.FETCHING_TEAM_UNITS });
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
   yield put({ type: types.CREATE_ABILITIES, payload: action.payload.entities.abilities });
   yield put({ type: types.CREATE_RATED_UNITS, payload: action.payload.entities.units });
}

export const sponsorUnitSagas = [
   takeLatest(types.REQUEST_TEAM_UNITS, requestCurrent),
   takeLatest(types.REQUEST_SUCCESS_TEAM_UNITS, build),
   takeLatest(types.CHANGE_PAGE_NEXT_TEAM_UNITS, requestNext)
];
