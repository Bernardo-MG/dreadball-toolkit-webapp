
const unwrapJson = (json) => {
   let jsonContent;
   
   if(json.content){
      jsonContent = json.content;
   } else {
      jsonContent = json;
   }
   
   return jsonContent;
}

const parsePaginated = (json, parse) => {
   const payload = parse(json)
   const content = { 
      payload
   }

   if(payload.result){
      content.elements = payload.result.length
   }

   if(json.number === null || json.number === undefined) {
      // Pagination info is missing
      // The contents is returned without pagination details
      return content
   } else {
      return {
            ...content,
            page: json.number,
            first: json.first,
            last: json.last,
            totalPages: json.totalPages,
            totalElements: json.totalElements
            }
   }
   
}
const paginateJson = (response, json, parse) => {
   if (!response.ok) {
      return Promise.reject(json)
   }

   const composedParse = (json) => parse(unwrapJson(json));
   return parsePaginated(json, composedParse)
}

export const fetchPaginated = (url, parse) => {
   return fetch(url)
      .then(response =>
         response.json().then(json => {
            return paginateJson(response, json, parse);
         })
      )
}
