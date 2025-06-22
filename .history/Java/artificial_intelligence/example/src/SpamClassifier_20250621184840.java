import java.util.*;

public class SpamClassifier {
    private static final Set<String> spamWords = new HashSet<>(Arrays.asList(
        "buy", "cheap", "discount", "win", "free", "offer", "money"
    ));

    public static boolean isSpam(String message) {
        int spamCount = 0;
        String[] words = message.toLowerCase().split("\\W+");

        for (String word: words) {
            if(spamWords.contains(word)) {
                spamCount++;
            }
        }

        dounle spamRatio = (double) spamCount/words.length;
        return spamRatio > 0.2; //threshold
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your message");
        String input = scanner.nextLine();

        if(isSpam(input)) {
            System.out.println("This message is classified as a SPAM.");
        } else {
            System.out.println("This message is NOT spam.")
        }
    }
}