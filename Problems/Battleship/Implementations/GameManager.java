
public class GameManager {
    private GameBoard gameBoard;
    private CurrentMove currentMove;
    private IPlayerStrategy playerA;
    private IPlayerStrategy playerB;

    GameManager(GameBoard gameBoard,
            CurrentMove currentMove,
            IPlayerStrategy playerA,
            IPlayerStrategy playerB) {
        this.gameBoard = gameBoard;
        this.currentMove = currentMove;
        this.playerA = playerA;
        thils.playerB = playerB;

    }

    public void start() {
        this.arrangeShip();
        while (true) {
            if (currentMove == CurrentMove.PLAYERA) {
                Display.printStr("PLAYER A making the move");
                Display.showBoardForPlayerA();

                cell target = playerA.playMove();
                while (!Validator.isValidA(target, board)) {
                    Display.printStr("Invalid Move");
                    target = playerA.playMove();
                }
                this.MissileByA(cell);
                if (this.checkWin()) {
                    System.out.println("PLAYER A is a winner");
                }
                currentMove = CurrentMove.PLAYERB;
            } else {
                Display.printStr("PLAYER B making the move");
                Display.showBoardForPlayerB();

                cell target = playerB.playMove();
                while (!Validator.isValidB(target, board)) {
                    Display.printStr("Invalid Move");
                    target = playerB.playMove();
                }
                this.MissileByB(cell);
                if (this.checkWin()) {
                    System.out.println("PLAYER B is a winner");
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

    private void checkWin() {

    }

}