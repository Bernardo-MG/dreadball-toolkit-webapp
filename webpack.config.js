var path = require('path');
const webpack = require('webpack');
var ExtractTextPlugin = require('extract-text-webpack-plugin');

// Environment profile
const env = process.env.NODE_ENV || 'development';

// Output directory
const pathOutput = './target/generated-ui/';

// Plugins
plugins = [
   new ExtractTextPlugin(pathOutput + 'style.css', {
      allChunks : true
   }),
   new webpack.optimize.OccurenceOrderPlugin(),
   new webpack.optimize.CommonsChunkPlugin({
      name : 'vendor',
      filename : pathOutput + 'vendor.bundle.js',
      minChunks : Infinity
   }),
   new webpack.NoErrorsPlugin(),
   new webpack.DefinePlugin({
      'process.env': {
         NODE_ENV: JSON.stringify(env)
      },
      ROUTE_BASE : JSON.stringify('/dreadball')
   }) 
]

var debug = false;
const devtool = null;
if (env === 'production') {
   // Production specific configuration
   plugins.push(
      new webpack.optimize.UglifyJsPlugin({
         compress: {
            warnings: false,
            screw_ie8: true,
            conditionals: true,
            unused: true,
            comparisons: true,
            sequences: true,
            dead_code: true,
            evaluate: true,
            if_return: true,
            join_vars: true,
         },
         mangle: {
            screw_ie8: true
         },
         output: {
            comments: false,
            screw_ie8: true
         }
      })
   );
} else {
   // Development specific configuration
   debug = true;
   devtool = 'inline-source-map',
   plugins = plugins.concat([
      new webpack.HotModuleReplacementPlugin()
   ]);
}

module.exports = {
   context : __dirname,
   entry : './src/main/js/index.js',
   devtool,
   cache : true,
   debug,
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
                     .extract({
          fallback: "style-loader",
          use: "css-loader"
        })
            } ]
   },
   sassLoader : {
      data : '@import "theme/style.scss";',
      includePaths : [ path.resolve(__dirname, './src/main/js'), path.resolve(__dirname, './node_modules') ]
   },
   plugins
};
