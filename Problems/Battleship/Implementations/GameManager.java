package Implementations;

import java.util.List;
import Enums.CurrentMove;
import Interface.IPlayerStrategy;

public class GameManager {
    private GameBoard gameBoard;
    private CurrentMove currentMove;
    private IPlayerStrategy playerA;
    private IPlayerStrategy playerB;

    public GameManager(GameBoard gameBoard,
            CurrentMove currentMove,
            IPlayerStrategy playerA,
            IPlayerStrategy playerB) {
        this.gameBoard = gameBoard;
        this.currentMove = currentMove;
        this.playerA = playerA;
        this.playerB = playerB;
    }

    public void start() {
        this.arrangeShip();
        while (true) {
            if (currentMove == CurrentMove.PLAYERA) {
                Display.printStr("PLAYER A making the move");
                Display.showBoardForPlayerA(gameBoard);

                Cell target = playerA.playMove();
                while (!Validator.isValidA(target, gameBoard)) {
                    Display.printStr("Invalid Move");
                    target = playerA.playMove();
                }
                this.missileByA(target);
                if (this.checkWin()) {
                    System.out.println("PLAYER A is a winner");
                    break;
                }
                currentMove = CurrentMove.PLAYERB;
            } else {
                Display.printStr("PLAYER B making the move");
                Display.showBoardForPlayerB(gameBoard);

                Cell target = playerB.playMove();
                while (!Validator.isValidB(target, gameBoard)) {
                    Display.printStr("Invalid Move");
                    target = playerB.playMove();
                }
                this.missileByB(target);
                if (this.checkWin()) {
                    System.out.println("PLAYER B is a winner");
                    break;
                }

                currentMove = CurrentMove.PLAYERA;
            }
        }
    }

    private void arrangeShip() {
        Display.printStr("PLAYER A Selecting the arrangement");
        Display.printArrangements();
        int playerAChoice = playerA.selectArrangement();

        Display.printStr("PLAYER B Selecting the arrangement");
        Display.printArrangements();
        int playerBChoice = playerB.selectArrangement();

        gameBoard.assign(playerAChoice, playerBChoice);

        Display.printStr("Both the player has Arranged the ship");
    }

    private void missileByA(Cell target) {
        char current = gameBoard.playerBBoard.get(target.row).get(target.col);
        if (current == 's') {
            gameBoard.playerBBoard.get(target.row).set(target.col, 'x');
            Display.printStr("HIT!");
        } else {
            gameBoard.playerBBoard.get(target.row).set(target.col, 'o');
            Display.printStr("MISS!");
        }
    }

    private void missileByB(Cell target) {
        char current = gameBoard.playerABoard.get(target.row).get(target.col);
        if (current == 's') {
            gameBoard.playerABoard.get(target.row).set(target.col, 'x');
            Display.printStr("HIT!");
        } else {
            gameBoard.playerABoard.get(target.row).set(target.col, 'o');
            Display.printStr("MISS!");
        }
    }

    private boolean checkWin() {
        if (currentMove == CurrentMove.PLAYERA) {
            return allShipsSunk(gameBoard.playerBBoard);
        } else {
            return allShipsSunk(gameBoard.playerABoard);
        }
    }

    private boolean allShipsSunk(List<List<Character>> board) {
        for (List<Character> row : board) {
            for (char c : row) {
                if (c == 's') {
                    return false;
                }
            }
        }
        return true;
    }
}
