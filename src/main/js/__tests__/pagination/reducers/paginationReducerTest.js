import paginate from 'api/pagination/reducers';

const reducer = paginate({
   idsMapping: (payload) => Object.keys(payload),
   store: 'TEST'
});

describe('Paginated reducer', () => {
   it('should return the initial state', () => {
      expect(reducer(undefined, {})).toEqual(
         {
            "first": true,
            "ids": [],
            "isFetching": false,
            "last": false,
            "numberOfElements": 0,
            "page": 0,
            "totalElements": 0,
            "totalPages": 0
         }
      )
   }),

   it('should start fetching on fetching', () => {
      expect(
         reducer({}, {
            type: 'FETCHING_TEST'
         })).toEqual(
         {
            "isFetching": true
         }
      )
   }),

   it('should finish fetching on failure', () => {
      expect(
         reducer({}, {
            type: 'REQUEST_FAILURE_TEST'
         })).toEqual(
         {
            "isFetching": false
         }
      )
   }),

   it('should finish fetching on success', () => {
      expect(
         reducer({}, {
            type: 'REQUEST_SUCCESS_TEST',
            payload: []
         })).toEqual(
         {
            "ids": [],
            "isFetching": false
         }
      )
   }),

   it('should load ids on success', () => {
      expect(
         reducer({}, {
            type: 'REQUEST_SUCCESS_TEST',
            payload: ["0", "1", "2"]
         })).toEqual(
         {
            "ids": ["0", "1", "2"],
            "isFetching": false
         }
      )
   }),

   it('should merge ids on success', () => {
      expect(
         reducer(
         {
            "ids": ["0", "2", "5"]
         }, {
            type: 'REQUEST_SUCCESS_TEST',
            payload: ["0", "1", "2"]
         })).toEqual(
         {
            "ids": ["0", "2", "5", "1"],
            "isFetching": false
         }
      )
   })
});
