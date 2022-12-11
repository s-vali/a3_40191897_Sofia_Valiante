(ns app
  (:require [db])
  (:require [menu])
  (:require [clojure.string :as str])
  (:require [clojure.java.io]))

;Load files to databases
;Function splits each line into vectors, nested vectors, access starts at [0 0 0]
(defn loadData [file]
  (with-open [rdr (clojure.java.io/reader file)]
    (mapv #(clojure.string/split % #"\|") (line-seq rdr))))
;cust.txt
(def vectCust [(loadData "cust.txt")])
;prod.txt
(def vectProd [(loadData "prod.txt")])
;sales.txt
(def vectSales [(loadData "sales.txt")]) ;use vectors as arguments to case functions

(defn -main
  []
  ;Switch case for menu options   
  (menu/displayMenu) ;works
  (def option (read-line))
  (while (not= option "6") ;if put only 6 and not "6", the while loop will not stop
    (flush) ;flush before read-line
    (case option
      "1" (db/displayCustomerTable vectCust) ;each case leads to respective function in db that handles it, structure passed as argument
      "2" (db/displayProductTable vectProd)
      "3" (db/display (get vectSales 0) (get vectCust 0) (get vectProd 0))
      "4" (db/totalValue (get vectSales 0) (get vectCust 0) (get vectProd 0))
      "5" (db/totalCount (get vectSales 0) (get vectProd 0)))
    (if (>= (Integer/parseInt option) 7)
      (println "Incorrect input!"))
    (menu/displayMenu)
    (def option (read-line))) ;end of while
  (println "Good-Bye!") 
  ) ;end of main

;call main function
(-main)