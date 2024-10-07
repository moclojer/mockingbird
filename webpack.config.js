const path = require('path');

module.exports = (env) => {
  const isProduction = env.isProduction === 'true';
  
  return {
    mode: (isProduction ? 'production' : 'development'),
    devtool: isProduction ? 'source-map' : 'eval-source-map',
    context: path.resolve(__dirname, 'target'), 
    entry: './mockingbird.core.js',
    module: {
      rules: [
        {
          test: /\.js$/, 
          use: 'babel-loader',
          exclude: /node_modules/,
        },
        {
          test: /\.css$/,
          use: ['style-loader', 'css-loader'], 
        },
      ],
    },
    output: {
      path: path.resolve(__dirname, 'dist'),
      filename: `mockingbird-core${isProduction ? '.min' : ''}.js`,
    },
  };
};
