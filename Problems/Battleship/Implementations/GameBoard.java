package Implementations;

import java.util.List;
import Enums.CurrentMove;
import Statics.ShipArrangement;
import UTILS.utils;

public class GameBoard {
    private List<List<Character>> playerABoard;
    private List<List<Character>> playerBBoard;

    public GameBoard() {
    }

    public void setBoardsDeepClone(
            List<List<Character>> playerABoard,
            List<List<Character>> playerBBoard) {
        this.playerABoard = utils.deepCopy(playerABoard);
        this.playerBBoard = utils.deepCopy(playerBBoard);
    }

    public void assign(int playerAIdx, int playerBIdx) {
        this.setBoardsDeepClone(
            ShipArrangement.arrangements.get(playerAIdx),
            ShipArrangement.arrangements.get(playerBIdx)
        );
    }

    public boolean fireAt(CurrentMove shooter, Cell target) {
        List<List<Character>> targetBoard = (shooter == CurrentMove.PLAYERA) ? playerBBoard : playerABoard;
        char current = targetBoard.get(target.row).get(target.col);
        if (current == 's') {
            targetBoard.get(target.row).set(target.col, 'x');
            return true;
        } else {
            targetBoard.get(target.row).set(target.col, 'o');
            return false;
        }
    }

    public boolean hasPlayerLost(CurrentMove player) {
        List<List<Character>> board = (player == CurrentMove.PLAYERA) ? playerABoard : playerBBoard;
        for (List<Character> row : board) {
            for (char c : row) {
                if (c == 's') {
                    return false;
                }
            }
        }
        return true;
    }

    public char getCell(CurrentMove player, int row, int col) {
        List<List<Character>> board = (player == CurrentMove.PLAYERA) ? playerABoard : playerBBoard;
        return board.get(row).get(col);
    }

    public int getRows() {
        return playerABoard.size();
    }

    public int getCols() {
        return playerABoard.get(0).size();
    }
}
