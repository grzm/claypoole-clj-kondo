# clj-kondo/claypoole repro

Reproduction of issue with inline clj-kondo configuration for unused-value.

Repro'd using claypoole, which is where I came across it.

Copied claypoole clj-kondo config from https://github.com/clj-commons/claypoole/commit/fb0cce3a0755f98a03765392e382884ea01f6f02


```shell
% clj -Sdeps '{:deps {clj-kondo/clj-kondo {:git/url "https://github.com/clj-kondo/clj-kondo.git" :git/sha "32447447cc6b26c3b7e40dac8135174e6a88253d"}}}' -M -m clj-kondo.main --lint src
src/com/grzm/ex/claypoole.clj:8:5: warning: Unused value
src/com/grzm/ex/claypoole.clj:16:7: info: Redundant ignore
src/com/grzm/ex/claypoole.clj:24:3: warning: Unused value
src/com/grzm/ex/claypoole.clj:40:7: warning: Unused value
linting took 85ms, errors: 0, warnings: 3
```
