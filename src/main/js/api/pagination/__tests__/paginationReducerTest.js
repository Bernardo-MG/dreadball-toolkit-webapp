import paginate from '../reducers';

const reducer = paginate({
   idsMapping: (payload) => Object.keys(payload.entities.units),
   store: 'TEST'
});

describe('Paginated reducer reducer', () => {
   it('should return the initial state', () => {
      expect(reducer(undefined, {})).toEqual(
         {
            "first": true,
            "ids": [],
            "isFetching": false,
            "last": true,
            "numberOfElements": 0,
            "page": 0,
            "totalElements": 0,
            "totalPages": 0
         }
      )
   })
});
