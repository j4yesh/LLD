package Implementations;

import java.util.List;
import Statics.ShipArrangement;
import UTILS.utils;

public class GameBoard {
    
    public List<List<Character>> playerABoard;
    public List<List<Character>> playerBBoard;

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
}
