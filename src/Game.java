import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Random random = new Random();
        int number = random.nextInt(100);

        Scanner input = new Scanner(System.in);
        int right = 0;
        int select;
        int[] wrong = new int[5];
        boolean isWin = false;
        boolean isError = false;
        System.out.println(number);
        while (right < 5) {
            System.out.print("Enter The Number : ");
            select = input.nextInt();

            if (select < 0 || select > 99) {
                System.out.println("Please Enter Between 0-100...!");
                if (isError) {
                    right++;
                    System.out.println("Too Much Error..." + (5-right));
                } else {
                    isError = true;
                    System.out.println("If You Enter Wrong Again,Your Rights Will Be Executed...");
                }
                continue;
            }
            if (select == number) {
                System.out.println("Congrats,Correct Number..." + number);
                isWin = true;
                break;
            } else {
                System.out.println("Incorrect Number..!");
                if (select > number) {
                    System.out.println("Your Number is Bigger Than Hidden Number...");
                } else {
                    System.out.println("Your Number is Smaller Than Hidden Number...");
                }
                wrong[right++] = select;
                System.out.println("Right : " + (5 - right));
            }
        }
        if (!isWin) {
            System.out.println("You Are Loser...");
            System.out.println("Numbers : " + Arrays.toString(wrong));
        }
    }
}
