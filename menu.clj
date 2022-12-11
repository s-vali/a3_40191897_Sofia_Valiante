(ns menu)

;Method to display the interface of the menu
(defn displayMenu [] 
  (println "\n*** Sales Menu***")
  (println "------------------")
  (println "1. Display Customer Table")
  (println "2. Display Product Table")
  (println "3. Display Sales Table")
  (println "4. Total Sales for Customer")
  (println "5. Total Count for Product")
  (println "6. Exit")
  (print "\nEnter an option? ")
  (flush)
  )

(def var 1)
