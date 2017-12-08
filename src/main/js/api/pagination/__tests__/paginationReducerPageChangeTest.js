import paginate from '../reducers';

const reducer = paginate({
   idsMapping: (payload) => Object.keys(payload),
   store: 'TEST'
});

describe('Paginated reducer - Page change', () => {
   it('should not move to the next page when it is the last page', () => {
      expect(
         reducer({ "page": 0, "last": true }, {
            type: 'CHANGE_PAGE_NEXT_TEST'
         })).toEqual(
         {
            "last": true,
            "page": 0
         }
      )
   })

   it('should not move to the previous page when it is the first page', () => {
      expect(
         reducer({ "page": 1, "first": true }, {
            type: 'CHANGE_PAGE_PREV_TEST'
         })).toEqual(
         {
            "first": true,
            "page": 1
         }
      )
   })

   it('should not move to the previous page when it is the page 0', () => {
      expect(
         reducer({ "page": 0, "first": false }, {
            type: 'CHANGE_PAGE_PREV_TEST'
         })).toEqual(
         {
            "first": false,
            "page": 0
         }
      )
   })

   it('should move to the next page', () => {
      expect(
         reducer({ "page": 0, "last": false }, {
            type: 'CHANGE_PAGE_NEXT_TEST'
         })).toEqual(
         {
            "last": false,
            "page": 1
         }
      )
   })

   it('should move to the previous page', () => {
      expect(
         reducer({ "page": 1, "first": false }, {
            type: 'CHANGE_PAGE_PREV_TEST'
         })).toEqual(
         {
            "first": false,
            "page": 0
         }
      )
   })
});
