(ns Main
  (:gen-class))

(defn sum-every-n [n numbers]
  "Sums every n elements in the given sequence."
  (when-let [seq-numbers (seq numbers)]
    (let [current-sum (reduce + (take n seq-numbers))]
      ;; Create a lazy sequence recursively by summing every n elements.
      (lazy-seq (cons current-sum (sum-every-n n (drop n seq-numbers)))))))

(defn -main [& args]
  "Entry point of the program."
  (let [input-sequence [1 2 3 4 5 6 7 8 9 10 11 12 13 14 15]
        result (take 5 (sum-every-n 3 input-sequence))]
    ;; Print the result.
    (println "Result:" result)))

(-main)
