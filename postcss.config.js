const options = {
  plugins: [
    require('tailwindcss')('./tailwind.config.js'),
    require('postcss-focus-visible')({
      replaceWith: '[data-focus-visible-added]',
    }),
    require('autoprefixer'),
  ]
};

// production mode
if (process.env.NODE_ENV === 'production') {
  options.plugins.push(
    require('cssnano')({
      preset: 'default',
    })
  );
}

module.exports = options;
