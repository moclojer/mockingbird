# Props parameters

In order to get specific parameters while not having to pass tailwind classes (as w-64 for width or h-64 for height), we added keyword-based parameters for easy configuration. The idea is to pass a keyword, such as `:sm` or `:full`, making it easier to just plug and play our componentes. 

## Examples
- component roundness:

you can pass on your component the key roundness and a value into it, such as :full or sm

``` clojure

(:require [mockingbird.components.image :refer [pfp]])

($ pfp {:theme :mockingbird
        :size :lg
        :roundness :full}))

```

## Parameter Overview

The available options (until now) are:

- **Size**: `:none`, `:sm`, `:md`, `:lg`, `:xl`, `:full`
- **Roundness**: `:none`, `:sm`, `:md`, `:full`
- **Shadow**: `:none`, `:sm`, `:md`, `:lg`
- **Padding**: `:none`, `:sm`, `:md`, `:lg`
- **Margin**: `:none`, `:sm`, `:md`, `:lg`

