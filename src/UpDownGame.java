import java.util.Scanner;

public class UpDownGame {
    public static void main(String[] args) {
        int num = 50;
        Scanner sc = new Scanner(System.in);

        System.out.println("게임 시작");
        while (true) {
            int userInput = sc.nextInt();

            if (userInput > num)
                System.out.println("DOWN");
            else if (userInput < num)
                System.out.println("UP");
            else
                break;
        }
        System.out.println("정답");
    }
}
