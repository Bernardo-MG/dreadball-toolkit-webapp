
const parsePaginated = (json, parse) => {
   var jsonContent;

   if(json.content){
      jsonContent = json.content;
   } else {
      jsonContent = json;
   }

   const payload = parse(jsonContent)
   const content = { 
      payload
   }

   if(payload.result){
      content.elements = payload.result.length
   }

   if(json.number === null || json.number === undefined) {
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

//export const fetchPaginated = (url, parse) => {
//   return fetch(url)
//      .then(response => {
//         paginateResponse(response, parse)
//      })
//}

export const fetchPaginated = (url, parse) => {
   return fetch(url)
      .then(response =>
         response.json().then(json => {
            if (!response.ok) {
               return Promise.reject(json)
            }

            return parsePaginated(json, parse)
         })
      )
}
