var path = require('path');
var ExtractTextPlugin = require('extract-text-webpack-plugin');

module.exports = {
   entry : './src/main/js/index.js',
   devtool : 'sourcemaps',
   cache : true,
   debug : true,
   output : {
      path : __dirname,
      filename : './generated/bundle.js'
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
   sassLoader : {
      includePaths : [
         './node_modules'
      ]
   },
   plugins : [
      new ExtractTextPlugin('./generated/style.css', {
         allChunks : true
      })
   ]
};
