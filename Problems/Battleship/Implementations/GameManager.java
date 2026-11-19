package Implementations;

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

                boolean hit = gameBoard.fireAt(CurrentMove.PLAYERA, target);
                Display.printStr(hit ? "HIT!" : "MISS!");

                if (gameBoard.hasPlayerLost(CurrentMove.PLAYERB)) {
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

                boolean hit = gameBoard.fireAt(CurrentMove.PLAYERB, target);
                Display.printStr(hit ? "HIT!" : "MISS!");

                if (gameBoard.hasPlayerLost(CurrentMove.PLAYERA)) {
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
}
