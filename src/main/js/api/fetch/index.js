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

const handleResponse = (status, message, parse) => {
   if (!status) {
      return Promise.reject(message);
   }

   let content;
   if (message.number === null || message.number === undefined) {
      // Pagination info is missing
      // The payload is the message itself
      content = { payload: message };
   } else {
      content = paginatedContent(message);
   }

   // The payload is parsed
   content.payload = parse(content.payload);

   return content;
};

const fetchJsonPaginated = (url, params, parse) =>
   request.get(url).query(params).set('Accept', 'application/json').then((response) =>
      handleResponse(response.ok, response.body, parse)
   );

export const Fetcher = class {

   constructor(url, processor) {
      this.url = url;

      if (processor) {
         this.processor = processor;
      } else {
         // By default the message is not parsed
         this.processor = (message) => message;
      }
   }

   fetch(params) {
      return fetchJsonPaginated(this.url, params, this.processor).then(
         (response) => response,
         (error) => error.message || 'Request failed'
      );
   }

};
