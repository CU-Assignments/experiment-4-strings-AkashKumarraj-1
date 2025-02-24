import java.util.List;

public class SuperPower {

    private static final int MOD = 1337;

    // Function to compute (a^b) % mod using modular exponentiation
    private static int powerMod(int a, int b, int mod) {
        int result = 1;
        a %= mod; // Reduce 'a' mod 'mod' first

        while (b > 0) {
            if (b % 2 == 1) {  // If b is odd, multiply result with a
                result = (result * a) % mod;
            }
            a = (a * a) % mod; // Square the base
            b /= 2;
        }
        return result;
    }

    // Function to compute super power using recursion
    private static int superPowHelper(int a, List<Integer> b, int index) {
        if (index < 0) return 1; // Base case: If b is empty, return 1

        int lastDigit = b.get(index); // Get the last digit
        int part1 = powerMod(a, lastDigit, MOD); // Compute (a^lastDigit) % MOD
        int part2 = powerMod(superPowHelper(a, b, index - 1), 10, MOD); // Compute ((a^rest) ^ 10) % MOD

        return (part1 * part2) % MOD;
    }

    public static int superPow(int a, List<Integer> b) {
        return superPowHelper(a, b, b.size() - 1);
    }

    // Main function
    public static void main(String[] args) {
        int a = 2;
        List<Integer> b = List.of(1, 0); // Example: 2^10 mod 1337
        System.out.println("Result: " + superPow(a, b)); // Output: 1024
    }
}
