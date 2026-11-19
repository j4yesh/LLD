package Implementations;

import Enums.CurrentMove;

public class Validator {

    public static boolean isValidA(Cell target, GameBoard gameBoard) {
        return isValid(target, gameBoard, CurrentMove.PLAYERB);
    }

    public static boolean isValidB(Cell target, GameBoard gameBoard) {
        return isValid(target, gameBoard, CurrentMove.PLAYERA);
    }

    private static boolean isValid(Cell target, GameBoard gameBoard, CurrentMove targetPlayer) {
        if (target == null) {
            return false;
        }

        if (target.row < 0 || target.row >= gameBoard.getRows() || target.col < 0 || target.col >= gameBoard.getCols()) {
            return false;
        }

        char c = gameBoard.getCell(targetPlayer, target.row, target.col);
        return c != 'x' && c != 'o';
    }
}
