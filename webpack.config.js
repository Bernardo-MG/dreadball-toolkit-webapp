var path = require('path');
const webpack = require('webpack');

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
   // Use the default plugin after moving to Webpack 4
   const UglifyJsPlugin = require('uglifyjs-webpack-plugin')
   // Production specific configuration
   devtool = false,
   plugins = plugins.concat([
      new UglifyJsPlugin({
         uglifyOptions: {
            compress: {
               warnings: false,
               conditionals: true,
               unused: true,
               comparisons: true,
               sequences: true,
               dead_code: true,
               evaluate: true,
               if_return: true,
               join_vars: true,
            },
            output: {
               comments: false
            }
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
                        'stage-0', 'react' ]
                  }
               }
            },
            {
               test : /\.(css|scss)$/,
               exclude: /node_modules/,
               use: [
                  {
                     loader: 'file-loader',
                     options: {
                        name: OUTPUT_FILE_CSS
                     }
                  },
                  {
                     loader: 'sass-loader',
                     options: {
                        includePaths : [ path.resolve(__dirname, MODULE_PATH) ]
                     }
                  }
               ]
            } ]
   },
   plugins
};
