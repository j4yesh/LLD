package Statics;

import java.util.ArrayList;
import java.util.List;

public class ShipArrangement {
    public static int m = 5;
    public static int n = 5;
    public static List<List<List<Character>>> arrangements = new ArrayList<>();

    static {
        arrangements.add(createBoard(new char[][] {
                { 's', 's', 's', '_', '_' },
                { '_', '_', '_', '_', 's' },
                { 's', '_', '_', '_', 's' },
                { 's', '_', 's', 's', '_' },
                { 's', '_', '_', '_', 's' }
        }));

        arrangements.add(createBoard(new char[][] {
                { '_', '_', 's', '_', '_' },
                { 's', '_', 's', '_', 's' },
                { 's', '_', 's', '_', 's' },
                { '_', '_', '_', '_', '_' },
                { 's', 's', '_', 's', 's' }
        }));

        arrangements.add(createBoard(new char[][] {
                { 's', '_', '_', '_', 's' },
                { 's', '_', 's', '_', 's' },
                { 's', '_', 's', '_', '_' },
                { '_', '_', 's', 's', 's' },
                { 's', '_', '_', '_', '_' }
        }));
    }

    private static List<List<Character>> createBoard(char[][] board) {
        List<List<Character>> result = new ArrayList<>();

        for (char[] row : board) {
            List<Character> list = new ArrayList<>();
            for (char cell : row) {
                list.add(cell);
            }
            result.add(list);
        }

        return result;
    }
}
