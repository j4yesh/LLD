package Implementations;

import java.util.Scanner;
import Interface.IPlayerStrategy;
import Statics.ShipArrangement;

public class HumanPlayerStrategy implements IPlayerStrategy {
    private Scanner sc = new Scanner(System.in);

    public HumanPlayerStrategy() {
    }

    @Override
    public Cell playMove() {
        System.out.println("Enter the Co-Ordinate : ");
        int row = sc.nextInt();
        int col = sc.nextInt();
        return new Cell(row, col);
    }

    @Override
    public int selectArrangement() {
        System.out.print("Input Arrangement (1-" + ShipArrangement.arrangements.size() + ") : ");
        int n = sc.nextInt();
        return n - 1;
    }
}
