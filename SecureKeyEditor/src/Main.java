import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static String key;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        key = scanner.nextLine();

        String regex = "^[A-Za-z0-9_]{6,20}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(key);

        if (!matcher.matches()) {
            System.out.println("Invalid initial key!");
            return;
        }

        String command;
        while (!(command = scanner.nextLine()).equals("Finalize")) {
            String[] tokens = command.split(":::");
            String action = tokens[0];

            switch (action) {
                case "Check":
                    check(tokens[1]);
                    break;
                case "Change":
                    change(tokens[1], Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
                    break;
                case "Remove":
                    remove(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                    break;
                case "Insert":
                    insert(Integer.parseInt(tokens[1]), tokens[2]);
                    break;
                case "Replace":
                    replace(tokens[1], tokens[2]);
                    break;
                case "Reverse":
                    reverse(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                    break;
            }
        }
        System.out.printf("Your final security key is: %s%n", key);
    }

    private static void check(String substring) {
        if (key.contains(substring)) {
            System.out.printf("%s contains %s%n", key, substring);
        } else {
            System.out.println("Substring not found!");
        }
    }

    private static void change(String state, int firstIndex, int secondIndex) {
        String before = key.substring(0, firstIndex);
        String toChange = key.substring(firstIndex, secondIndex);
        String finall = key.substring(secondIndex);

        if (state.equals("Upper")) {
            toChange = toChange.toUpperCase();
        } else if (state.equals("Lower")) {
            toChange = toChange.toLowerCase();
        }

        key = before + toChange + finall;
        System.out.println(key);
    }

    private static void remove(int firstIndex, int secondIndex) {
        key = key.substring(0, firstIndex) + key.substring(secondIndex);
        System.out.println(key);
    }

    private static void insert(int index, String text) {
        String before = key.substring(0, index);
        String after = key.substring(index);

        key = before + text + after;
        System.out.println(key);
    }

    private static void replace(String oldSubstring, String newSubstring) {
        if (key.contains(oldSubstring)) {
            key = key.replace(oldSubstring, newSubstring);
            System.out.println(key);
        } else {
            System.out.println("Nothing to replace!");
        }
    }

    private static void reverse(int firstIndex, int secondIndex) {
        String prefix = key.substring(0, firstIndex);
        String toChange = key.substring(firstIndex, secondIndex);
        String suffix = key.substring(secondIndex);

        String reversed = new StringBuilder(toChange).reverse().toString();
        key = prefix + reversed + suffix;
        System.out.println(key);
    }
}
