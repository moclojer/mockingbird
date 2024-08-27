const options = {
  plugins: [
    // Tailwind CSS framework
    require('tailwindcss')('./tailwind.config.js'),
    // Focus-visible polyfill
    require('postcss-focus-visible')({
      replaceWith: '[data-focus-visible-added]',
    }),
    // Autoprefixer for vendor prefixes
    require('autoprefixer'),
  ]
};

// production mode
if (process.env.NODE_ENV === 'production') {
  // Add CSS minification plugin
  options.plugins.push(
    require('cssnano')({
      preset: 'default',
    })
  );
}

module.exports = options;
