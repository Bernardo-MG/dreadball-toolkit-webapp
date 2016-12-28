var path = require('path');
var autoprefixer = require('autoprefixer');
var precss = require('precss');

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
                     'style-loader', 'css-loader', 'postcss-loader'
               ]
            }
      ]
   },
   postcss : function() {
      return [
            autoprefixer, precss
      ];
   }
};
