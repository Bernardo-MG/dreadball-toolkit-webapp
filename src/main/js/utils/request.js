import fetch from 'isomorphic-fetch'

export const fetchData = (url, transformer) =>
   fetch(url)
      .then(response => response.json())
      .then(json => transformer(json))
