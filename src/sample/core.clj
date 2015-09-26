(ns sample.core
  (:gen-class))

(use 'jsoup.soup)

(defn wont-be-lean []
  (str "foo" "bar"))

(defn foo
  "I don't do a whole lot."
  [x]
  (println "Hello, World!" x)
  (println (wont-be-lean))
;;  (let [c (a/chan)]
;;    (a/put! c x)
;;    (a/go (println "Ultimate answer is" (a/<! c))))
  )

(defn -main [& args]
  (println "started")
  (if args
    (System/exit 0)
      (println ($ (get! "http://google.com" :user-agent "CoCo/1.0")
           td "a[href]"
             (attr "abs:href"))))



     )
