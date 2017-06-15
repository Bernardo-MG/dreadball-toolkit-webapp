
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
   const jsonContent = unwrapJson(json);
   const payload = parse(jsonContent)
   const content = { 
      payload
   }

   if(payload.result){
      content.elements = payload.result.length
   }

   if(json.number === null || json.number === undefined) {
      // Pagination info is missing
      // The contents is returned as received
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

   return parsePaginated(json, parse)
}

const paginateResponse = (response, parse) => {
   response.json().then(json => {
      paginateJson(response, json, parse)
   })
}

export const fetchPaginated = (url, parse) => {
   return fetch(url)
      .then(response =>
         response.json().then(json => {
            return paginateJson(response, json, parse);
         })
      )
}
