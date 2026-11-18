import java.util.Scanner;

public class BotPlayerStrategy implements IPlayerStrategy {
    Randrm Random = new Random();

    Cell playMove() {
        System.out.println("Enter the Co-Ordinate : ");
        int limitRow = ShipArrangement.m;
        int limitCol = ShipArrangement.n;
        int row = random.nextInt(0, limitRow);
        int col = random.nextInt(0, limitCol);

        return new Cell(row, col);
    }

    int selectArrangement() {
        System.out.print("Input Arrangement : ");
        int n = random.nextInt(ShipArrangement.arrangements.size());
        return n;
    }
}
