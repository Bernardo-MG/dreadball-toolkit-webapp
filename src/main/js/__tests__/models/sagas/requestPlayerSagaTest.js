import { request } from 'models/sagas/players/requests';
import { select, put } from 'redux-saga/effects';
import { selectCanLoadPlayer as canLoadSelector } from 'models/selectors/request';
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
   it('fetches players if it can load', () => {
      const gen = generator.clone();
      gen.next();
      expect(
         gen.next(true).value
         ).toEqual(
         put({ type: types.FETCHING_PLAYERS })
      )
   })
});
