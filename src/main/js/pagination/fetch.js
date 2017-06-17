
const paginatedContent = (content) => {
   const result = {
      ...content,
      page: content.number
   }
   
   delete result.number;
   
   return result;
}

const setPayload = (json) => {
   let result;

   if(json.content){
      result = Object.assign({}, json);
      result.payload = result.content;
      delete result.content;
   } else {
      result = json;
   }
   
   return result;
}

const wrapContent = (payload) => {
   return { 
      payload
   };
}

const setPaginationData = (content) => {
   if(content.payload.number === null || content.payload.number === undefined) {
      // Pagination info is missing
      // The contents is returned without pagination details
      return content
   } else {
      return paginatedContent(content.payload, content)
   }
   
}
const paginateJson = (response, json, parse) => {
   if (!response.ok) {
      return Promise.reject(json)
   }
   
   let content = wrapContent(setPayload(json));
   content = setPaginationData(content);
   content.payload = parse(content.payload);
   
   return content
}

export const fetchPaginated = (url, parse) => {
   return fetch(url)
      .then(response =>
         response.json().then(json => {
            return paginateJson(response, json, parse);
         })
      )
}
