
const appendBase = (url) => {
   let result;

   if (url.indexOf(ROUTE_BASE) === -1) {
      result = ROUTE_BASE + url;
   } else {
      result = url;
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

const appendParamsMap = (map) => {
   return Object.keys(map).filter((key) => map.hasOwnProperty(key)).reduce((a , b) => appendParams(a, b, map[b]), '');
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

export const getUrl = (endpoint, params) => {
   const localEndpoint = appendBase(endpoint);
   const url = applyParams(localEndpoint, params);

   return url;
};
