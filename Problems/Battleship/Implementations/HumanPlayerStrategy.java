import java.util.Scanner;

public class HumanPlayerStrategy implements IPlayerStrategy {
    Scanner sc = new Scanner(System.in);

    Cell playMove() {
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
}
