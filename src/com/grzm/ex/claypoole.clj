(ns com.grzm.ex.claypoole
  (:require [com.climate.claypoole :as cp]))

(defn naked-claypoole
  "warning: Unused value"
  [& _args]
  (let [pool (cp/threadpool 2)]
    (cp/upfor pool [n 5]
              (fn [] (prn {:n n})))
    :do-other-work))

(defn with-ignore-claypoole
  "info: Redundant ignore"
  [& _args]
  (let [pool (cp/threadpool 2)]
    #_{:clj-kondo/ignore [:unused-value]}
    (cp/upfor pool [n 5]
              (fn [] (prn {:n n})))
    :do-other-work))

(defn naked
  "warning: Unused value"
  [& _args]
  (+ 1 1)
  :do-other-work)

(defn with-ignore
  "works as expected"
  [& _args]
  #_{:clj-kondo/ignore [:unused-value]}
  (+ 1 1)
  :do-other-work)


(defn naked-for
  "warning: Unused value"
  [& _args]
  (for [n (range 4)]
    (do
      (inc n)
      :do-other-work)))

(defn for-with-ignore
  "works as expected"
  [& _args]
  #_{:clj-kondo/ignore [:unused-value]}
  (for [n (range 4)]
    (do
      (inc n)
      :do-other-work))
  :do-other-work)
