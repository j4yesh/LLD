package Implementations;

import java.util.Random;
import Interface.IPlayerStrategy;
import Statics.ShipArrangement;

public class BotPlayerStrategy implements IPlayerStrategy {
    private Random random = new Random();

    public BotPlayerStrategy() {
    }

    @Override
    public Cell playMove() {
        int limitRow = ShipArrangement.m;
        int limitCol = ShipArrangement.n;
        int row = random.nextInt(limitRow);
        int col = random.nextInt(limitCol);
        System.out.println("Bot selected (" + row + ", " + col + ")");
        return new Cell(row, col);
    }

    @Override
    public int selectArrangement() {
        int n = random.nextInt(ShipArrangement.arrangements.size());
        System.out.println("Bot selected arrangement ");
        return n;
    }
}
