# Props parameters

In order to get specific parameters while not having to pass tailwind classes (as w-64 for width or h-64 for height), we added a simple parameter list for your team. The idea is to pass a keyword, such as `:sm` or `:full` making it easier into some specified props. 

## Examples
- profile picture roundness:
you can pass on your component the key roundness and a value into it, such as :full or sm

``` clojure
(:require [mockingbird.components.image :refer [pfp]])

($ pfp {:theme :mockingbird :size :lg :roundness :full}))

```

;; TODO list of all these new types
