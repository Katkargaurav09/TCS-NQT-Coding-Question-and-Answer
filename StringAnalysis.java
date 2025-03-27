import java.util.*;

public class StringAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String input = scanner.nextLine();
        scanner.close();

        Character firstNonRepeating = getFirstNonRepeating(input);
        Character mostRepeated = getMostRepeated(input);

        System.out.println("First non-repeating character: " + (firstNonRepeating != null ? firstNonRepeating : "None"));
        System.out.println("Most repeated character: " + (mostRepeated != null ? mostRepeated : "None"));
    }

    private static Character getFirstNonRepeating(String str) {
        LinkedHashMap<Character, Integer> countMap = new LinkedHashMap<>();

        for (char c : str.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return null;
    }

    private static Character getMostRepeated(String str) {
        Map<Character, Integer> countMap = new HashMap<>();

        for (char c : str.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        char mostRepeatedChar = 0;
        int maxCount = 0;

        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostRepeatedChar = entry.getKey();
            }
        }

        return mostRepeatedChar != 0 ? mostRepeatedChar : null;
    }
}
