

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

   // Page params
   if(params.page){
      urlParams = paginationParams(urlParams, params.page);
   }

   // Ordering params
   if(params.orderBy){
      urlParams = orderByParams(urlParams, params.orderBy, params.order);
   }

   // Params are added to the URL
   if(urlParams){
      result = result + '?' + urlParams;
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

const paginationParams = (params, page) => {
   return appendParams(params, 'page=' + page);
}

const orderByParams = (params, orderBy, order) => {
   return appendParams(params, 'orderBy=' + orderBy + '&&' + 'order=' + order);
}

export const getUrl = (endpoint, params) => {
   const localEndpoint = appendBase(endpoint);
   const url = applyParams(localEndpoint, params)

   return url;
}
