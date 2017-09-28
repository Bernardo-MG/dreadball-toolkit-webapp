import request from 'superagent';

const paginatedContent = (content) => {
   const pagination = {
      first: content.first,
      last: content.last,
      numberOfElements: content.numberOfElements,
      totalElements: content.totalElements,
      page: content.number,
      totalPages: content.totalPages,
      pageSize: content.size,
      sort: content.sort
   };

   const result = {
      payload: content.content,
      pagination
   };

   return result;
};

const setUpContent = (content) => {
   let result;

   if (content.number === null || content.number === undefined) {
      // Pagination info is missing
      // The contents is returned without pagination details
      result = { payload: content };
   } else {
      result = paginatedContent(content);
   }

   return result;
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

export const fetchPaginated = (url, params, parse) =>
   request.get(url).query(params).set('Accept', 'application/json').then((response) =>
      handleResponse(response, response.body, parse)
   );
