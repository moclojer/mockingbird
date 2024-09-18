const path = require('path'); // Use Node.js 'path' module

module.exports = {
  mode: 'production',
  context: path.resolve(__dirname, 'target'), 
  entry: './mockingbird.lib.js',
  module: {
    rules: [
      {
        test: /\.js$/, 
        use: 'babel-loader',
        exclude: /node_modules/,
      },
      {
        test: /\.css$/, // Match CSS files
        use: ['style-loader', 'css-loader'], 
      },
    ],
  },
  output: {
    path: path.resolve(__dirname, 'dist'),
    filename: 'bundle.js', 
  },
};
;
