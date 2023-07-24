import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordChainGame {
    private static final List<Player> players = new ArrayList<>();
    private static final List<Word> wordList = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        run();
    }

    private static void setPlayer() {
        System.out.print("게임에 참가할 인원을 입력해 주세요.");
        int playerCount = sc.nextInt();

        for (int i = 0; i < playerCount; i++) {
            System.out.print("참가자의 이름을 입력하세요.");
            String name = sc.next();
            players.add(new Player(name));
        }
    }

    private static int validateWord(Word targetWord) {
        Word lastWord = wordList.get(targetWord.sequence() - 1);

        return Character.compare(
                lastWord.word().charAt(lastWord.word().length() - 1),
                targetWord.word().charAt(0));
    }

    public static void run() {
        int count = 0;
        setPlayer();

        System.out.println("시작하는 단어는 아버지입니다.");
        wordList.add(new Word(count, "아버지", players.get(0)));
        count++;

        while (true) {
            System.out.printf("%s >> ", players.get(count % players.size()).name());
            String word = sc.next();
            Word newWord = new Word(count, word, players.get(count % players.size()));

            if (validateWord(newWord) != 0) {
                System.out.printf("%s 님이 졌습니다.", newWord.player().name());
                break;
            }

            wordList.add(newWord);
            count++;
        }
    }

}

record Word (
        int sequence,
        String word,
        Player player
){
}

record Player(
        String name
) {
}