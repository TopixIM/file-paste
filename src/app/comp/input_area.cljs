
(ns app.comp.input-area
  (:require [hsl.core :refer [hsl]]
            [app.schema :as schema]
            [respo-ui.core :as ui]
            [respo.core :refer [defcomp list-> <> span div button input]]
            [respo.comp.space :refer [=<]]
            [app.config :as config]
            [applied-science.js-interop :as j]))

(defcomp
 comp-input-area
 ()
 (div
  {:style ui/row-middle}
  (div
   {:style (merge
            ui/center
            {:position :relative,
             :background-color (hsl 200 80 80),
             :width 120,
             :height 32,
             :color :white,
             :font-family ui/font-fancy,
             :font-size 18})}
   (<> "Pick file")
   (input
    {:class-name "file-input",
     :type "file",
     :style {:position :absolute,
             :top 0,
             :left 0,
             :width "100%",
             :height "100%",
             :opacity 0},
     :on-input (fn [e d! m!] (js/console.log (j/get-in (:event e) [:target :files])))}))
  (=< 8 nil)
  (div
   {:style (merge
            ui/center
            {:width 200, :height 40, :background-color (hsl 0 80 70), :color :white}),
    :tab-index 0,
    :on-paste (fn [e d! m!]
      (let [target (js/document.querySelector ".file-input")]
        (j/assoc! target "files" (j/get-in (:event e) ["clipboardData" "files"]))
        (.dispatchEvent target (js/Event. "input")))),
    :on-drop (fn [e d! m!]
      (js/console.log (j/get-in (:event e) [:dataTransfer :items 0]))
      (.preventDefault (:event e))),
    :on-dragover (fn [e d! m!] (.preventDefault (:event e)))}
   (<> "Paste"))))
