
const paginatedContent = (content) => {
   const pagination = {
      first: content.first,
      last: content.last,
      numberOfElements: content.numberOfElements,
      totalElements: content.totalElements,
      page: content.number,
      totalPages: content.totalPages,
      sort: content.sort
   };

   const result = {
      payload: content.content,
      pagination
   };

   delete result.number;
   delete content.content;

   return result;
};

const setUpContent = (content) => {
   if (content.number === null || content.number === undefined) {
      // Pagination info is missing
      // The contents is returned without pagination details
      return { payload: content };
   } else {
      return paginatedContent(content);
   }
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

export const fetchPaginated = (url, parse) => {
   return fetch(url)
      .then(response =>
         response.json().then(json => {
            return handleResponse(response, json, parse);
         })
      );
};
