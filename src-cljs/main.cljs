(ns butterfly.main)

(defn ^:export greet [n]
  (js/alert (str "Hello " n)))

(defn attrs [e m]
  (if (empty? m)
    e
    (let [p (first m)]
      (attrs (. e attr (name (first p)) (second p)) (rest m)))))

(defn style [e m]
  (if (empty? m)
    e
    (let [p (first m)]
      (style (. e style (name (first p)) (second p)) (rest m)))))

(defn svg [parent w h]
  (attrs (. (d3/select parent) append "svg") {:width w :height h}))

(defn rect [parent-svg m]
  (attrs (. parent-svg append "rect") m))

(defn circle [parent-svg m]
  (attrs (. parent-svg append "circle") m))

(def main (svg "body" 800 600))

(rect main {:x 50 :y 50 :width 200 :height 200 :fill "#f00"})
(circle main {:cx 130 :cy 130 :r 50 :fill "#0f0"})
