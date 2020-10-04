(ns danielmartincraignet.robot)

(def routine vector)

(defn add-step [steps]
  (re-frame.core/console :log (str "add-step got: " steps))
  (conj steps  "Daniel")
  )

(defn update-step [steps step-id new-step]
  (assoc-in steps [(dec step-id)] new-step))

(comment
  (conj (conj () {:name "Daniel"}) "Daniel"))
