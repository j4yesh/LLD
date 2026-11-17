import java.util.List;

public class Display {

    public static void printStr(String msg) {
        System.out.println(msg);
    }

    public static void printArrangements() {
        List<List<List<Character>>> arrangements = ShipArrangement.arrangements;
        for (int i = 0; i < arrangements.size(); i++) {
            System.out.println("Arrangement " + (i + 1) + ":");
            printBoard(arrangements.get(i));
            System.out.println();
        }
    }

    public static void showBoardForPlayerA(GameBoard gameBoard) {
        System.out.println("     YOUR BOARD (A)                OPPONENT BOARD (B)");
        System.out.println("   0  1  2  3  4              0  1  2  3  4");
        List<List<Character>> own = gameBoard.playerABoard;
        List<List<Character>> opponent = gameBoard.playerBBoard;
        for (int r = 0; r < own.size(); r++) {
            StringBuilder sb = new StringBuilder();
            sb.append(r).append("  ");
            for (int c = 0; c < own.get(r).size(); c++) {
                sb.append(formatOwnCell(own.get(r).get(c))).append("  ");
            }
            sb.append("         ").append(r).append("  ");
            for (int c = 0; c < opponent.get(r).size(); c++) {
                sb.append(formatOpponentCell(opponent.get(r).get(c))).append("  ");
            }
            System.out.println(sb.toString());
        }
    }

    public static void showBoardForPlayerB(GameBoard gameBoard) {
        System.out.println("     YOUR BOARD (B)                OPPONENT BOARD (A)");
        System.out.println("   0  1  2  3  4              0  1  2  3  4");
        List<List<Character>> own = gameBoard.playerBBoard;
        List<List<Character>> opponent = gameBoard.playerABoard;
        for (int r = 0; r < own.size(); r++) {
            StringBuilder sb = new StringBuilder();
            sb.append(r).append("  ");
            for (int c = 0; c < own.get(r).size(); c++) {
                sb.append(formatOwnCell(own.get(r).get(c))).append("  ");
            }
            sb.append("         ").append(r).append("  ");
            for (int c = 0; c < opponent.get(r).size(); c++) {
                sb.append(formatOpponentCell(opponent.get(r).get(c))).append("  ");
            }
            System.out.println(sb.toString());
        }
    }

    private static char formatOwnCell(char c) {
        if (c == 's') return 'S';
        if (c == 'x') return 'X';
        if (c == 'o') return 'O';
        return '~';
    }

    private static char formatOpponentCell(char c) {
        if (c == 'x') return 'X';
        if (c == 'o') return 'O';
        return '~';
    }

    private static void printBoard(List<List<Character>> board) {
        System.out.print("   ");
        for (int c = 0; c < board.get(0).size(); c++) {
            System.out.print(c + "  ");
        }
        System.out.println();
        for (int r = 0; r < board.size(); r++) {
            System.out.print(r + "  ");
            for (int c = 0; c < board.get(r).size(); c++) {
                System.out.print(board.get(r).get(c) + "  ");
            }
            System.out.println();
        }
    }
}
