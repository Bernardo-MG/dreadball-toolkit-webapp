import { put, call, select } from 'redux-saga/effects';
import * as types from 'models/actions/actionTypes';
import { fetcherPlayer as fetcher } from 'models/requests/fetchers';
import { selectCanLoadPlayer as canLoadSelector } from 'models/selectors/request';
import { selectCurrentPlayerPage as currentPageSelector } from 'models/selectors/page';
import { requestSuccess, requestFailure } from 'models/actions/player';

export function fetch(params) {
   return fetcher.fetch(params);
}

export function* request(action, pageStep) {
   const canLoad = yield select(canLoadSelector);
   if (canLoad) {
      yield put({ type: types.FETCHING_PLAYERS });
      const currentPage = yield select(currentPageSelector);
      const page = currentPage + pageStep;
      const params = { ...action.params, page };
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

export function* requestCurrentPage(action) {
   yield call(request, action, 0);
}

export function* requestNextPage(action) {
   yield call(request, action, 1);
}
