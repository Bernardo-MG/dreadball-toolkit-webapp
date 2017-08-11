
const appendBase = (url) => {
   let result;

   if (url.indexOf(ROUTE_BASE) === -1) {
      result = ROUTE_BASE + url;
   } else {
      result = url;
   }

   return result;
};

const applyParams = (url, params) => {
   let result = url;
   let urlParams = '';

   urlParams = appendParamsMap(params);

   // Params are added to the URL
   if (urlParams) {
      result = result + '?' + urlParams;
   }

   return result;
};

const appendParamsMap = (map) => {
   let result = '';
   let value;

   for (var key in map) {
      if (map.hasOwnProperty(key)) {
         result = appendParams(result, key, map[key]);
      }
   }

   return result;
};

const appendParams = (params, key, value) => {
   let result = params;

   if (value) {
      if (result) {
         result += '&&';
      }
      result = result + key + '=' + value;
   }

   return result;
};

export const getUrl = (endpoint, params) => {
   const localEndpoint = appendBase(endpoint);
   const url = applyParams(localEndpoint, params);

   return url;
};
