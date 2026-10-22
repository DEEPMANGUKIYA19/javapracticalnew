
import java.util.Scanner;
import java.util.Locale;

public class problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String original = sc.nextLine();
        String keyword = sc.nextLine();

        String trimmed = original.trim();
        String[] words = trimmed.split("\\s+");

        StringBuilder cleaned = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            if (i > 0) {
                cleaned.append(" ");
            }
            cleaned.append(words[i].toLowerCase(Locale.ROOT));
        }

        if (cleaned.length() > 0) {
            cleaned.setCharAt(
                    0,
                    Character.toUpperCase(cleaned.charAt(0)));
        }

        String shortest = words[0].toLowerCase(Locale.ROOT);
        int keywordCount = 0;
        int vowels = 0;

        for (String word : words) {
            String lowerWord = word.toLowerCase(Locale.ROOT);

            if (lowerWord.length() < shortest.length()) {
                shortest = lowerWord;
            }

            if (lowerWord.equals(keyword.toLowerCase(Locale.ROOT))) {
                keywordCount++;
            }
        }

        for (int i = 0; i < original.length(); i++) {
            char ch = Character.toLowerCase(original.charAt(i));

            if (ch == 'a' || ch == 'e' || ch == 'i'
                    || ch == 'o' || ch == 'u') {
                vowels++;
            }
        }

        System.out.println("Sentence: " + cleaned);
        System.out.println("Words: " + words.length);
        System.out.println("Shortest word: " + shortest);
        System.out.println("Keyword count: " + keywordCount);
        System.out.println("Vowels: " + vowels);

        sc.close();
    }
}
