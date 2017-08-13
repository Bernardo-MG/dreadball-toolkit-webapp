import fetch from 'isomorphic-fetch';

const setUpContent = (content) => {
   return { payload: content };
};

const paginateJson = (json, parse) => {
   const content = setUpContent(json);
   content.payload = parse(content.payload);

   return content;
};

const handleResponse = (response, json, parse) => {
   if (!response.ok) {
      return Promise.reject(json);
   }

   return paginateJson(json, parse);
};

export const fetchStatus = (url, parse) =>
   fetch(url).then((response) =>
         response.json().then((json) => handleResponse(response, json, parse))
      );
