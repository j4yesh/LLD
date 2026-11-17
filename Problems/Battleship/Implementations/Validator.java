import java.util.List;

public class Validator {

    public static boolean isValidA(Cell target, GameBoard gameBoard) {
        return isValid(target, gameBoard.playerBBoard);
    }

    public static boolean isValidB(Cell target, GameBoard gameBoard) {
        return isValid(target, gameBoard.playerABoard);
    }

    private static boolean isValid(Cell target, List<List<Character>> board) {
        int rows = board.size();
        int cols = board.get(0).size();
        if (target.row < 0 || target.row >= rows || target.col < 0 || target.col >= cols) {
            return false;
        }
        char c = board.get(target.row).get(target.col);
        if (c == 'x' || c == 'o') {
            return false;
        }
        return true;
    }
}
