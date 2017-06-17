

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
   urlParams = paginationParams(urlParams, params.page);

   // Ordering params
   urlParams = orderByParams(urlParams, params.orderBy, params.order);

   // Params are added to the URL
   if(urlParams){
      result = result + '?' + urlParams;
   }

   return result;
}

const paginationParams = (params, page) => {
   let result = params;

   if(page){
      if(result){
         result = result + '&&';
      }
      result = result + 'page=' + page;
   }

   return result;
}

const orderByParams = (params, orderBy, order) => {
   let result = params;

   if(orderBy){
      if(result){
         result = result + '&&';
      }
      result = result + 'orderBy=' + orderBy + '&&' + 'order=' + order;
   }

   return result;
}

export const getUrl = (endpoint, params) => {
   const localEndpoint = appendBase(endpoint);
   const url = applyParams(localEndpoint, params)

   return url;
}
