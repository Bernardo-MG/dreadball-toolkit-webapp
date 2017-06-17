

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
   if(page){
      if(params){
         params = params + '&&';
      }
      params = params + 'page=' + page;
   }
}

const orderByParams = (params, orderBy, order) => {
   if(orderBy){
      if(params){
         params = params + '&&';
      }
      params = params + 'orderBy=' + orderBy + '&&' + 'order=' + order;
   }
}

export const getUrl = (endpoint, params) => {
   const localEndpoint = appendBase(endpoint);
   const url = applyParams(localEndpoint, params)

   return url;
}
