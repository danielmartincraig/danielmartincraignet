(ns danielmartincraignet.robot)

(def routine vector)

(defn allocate-next-step-id
  [steps]
  ((fnil inc 0) (:step-id (last steps))))

(defn add-step [steps]
  (let [step-id (allocate-next-step-id steps)]
    (conj steps  {:step-id step-id})))


(defn update-step [steps step-id new-step]
  (assoc-in steps [(dec step-id)] new-step))

