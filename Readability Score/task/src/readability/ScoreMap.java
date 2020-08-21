package readability;

import java.util.HashMap;

class ScoreMap {
    private HashMap<Integer, Integer> scoreMap = new HashMap<>();

    ScoreMap() {
        fillMap();
    }

    private void fillMap() {
        scoreMap.put(1, 6);
        scoreMap.put(2, 7);
        scoreMap.put(3, 9);
        scoreMap.put(4, 10);
        scoreMap.put(5, 11);
        scoreMap.put(6, 12);
        scoreMap.put(7, 13);
        scoreMap.put(8, 14);
        scoreMap.put(9, 15);
        scoreMap.put(10, 16);
        scoreMap.put(11, 17);
        scoreMap.put(12, 18);
        scoreMap.put(13, 24);
        scoreMap.put(14, 25);
    }

    int getAge(int key) {
        return scoreMap.get(key);
    }
}
