(ns danielmartincraignet.subs
  (:require
   [re-frame.core :as re-frame]))

(re-frame/reg-sub
 ::steps
 (fn [db]
   (:steps db)))
