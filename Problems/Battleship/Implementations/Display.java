package Implementations;

import java.util.List;
import Enums.CurrentMove;
import Statics.ShipArrangement;

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
        showBoard(gameBoard, CurrentMove.PLAYERA, CurrentMove.PLAYERB, "YOUR BOARD (A)", "OPPONENT BOARD (B)");
    }

    public static void showBoardForPlayerB(GameBoard gameBoard) {
        showBoard(gameBoard, CurrentMove.PLAYERB, CurrentMove.PLAYERA, "YOUR BOARD (B)", "OPPONENT BOARD (A)");
    }

    private static void showBoard(GameBoard gameBoard, CurrentMove own, CurrentMove opp, String ownLabel, String oppLabel) {
        System.out.println("     " + ownLabel + "                " + oppLabel);
        System.out.println("   0  1  2  3  4              0  1  2  3  4");
        int rows = gameBoard.getRows();
        int cols = gameBoard.getCols();
        for (int r = 0; r < rows; r++) {
            StringBuilder sb = new StringBuilder();
            sb.append(r).append("  ");
            for (int c = 0; c < cols; c++) {
                sb.append(formatOwnCell(gameBoard.getCell(own, r, c))).append("  ");
            }
            sb.append("         ").append(r).append("  ");
            for (int c = 0; c < cols; c++) {
                sb.append(formatOpponentCell(gameBoard.getCell(opp, r, c))).append("  ");
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
