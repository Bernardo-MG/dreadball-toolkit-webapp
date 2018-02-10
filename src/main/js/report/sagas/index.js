import { takeLatest, call, select } from 'redux-saga/effects';
import * as types from 'report/actions/actionTypes';
import { fetcherReport as fetcher } from 'report/requests/fetchers';

import { selectAssets } from 'builder/assets/selectors';
import { selectChosenAffinities } from 'builder/affinities/selectors';
import { selectBaseRank } from 'builder/sponsors/selectors';
import { selectUnits } from 'builder/units/selectors';

export function fetch(params) {
   return fetcher.fetch(params);
}

function* request(action) {
   const assets = yield select(selectAssets);
   const affinities = yield select(selectChosenAffinities);
   const units = yield select(selectUnits);
   const baseRank = yield select(selectBaseRank);

   const team = { affinities, units, baseRank, ...assets };

   yield call(fetch, { ...action.params, ...team });
}

export const reportSagas = [
   takeLatest(types.REQUEST_TEAM_REPORT, request)
];
