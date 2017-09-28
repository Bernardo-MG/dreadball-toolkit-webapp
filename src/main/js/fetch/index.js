import request from 'superagent';

const handleResponse = (response, json, parse) => {
   if (!response.ok) {
      return Promise.reject(json);
   }

   const payload = parse(json);

   return { payload };
};

export const fetchStatus = (url, parse) =>
   request.get(url).set('Accept', 'application/json').then((response) =>
      handleResponse(response, response.body, parse)
   );
