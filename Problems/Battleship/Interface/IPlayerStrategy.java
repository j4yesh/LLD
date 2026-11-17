import Implementations.cell;

public interface IPlayerStrategy {
    public String username;
    private IPlayerStrategy opponent;
    public cell playMove();
    public int selectArrangement();        
}