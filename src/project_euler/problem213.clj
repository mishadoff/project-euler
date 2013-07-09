(ns project-euler)

(def GRID_SIZE 30)

(defn init-field []
  (vec (map vec (repeat GRID_SIZE (repeat GRID_SIZE 1)))))

(defn move [field from to]
  (-> field
      (update-in from dec)
      (update-in to inc)))

(defn wrong-cell? [[x y]]
  (or (< x 0) (>= x GRID_SIZE)
      (< y 0) (>= y GRID_SIZE)))

(defn random-move [field from]
  (let [[x y] from
        cells [[x (inc y)] [x (dec y)] [(inc x) y] [(dec x) y]]
        rand-to (rand-nth (remove wrong-cell? cells))]
    (move field from rand-to)))

(defn who-moves [field]
  (apply concat
          (for [i (range GRID_SIZE) j (range GRID_SIZE)]
            (repeat (get-in field [i j]) [i j]))))

(defn bell [field]
  (let [cells (who-moves field)]
    (reduce random-move field cells)))

(defn experiment []
  (unoccupied-count (first (drop 50 (iterate bell (init-field))))))

(defn unoccupied-count [field]
  (count (filter zero? (flatten field))))

(defn euler-213 [n]
  (double (/ (reduce +' 
                     (for [i (range n)]
                       (experiment)))
             n)))
