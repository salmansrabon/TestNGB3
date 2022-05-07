import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.print("Press Enter: ");

        int number = 1000;
        int sum = 0;

        for (int count = 1; count <= number; count++) {
            Scanner sc = new Scanner(System.in);
            sc.nextLine();
            System.out.println(count);
        }

    }
}
