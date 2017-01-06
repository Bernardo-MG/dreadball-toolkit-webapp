var path = require('path');
var ExtractTextPlugin = require('extract-text-webpack-plugin');

module.exports = {
   entry : './src/main/js/app.js',
   devtool : 'sourcemaps',
   cache : true,
   debug : true,
   output : {
      path : __dirname,
      filename : './src/main/webapp/resources/built/bundle.js'
   },
   module : {
      loaders : [
            {
               test : path.join(__dirname, '.'),
               exclude : /(node_modules)/,
               loader : 'babel',
               query : {
                  cacheDirectory : true,
                  presets : [
                        'es2015', 'react'
                  ]
               }
            }, {
               test : /\.scss$/,
               loaders : [
                     'style', 'css', 'sass'
               ]
            }, {
               test : /\.scss$/,
               loader : ExtractTextPlugin.extract('css!sass')
            }
      ]
   },
   plugins : [
      new ExtractTextPlugin('./src/main/webapp/resources/built/style.css', {
         allChunks : true
      })
   ]
};
