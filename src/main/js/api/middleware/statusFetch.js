import { defaultFetch as fetch } from 'api/fetch';
import middleware from 'api/middleware';

// A Redux middleware that interprets actions with CALL_API_STATUS info specified.
// Performs the call and promises when such actions are dispatched.
export default () => (next) => (action) => {
   middleware(next, action, fetch);
};
