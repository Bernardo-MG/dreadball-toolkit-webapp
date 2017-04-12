var path = require('path');
const webpack = require('webpack');
const autoprefixer = require('autoprefixer');
var ExtractTextPlugin = require('extract-text-webpack-plugin');

module.exports = {
   context : __dirname,
   entry : './src/main/js/index.js',
   devtool : 'inline-source-map',
   cache : true,
   debug : true,
   output : {
      path : __dirname,
      filename : './target/generated-ui/bundle.js'
   },
   resolve : {
      extensions : [ '', '.scss', '.css', '.js', '.json' ],
      modulesDirectories : [
         'src/main/js',
         path.resolve(__dirname, './src/main/js'),
         'node_modules',
         path.resolve(__dirname, './node_modules')
      ]
   },
   module : {
      loaders : [
            {
               test : /(\.js|\.jsx)$/,
               exclude : /(node_modules)/,
               loader : 'babel',
               query : {
                  cacheDirectory : true,
                  presets : [ 'es2015', 'stage-0', 'react' ]
               }
            },
            {
               test : /(\.scss|\.css)$/,
               loader : ExtractTextPlugin
                     .extract(
                           'style',
                           'css?sourceMap&modules&importLoaders=1&localIdentName=[name]__[local]___[hash:base64:5]!postcss!sass')
            } ]
   },
   postcss : [ autoprefixer ],
   sassLoader : {
      data : '@import "theme/style.scss";',
      includePaths : [ path.resolve(__dirname, './src/main/js') ]
   },
   plugins : [
      new ExtractTextPlugin('./target/generated-ui/style.css', {
         allChunks : true
      }),
      new webpack.optimize.OccurenceOrderPlugin(),
      new webpack.optimize.CommonsChunkPlugin({
         name : 'vendor',
         filename : './target/generated-ui/vendor.bundle.js',
         minChunks : Infinity
      }),
      new webpack.HotModuleReplacementPlugin(),
      new webpack.NoErrorsPlugin(),
      new webpack.DefinePlugin({
         'process.env': {
            'NODE_ENV': JSON.stringify('development')
         },
         ROUTE_BASE : JSON.stringify('/dreadball')
      }) 
   ]
};
