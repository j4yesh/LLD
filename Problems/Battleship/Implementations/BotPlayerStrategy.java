import java.util.Scanner;

public class BotPlayerStrategy implements IPlayerStrategy {
    Randrm Random = new Random();
    String username;

    Cell playMove() {
        System.out.println(username + "s turn");
        System.out.println("Enter the Co-Ordinate : ");
        int limitRow = ShipArrangement.m;
        int limitCol = ShipArrangement.n;
        int row = random.nextInt(0, limitRow);
        int col = random.nextInt(0, limitCol);
        System.out.println(username + " Has selected " + row + " " + col);
        return new Cell(row, col);
    }

    int selectArrangement() {
        System.out.print("Input Arrangement : ");
        int n = random.nextInt(ShipArrangement.arrangements.size());
        System.out.println(username + " Has selected " + row + " " + n);
        return n;
    }

    void setUsername(String str) {
        this.username = str;
    }

    String getUsername() {
        return this.username;
    }
}
