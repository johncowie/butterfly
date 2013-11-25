(ns butterfly.main
  (:require [butterfly.d3 :refer [svg! rect! circle!]]))

;; GAME OF LIFE

(def width 40)
(def height 30)
(def sq-size 20)


(def main-svg (svg! "body" (* width sq-size) (* height sq-size)))

(rand-int 256)

(defn random-colour []
  (str "#" (apply str (map #(. % toString 16) [(rand-int 256) (rand-int 256) (rand-int 256)]))))

(def canvas
  (doseq [j (range 0 height)]
    (doseq [i (range 0 width)]
      {:element (rect! main-svg {:x (* i sq-size)
                                 :y (* j sq-size)
                                 :width sq-size
                                 :height sq-size
                                 :fill (random-colour)})
       :alive true
       }
      )
    )
  )

;(rect! main {:x 50 :y 50 :width 200 :height 200 :fill "#00f"})
;(circle! main {:cx 130 :cy 130 :r 50 :fill "#0f0"})
