import java.util.*;

public class ShipArrangement {

    public static ArrayList<ArrayList<ArrayList<Character>>> arrangements = new ArrayList<>();

    static {
        arrangements.add(createBoard(new char[][]{
            {'s', 's', 's', '_', '_'},
            {'_', '_', '_', '_', 's'},
            {'s', '_', '_', '_', 's'},
            {'s', '_', 's', 's', '_'},
            {'s', '_', '_', '_', 's'}
        }));

        arrangements.add(createBoard(new char[][]{
            {'_', '_', 's', '_', '_'},
            {'s', '_', 's', '_', 's'},
            {'s', '_', 's', '_', 's'},
            {'_', '_', '_', '_', '_'},
            {'s', 's', '_', 's', 's'}
        }));

        arrangements.add(createBoard(new char[][]{
            {'s', '_', '_', '_', 's'},
            {'s', '_', 's', '_', 's'},
            {'s', '_', 's', '_', '_'},
            {'_', '_', 's', 's', 's'},
            {'s', '_', '_', '_', '_'}
        }));
    }

    private static ArrayList<ArrayList<Character>> createBoard(char[][] board) {
        ArrayList<ArrayList<Character>> result = new ArrayList<>();

        for (char[] row : board) {
            ArrayList<Character> list = new ArrayList<>();
            for (char cell : row) {
                list.add(cell);
            }
            result.add(list);
        }

        return result;
    }
}