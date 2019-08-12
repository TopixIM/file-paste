
(ns app.comp.portal
  (:require [hsl.core :refer [hsl]]
            [app.schema :as schema]
            [respo-ui.core :as ui]
            [respo.core :refer [defcomp list-> <> span div button]]
            [respo.comp.space :refer [=<]]
            [app.config :as config]
            [app.comp.input-area :refer [comp-input-area]]))

(defcomp comp-portal () (div {:style {:padding "16px"}} (comp-input-area)))
