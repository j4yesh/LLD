
public class GameBoard{
    
    public List<List<Character>> playerABoard;
    public List<List<Character>> playerBBoard;

    GameBoard(){

    }

    public void setBoardsDeepClone(
            List<List<Character>> playerABoard,
            List<List<Character>> playerBBoard) {

        this.playerABoard = utils.deepCopy(playerABoard);
        this.playerBBoard = utils.deepCopy(playerBBoard);
    }

    public void assign(int playerAint Idx,playerBIdx){
        this.setBoardsDeepClone(ShipArrangement.arrangements.get(playerAIdx),
        ShipArrangement.arrangements.get(playerBIdx));
    }

}