
const paginatedContent = (content) => {
   const result = {
      ...content,
      page: content.number,
      payload: content.content
   }
   
   delete result.number;
   delete content.content;
   
   return result;
}

const setPayload = (payload) => {
   return { 
      payload
   };
}

const setPaginationData = (content) => {
   if(content.number === null || content.number === undefined) {
      // Pagination info is missing
      // The contents is returned without pagination details
      return setPayload(content)
   } else {
      return paginatedContent(content)
   }
   
}
const paginateJson = (response, json, parse) => {
   if (!response.ok) {
      return Promise.reject(json)
   }

   let content = setPaginationData(json);
   content.payload = parse(content.payload);

   return content;
}

export const fetchPaginated = (url, parse) => {
   return fetch(url)
      .then(response =>
         response.json().then(json => {
            return paginateJson(response, json, parse);
         })
      )
}
