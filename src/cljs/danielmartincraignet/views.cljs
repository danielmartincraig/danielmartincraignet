(ns danielmartincraignet.views
  (:require
   [re-frame.core :as re-frame]
   [danielmartincraignet.subs :as subs]
   [danielmartincraignet.events :as events]
   ))

(defn bio-panel []
  (let [name "Daniel Craig"
        bio "I'm a team player, and a life-long student.  I'm in the transportation industry.  During the day, I use Java and Spring.  In my free time, I learn Clojure and Clojurescript.  I love what I do.  My life is full of happy projects.  This includes home improvement, professional learning, and recently music. Living and loving in Dallas Texas."]
    [:section
     [:h1 name]
     [:p bio]]))

(defn step-panel [step]
  [:p (str step)])

(defn widget-panel []
  (let [steps @(re-frame/subscribe [::subs/steps])]
    [:section
     (into [:section] (map step-panel steps))
     [:button {:onClick #(re-frame/dispatch [::events/add-step steps])} "Add Step"]]))

(let [steps @(re-frame/subscribe [::subs/steps])] steps)

(defn main-panel []
  [:div
   [bio-panel]
   [widget-panel]
   ])
