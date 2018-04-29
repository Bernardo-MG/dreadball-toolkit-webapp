import { request, fetch } from 'models/sagas/players/requests';
import { select, put, call } from 'redux-saga/effects';
import { selectCanLoadPlayer as canLoadSelector } from 'models/selectors/request';
import { selectCurrentPlayerPage as currentPageSelector } from 'models/selectors/page';
import { requestSuccess, requestFailure } from 'models/actions/players';
import { cloneableGenerator } from 'redux-saga/utils';
import * as types from 'models/actions/actionTypes';

const generator = cloneableGenerator(request)({}, 0);

describe('Player requests saga', () => {
   it('checks first if it can load', () => {
      const gen = generator.clone();
      expect(
         gen.next().value
         ).toEqual(
         select(canLoadSelector)
      )
   }),
   it('does nothing if it can not load', () => {
      const gen = generator.clone();
      gen.next();
      expect(
         gen.next(false).value
         ).toEqual(
         undefined
      )
   }),
   it('signals it starts fetching players', () => {
      const gen = generator.clone();
      gen.next();
      expect(
         gen.next(true).value
         ).toEqual(
         put({ type: types.FETCHING_PLAYERS })
      )
   }),
   it('fetches players', () => {
      const gen = generator.clone();
      gen.next();
      gen.next(true);
      gen.next();
      const params = { page: 0 };
      expect(
         gen.next(0).value
         ).toEqual(
         call(fetch, params)
      )
   }),
   it('signals success', () => {
      const gen = generator.clone();
      gen.next();
      gen.next(true);
      gen.next();
      gen.next(0);
      const params = { page: 0 };
      expect(
         gen.next({ payload: 'payload', pagination: 1 }).value
         ).toEqual(
         put(requestSuccess('payload', 1))
      )
   }),
   it('signals failure with undefined response', () => {
      const gen = generator.clone();
      gen.next();
      gen.next(true);
      gen.next();
      gen.next(0);
      const params = { page: 0 };
      expect(
         gen.next(undefined).value
         ).toEqual(
         put(requestFailure('Undefined response'))
      )
   }),
   it('signals failure with exception', () => {
      const gen = generator.clone();
      gen.next();
      gen.next(true);
      gen.next();
      gen.next(0);
      const params = { page: 0 };
      expect(
         gen.throw('error').value
         ).toEqual(
         put(requestFailure('error'))
      )
   })
});
