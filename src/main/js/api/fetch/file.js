import request, { parse } from 'superagent';

function showFile(blob) {
   // It is necessary to create a new blob object with mime-type explicitly set
   // otherwise only Chrome works like it should
   const newBlob = new Blob([blob], { type: 'application/pdf' });

   // IE doesn't allow using a blob object directly as link href
   // instead it is necessary to use msSaveOrOpenBlob
   if (window.navigator && window.navigator.msSaveOrOpenBlob) {
      window.navigator.msSaveOrOpenBlob(newBlob);
      return;
   }

   // For other browsers: 
   // Create a link pointing to the ObjectURL containing the blob.
   const data = window.URL.createObjectURL(newBlob);
   const link = document.createElement('a');
   link.href = data;
   link.download = 'file.pdf';
   link.click();
   setTimeout(() => {
      // For Firefox it is necessary to delay revoking the ObjectURL
      window.URL.revokeObjectURL(data);
   },
   100
   );
}

export const Fetcher = class {

   constructor(url) {
      this.url = url;
   }

   fetch() {
      return request.get(this.url)
         .responseType('blob')
         .parse(parse.image)
         .then(
            (response) => {
               showFile(response.body);
            },
            (error) => error.message || 'Request failed'
         );
   }

};
