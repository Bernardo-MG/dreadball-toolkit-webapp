import { put, call, select, takeLatest } from 'redux-saga/effects';
import * as types from 'players/actions/actionTypes';
import * as requestTypes from 'builder/requests/players/actions/actionTypes';
import { fetcherAffinityPlayer as fetcher } from 'builder/requests/players/fetchers';
import { selectCanLoadRatedPlayer as canLoadSelector } from 'players/selectors/request';
import { selectCurrentRatedPlayerPage as currentPageSelector } from 'players/selectors/page';
import { requestSuccess, requestFailure } from 'builder/requests/players/actions/ratedPlayers';
import { selectSponsorAffinities } from 'builder/players/selectors';

function fetch(params) {
   return fetcher.fetch(params);
}

function* request(action, pageStep) {
   const canLoad = yield select(canLoadSelector);
   if (canLoad) {
      yield put({ type: requestTypes.FETCHING_RATED_PLAYERS });
      const currentPage = yield select(currentPageSelector);
      const page = currentPage + pageStep;
      const affinities = yield select(selectSponsorAffinities);
      const params = { ...action.params, affinities, page };
      let response;
      try {
         response = yield call(fetch, params);
         if (response) {
            yield put(requestSuccess(response.payload, response.pagination));
         } else {
            yield put(requestFailure('Undefined response'));
         }
      } catch (err) {
         yield put(requestFailure(err));
      }
   }
}

function* requestCurrentPage(action) {
   yield call(request, action, 0);
}

function* requestNextPage(action) {
   yield call(request, action, 1);
}

export function* build(action) {
   if (action.payload) {
      const { entities } = action.payload;

      yield put({ type: types.CREATE_ABILITIES, payload: entities.abilities });
      yield put({ type: types.CREATE_RATED_PLAYERS, payload: entities.players });
   } else {
      console.error('Missing payload');
   }
}

export const ratedPlayerRequestSagas = [
   takeLatest(requestTypes.REQUEST_RATED_PLAYERS, requestCurrentPage),
   takeLatest(requestTypes.REQUEST_SUCCESS_RATED_PLAYERS, build),
   takeLatest(requestTypes.CHANGE_PAGE_NEXT_RATED_PLAYERS, requestNextPage)
];
