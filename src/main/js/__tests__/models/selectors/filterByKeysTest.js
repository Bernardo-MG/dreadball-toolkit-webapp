import { filterByKeys } from 'players/selectors/utils';

const data = {
   1: 'A',
   2: 'C',
   3: 'B',
   4: 'Z',
   5: 'M'
};

describe('Filter by keys', () => {
   it('filters the input data', () => {
      expect(
         filterByKeys(data, [1, 2, 4])
         ).toEqual(
         [ 'A', 'C', 'Z' ]
      )
   })

   it('does not filter when there are no keys', () => {
      expect(
         filterByKeys(data, [])
         ).toEqual(
         []
      )
   })
});
