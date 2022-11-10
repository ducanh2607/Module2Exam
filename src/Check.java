import java.util.Scanner;
import java.util.regex.Pattern;

public class Check {
    private Pattern pattern;

    public Check() {
    }

    public int checkInt(Scanner scanner, String target) {
        int number;
        pattern = Pattern.compile("[0-9]*");
        while (true) {
            System.out.println("Enter the " + target + ":");
            String inStr = scanner.nextLine();
            if (pattern.matcher(inStr).matches() & inStr != "") {
                number = Integer.parseInt(inStr);
                break;
            } else {
                System.err.println(target + " must be number, please re-enter.");
            }
        }
        return number;
    }

    public String checkString(Scanner scanner, String target) {
        String inStr;
        String str = null;
        pattern = Pattern.compile("[a-zA-z]*");
        while (true) {
            System.out.println("Enter the " + target + ":");
            inStr = scanner.nextLine();
            if (pattern.matcher(inStr).matches() & !inStr.equals("")) {
                str = inStr;
                break;
            } else {
                System.err.println(target + "must be word or number, please re-enter.");
            }
        }
        return str;
    }
    public String checkStringId(Scanner scanner, String target) {
        String inStr;
        String str = null;
        pattern = Pattern.compile("[a-zA-z0-9]*");
        while (true) {
            System.out.println("Enter the " + target + ":");
            inStr = scanner.nextLine();
            if (pattern.matcher(inStr).matches() & !inStr.equals("")) {
                str = inStr;
                break;
            } else {
                System.err.println(target + "must be word or number, please re-enter.");
            }
        }
        return str;
    }

    public double checkDouble(Scanner scanner, String target) {
        pattern = Pattern.compile("(\\-?\\d*\\.?\\d+)");
        double num;
        while (true) {
            System.out.println("Enter the " + target + ":");
            String inStr = scanner.nextLine();
            if (pattern.matcher(inStr).matches() & inStr != "") {
                num = Double.parseDouble(inStr);
                break;
            } else {
                System.err.println(target + " must be float or number, please re-enter.");
            }
        }
        return num;

    }}
