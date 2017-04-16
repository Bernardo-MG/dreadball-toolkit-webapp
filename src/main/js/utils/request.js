import fetch from 'isomorphic-fetch'

export const fetchData = (url, parse) =>
   fetch(url)
      .then(response => response.json())
      .then(json => parse(json))
