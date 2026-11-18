import java.util.Scanner;

public class HumanPlayerStrategy implements IPlayerStrategy {
    Scanner sc = new Scanner(System.in);
    String username;

    Cell playMove() {
        System.out.println(username + "s turn");
        System.out.println("Enter the Co-Ordinate : ");
        int row = sc.nextInt();
        int col = sc.nextInt();
        return new Cell(row, col);
    }

    int selectArrangement() {
        System.out.print("Input Arrangement : ");
        int n = sc.nextInt();
        return n;
    }

    void setUsername(String str) {
        this.username = str;
    }

    String getUsername() {
        return this.username;
    }
}
