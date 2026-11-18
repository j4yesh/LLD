package UTILS;

import java.util.ArrayList;
import java.util.List;

public class utils {
    public static List<List<Character>> deepCopy(List<List<Character>> board) {
        List<List<Character>> copy = new ArrayList<>();
        for (List<Character> row : board) {
            copy.add(new ArrayList<>(row));
        }
        return copy;
    }
}
