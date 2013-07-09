(ns project-euler)

(def GRID_SIZE 3)

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

(defn bell [field]
  (let [cells (for [x (range GRID_SIZE) y (range GRID_SIZE)] [x y])]
    (reduce random-move field cells)))

(defn unoccupied-count [field]
  (count (filter zero? (flatten field))))

(defn euler-213 []
  )
