import java.util.HashSet;

public class LongestNiceSubstring {

    public static String longestNiceSubstring(String s) {
        if (s.length() < 2) return "";

        HashSet<Character> charSet = new HashSet<>();
        for (char ch : s.toCharArray()) {
            charSet.add(ch);
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If one case exists but not the other, split and check recursively
            if (!charSet.contains(Character.toLowerCase(ch)) || !charSet.contains(Character.toUpperCase(ch))) {
                String left = longestNiceSubstring(s.substring(0, i));
                String right = longestNiceSubstring(s.substring(i + 1));

                return left.length() >= right.length() ? left : right;
            }
        }
        return s; // If the whole string is nice
    }

    public static void main(String[] args) {
        String s = "YazaAay";
        System.out.println("Longest Nice Substring: " + longestNiceSubstring(s)); // Output: "aAa"
    }
}
