var path = require('path');
const webpack = require('webpack');
var ExtractTextPlugin = require('extract-text-webpack-plugin');

// Environment profile
const env = process.env.NODE_ENV || 'development';

// Project version
const PROJECT_VERSION = process.env.APP_VERSION || '';

// Base route
const APP_ROUTE = process.env.APP_ROUTE || '/app';

// Project URL
const PROJECT_REPO_URL = process.env.REPO_URL;

// Input directory
const INPUT_PATH = process.env.INPUT_PATH;
const INPUT_PATH_ENTRY = INPUT_PATH + 'index.js';

// Output directory
const OUTPUT_FILE_CSS = 'style.css';
const OUTPUT_FILE_VENDOR = 'vendor.bundle.js';

const OUTPUT_PATH = process.env.OUTPUT_PATH;
const OUTPUT_PATH_BUNDLE = OUTPUT_PATH + 'bundle.js';

// Modules dependencies directory
const MODULE_PATH = process.env.MODULE_PATH;

// Plugins
plugins = [
   new ExtractTextPlugin({
      filename: OUTPUT_FILE_CSS,
      allChunks : true
   }),
   new webpack.optimize.OccurrenceOrderPlugin(),
   new webpack.optimize.CommonsChunkPlugin({
      name : 'vendor',
      filename : OUTPUT_FILE_VENDOR,
      minChunks : Infinity
   }),
   new webpack.NoEmitOnErrorsPlugin(),
   new webpack.DefinePlugin({
      'process.env': {
         NODE_ENV: JSON.stringify(env)
      },
      APP_VERSION : JSON.stringify(PROJECT_VERSION),
      ROUTE_BASE : JSON.stringify(APP_ROUTE),
      REPO_URL : JSON.stringify(PROJECT_REPO_URL)
   }) 
]

var devtool = null;
if (env === 'production') {
   // Production specific configuration
   devtool = false,
   plugins = plugins.concat([
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
   ]);
} else {
   // Development specific configuration
   process.traceDeprecation = true;
   devtool = 'inline-source-map',
   plugins = plugins.concat([
      new webpack.NamedModulesPlugin(),
      new webpack.HotModuleReplacementPlugin(),
      new webpack.LoaderOptionsPlugin({
         debug: true
      })
   ]);
}

module.exports = {
   context : __dirname,
   entry: {
      app: INPUT_PATH_ENTRY,
   },
   devtool,
   cache : true,
   output : {
      path : path.resolve(__dirname, OUTPUT_PATH),
      filename : 'bundle.js'
   },
   resolve : {
      extensions : [ '.scss', '.css', '.js', '.json' ],
      modules : [
         'src/main/js',
         path.resolve(__dirname, INPUT_PATH),
         'node_modules',
         path.resolve(__dirname, MODULE_PATH)
      ]
   },
   module : {
      rules : [
       		{
               test : /(\.js)$/,
               enforce: 'pre',
               exclude: /node_modules/,
               loader: 'eslint-loader'
            },
            {
               test : /(\.js)$/,
               exclude: /node_modules/,
               use: {
                  loader : 'babel-loader',
                  options : {
                     presets : [ 
                        ["env", {
                           "targets": { node: "6" },
                        }],
                        'es2015', 'stage-0', 'react' ]
                  }
               }
            },
            {
               test : /\.css$/,
               exclude: /node_modules/,
               loader : ExtractTextPlugin
                     .extract({
                           fallback: 'style-loader',
                           use: [
                              {
                                 loader: 'css-loader'
                              },
                              {
                                 loader: 'sass-loader',
                                 options: {
                                    includePaths : [ path.resolve(__dirname, INPUT_PATH), path.resolve(__dirname, MODULE_PATH), path.resolve(__dirname, './node_modules/grommet/node_modules') ]
                                 }
                              }
                           ]
                     })
            },
            {
               test : /\.scss$/,
               exclude: /node_modules/,
               loader : ExtractTextPlugin
                     .extract({
                           fallback: 'style-loader',
                           use: [
                              {
                                 loader: 'css-loader',
                                 query: {
                                    modules: true,
                                    sourceMap: true,
                                    importLoaders: 2
                                 }
                              },
                              {
                                 loader: 'sass-loader',
                                 options: {
                                    includePaths : [ path.resolve(__dirname, INPUT_PATH), path.resolve(__dirname, MODULE_PATH) ]
                                 }
                              }
                           ]
                     })
            } ]
   },
   plugins
};
