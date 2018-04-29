const webpack = require('webpack');
const merge = require('webpack-merge');
const common = require('./webpack.common.js');

process.traceDeprecation = true;

module.exports = merge(common, {
   devtool: 'inline-source-map',
   plugins: [
      new webpack.NamedModulesPlugin(),
      new webpack.HotModuleReplacementPlugin(),
      new webpack.LoaderOptionsPlugin({
         debug: true
      }),
      new BundleAnalyzerPlugin()
   ]
});
