import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
*
* Commands:

1. Check:::{substring}
If the key contains the substring, print:
"{key} contains {substring}"
Otherwise:
"Substring not found!"

2. Change:::Upper/Lower:::{startIndex}:::{endIndex}
Change the substring between the given indices (endIndex is exclusive) to upper or lower case.
Print the new key.

3. Remove:::{startIndex}:::{endIndex}
Remove the substring between the given indices (endIndex is exclusive).
Print the new key.

4. Insert:::{index}:::{text}
Insert the given text at the specified index.
Print the new key.
5. Replace:::{oldSubstring}:::{newSubstring}
Replace all occurrences of oldSubstring with newSubstring.
If nothing was replaced, print:
"Nothing to replace!"
Otherwise, print the new key.
6. Reverse:::{startIndex}:::{endIndex}
Reverse the substring between the given indices (endIndex is exclusive) and place it back in the same position.
Print the new key.
Input:
The first line contains the initial security key.
Each next line contains a command.
The sequence ends with the command:
"Finalize"
Output:
If the key is invalid, print:
"Invalid initial key!"
and stop.
Otherwise, after processing all commands, print:
"Your final security key is: {key}"


*/

 

public class Main {

    private static String key;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        key = scanner.nextLine();

        String command = null;

        String regex = "^[A-Za-z0-9_]{6,20}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(key);

        if(!matcher.matches()) {
            System.out.println("Invalid initial key!");
            return;
        }

        while((command = scanner.nextLine())!="Finalize") {
            String[] tokens = command.split(":::");
            String action = tokens[0];

            switch (action) {

                case"Check":
                    String substring = tokens[1];
                    check(substring);
                    break;

                case"Change":
                    String state = tokens[1];
                    Integer firstIndex = Integer.parseInt(tokens[2]);
                    Integer secondIndex = Integer.parseInt(tokens[3]);
                    change(state,firstIndex,secondIndex);
                    break;

                case"Remove":
                     firstIndex = Integer.parseInt(tokens[1]);
                     secondIndex = Integer.parseInt(tokens[2]);
                     remove(firstIndex,secondIndex);
                    break;
            }
        }
    }

    private static void check(String substring) {
        if(key.contains(substring)) {
            System.out.printf("%s contains %s%n",key,substring);
        } else {
            System.out.println("Substring not found!");
        }
    }

    private static void change(String state, Integer firstIndex, Integer secondIndex) {
        String before = key.substring(0,firstIndex);
        String toChange = key.substring(firstIndex,secondIndex);
        String finall = key.substring(secondIndex);

        if(state=="Upper") {
            toChange = toChange.toUpperCase();
        } else if(state=="Lower") {
            toChange = toChange.toLowerCase();
        }

        String result = before+toChange+finall;
        key = result;
        System.out.println(key);
    }

    private static void remove(Integer firstIndex, Integer secondIndex) {
        key = key.substring(0,firstIndex)+key.substring(secondIndex);
        System.out.println(key);
    }
}