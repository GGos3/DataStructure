import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class AlphaHistogram {

    private final Scanner sc = new Scanner(System.in);
    private final Map<Integer, Integer> countMap = new HashMap<>();

    public static void main(String[] args) {
        AlphaHistogram app = new AlphaHistogram();
        app.run();
    }

    void run() {
        try {
            while (true) {
                countAlphaMatch(userInput());
                printAlpha();
            }
        } catch (NoSuchElementException e) {
            System.err.println("EOF 문자가 감지되어 프로그램을 종료합니다.");
            System.out.println("Good Bye!!");
        }
    }

    String userInput() {
        System.out.println("문장을 입력해주세요.");
        return sc.nextLine();
    }

    int matchCount(String userInput, int target) {
        return (int) userInput.toLowerCase().chars()
                .filter(ch -> ch == target)
                .count();
    }

    void countAlphaMatch(String userInput) {
        IntStream.range(97, 122).forEach(alpha ->
            countMap.put(
                    alpha,
                    matchCount(userInput, alpha)
            )
        );
    }

    void printAlpha() {
        countMap.forEach((alpha, count) -> {
            System.out.printf("%c", (char) alpha.intValue());
            IntStream.range(0, count).forEach(it -> System.out.print("-"));
            System.out.println();
        });
    }
}
