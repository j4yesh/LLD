package Interface;

import Implementations.Cell;

public interface IPlayerStrategy {
    Cell playMove();

    int selectArrangement();

    void setUsername(String str);

    String getUsername();
}
