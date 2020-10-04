(ns danielmartincraignet.events
  (:require
   [re-frame.core :as re-frame]
   [danielmartincraignet.db :as db]
   [day8.re-frame.tracing :refer-macros [fn-traced]]
   [danielmartincraignet.robot :as robot]))

(def step-interceptors [(re-frame.core/path :steps)])

(re-frame/reg-event-db
 ::initialize-db
 (fn-traced [_ _] db/default-db))

(re-frame/reg-event-db
 ::add-step step-interceptors (fn-traced  [steps _]
                                          (re-frame.core/console :log (str "::add-step got: " steps))
                                          (robot/add-step steps)))

(re-frame/reg-event-db
 ::update-step step-interceptors (fn-traced [steps [_ step-id new-step]]
                                            (robot/update-step steps step-id new-step)))

