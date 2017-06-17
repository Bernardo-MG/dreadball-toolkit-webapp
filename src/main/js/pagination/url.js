
const appendBase = (url) => {
   if(url.indexOf(ROUTE_BASE) === -1) {
      return ROUTE_BASE + url
   } else {
      return url
   }
}

const applyParams = (url, params) => {
   let result = url;
   let urlParams = '';

   urlParams = appendParamsMap(params);

   // Params are added to the URL
   if(urlParams){
      result = result + '?' + urlParams;
   }

   return result;
}

const appendParamsMap = (map) => {
   let result = '';

   for (var key in map) {
      if (map.hasOwnProperty(key)) {
         result = appendParams(result, key + '=' + map[key]);
      }
   }

   return result;
}

const appendParams = (params, newParams) => {
   let result = params;

   if(result){
      result = result + '&&';
   }
   result = result + newParams;

   return result;
}

export const getUrl = (endpoint, params) => {
   const localEndpoint = appendBase(endpoint);
   const url = applyParams(localEndpoint, params)

   return url;
}
