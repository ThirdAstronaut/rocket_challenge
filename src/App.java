import java.util.Arrays;
import java.util.Collections;

class App {
    public static int rearrange(int n) {
        int size = String.valueOf(n).length();
        int[] digits = new int[size];
        for (int i = 0; i < size; i++) {
            digits[i] = n%10;
            n /= 10;
        }
        Arrays.sort(digits);
        StringBuilder outputStr = new StringBuilder();
        for (int i = digits.length - 1; i >= 0 ; i--) {
            outputStr.append(digits[i]);

        }

        return Integer.parseInt(outputStr.toString());
    }

    public static void main(String[] args) {
        System.out.println(rearrange(831721));
    }
}