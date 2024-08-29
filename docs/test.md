# Running the local mocking bird tests

Mockingbird is a powerful tool for helping you build your project, but, as a great dev, you will not insert any random tool someone told you to. Instead, you are probably gonna test it several times and also contribute to the open source code, won't ya?

> To do so, follow this simple md file

## Dev 

To start our demo, simply:

**Watch Mode**: Automatically rebuilds your application on file changes.
   
   ```sh
   npm run app:watch
   ```

   This command runs both the Shadow-CLJS watcher and the PostCSS watcher.

 **REPL**: Starts a Clojure REPL connected to your application.

   ```sh
   npm run repl
   ```

## Testing

 **Karma CI Tests**: Runs the tests once using Karma.

   ```sh
   npm run ci:tests
   ```

   This command sets up the test environment with `msw` and runs the tests using Shadow-CLJS and Karma. The tests are compiled and executed with the `ci-tests` build configuration.

### Additional Commands

- **postcss:build**: Runs PostCSS to build the CSS file.
- **postcss:watch**: Runs PostCSS in watch mode for development.
- **ci:karma-make**: Initializes the MSW (Mock Service Worker) in the test directory.


Now you are done, contribute as much as you want, or give our team a shout out on our [repos](https://github.com/moclojer)
