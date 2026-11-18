import Implementations.GameBoard;
import Implementations.GameManager;
import Implementations.HumanPlayerStrategy;
import Implementations.BotPlayerStrategy;
import Enums.CurrentMove;
import Interface.IPlayerStrategy;

public class BattleShipGame {
    public static void main(String[] args) {
        GameBoard gameBoard = new GameBoard();
        CurrentMove currentMove = CurrentMove.PLAYERA;
        IPlayerStrategy playerA = new HumanPlayerStrategy();
        IPlayerStrategy playerB = new BotPlayerStrategy();
        GameManager gameManager = new GameManager(
                gameBoard,
                currentMove,
                playerA,
                playerB);
        gameManager.start();
    }
}
