import java.util.stream.Stream;

import static java.lang.Math.floor;

public class Main {
    public static int[] solve(String numberString, int amountOfGroups) {

        int[] data = new int[numberString.length() / 6];
        for (int i = 0; i < data.length; i++) {
            data[i] = Integer.parseInt(numberString.substring(0, 6));
            numberString = numberString.substring(6);
        }

        int[] groupSizeCounter = new int[amountOfGroups];
        boolean isDivisible = 999_999 % amountOfGroups == 0;

        for (int num : data) {
            groupSizeCounter[groupIdForEachNumber(num, amountOfGroups, isDivisible)]++;
        }
        return groupSizeCounter;
    }

    public static int groupIdForEachNumber(int number, int amountOfGroups, boolean isDivisible) {
        int id = 0;
        if (isDivisible) {
            for (int i = 0; i < amountOfGroups; i++) {

                if (number < 999_999 / amountOfGroups) {
                    return id;
                } else {
                    number -= 999_999 / amountOfGroups;
                    id++;
                }
            }
        } else {
            int counter = 1;
            int min = 0;
            int max;
            for (int i = 0; i < amountOfGroups; i++) {

                max = (int) (floor(999_999 * Double.valueOf(Double.valueOf(counter) / Double.valueOf(amountOfGroups))) - 1);
                if (number >= min && number <= max) {
                    return id;
                } else {
                    min = max + 1;
                    if(counter == amountOfGroups) {
                        max = 999_999;
                    } else
                    counter++;
                    id++;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("solution here");
        for (int a : solve("012288502300099774402212311249998872375599499998500001", 4)) {
            System.out.println(a + ", ");

        }
    }
}
