
class BattleShipGame {
    public static void main(String[] jayesh) {
        GameBoard gameBoard = new GameBoard();
        CurrentMove currentMove = CurrentMove.PLAYERA;
        IPlayerStrategy playerA = new HumanPlayerStrategy();
        playerA.setUsername("You");
        playerB.setUsername("BOT");
        GameManager gameManager = new GameManager(
                gameBoard,
                currentMove,
                playerA,
                playerB);
    }
}