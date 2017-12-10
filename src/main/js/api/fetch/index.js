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

const handleResponse = (response, json, parse) => {
   if (!response.ok) {
      return Promise.reject(json);
   }

   const content = setUpContent(json);
   content.payload = parse(content.payload);

   return content;
};

const fetchPaginated = (url, params, parse) =>
   request.get(url).query(params).set('Accept', 'application/json').then((response) =>
      handleResponse(response, response.body, parse)
   );

export const Fetcher = class {

   constructor(url, processor) {
      this.url = url;

      if (processor) {
         this.processor = processor;
      } else {
         this.processor = (json) => json;
      }
   }

   fetch(params) {
      return fetchPaginated(this.url, params, this.processor).then(
         (response) => response,
         (error) => error.message || 'Request failed'
      );
   }

};
