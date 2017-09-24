import fetch from 'isomorphic-fetch';

const handleResponse = (response, json, parse) => {
   if (!response.ok) {
      return Promise.reject(json);
   }

   const payload = parse(json);

   return { payload };
};

export const fetchStatus = (url, parse) =>
   fetch(url).then((response) =>
      response.json().then((json) => handleResponse(response, json, parse))
   );
