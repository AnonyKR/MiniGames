package pkg;

import java.util.Scanner;

public final class Tools {
    private static Scanner sc = new Scanner(System.in);

    private Tools(){
    }

    public static boolean askYesOrNo(String question) {
        String answer;
        while (true) {
            System.out.print(question);
            answer = sc.nextLine().toLowerCase();
            switch (answer) {
                case "y", "yes":                   
                    return true;
                case "n", "no":
                    return false;
                default:
                    System.out.println("Invalid input. Please try again");
            }
        }
    }
    
    public static double askDouble(String question) {
        while(true) {
            try {
                System.out.print(question);
                return sc.nextDouble();
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again");
            }
        }
    }

    public static int askInt(String question) {
        while (true) {
            double answer = Tools.askDouble(question);
            if (answer - ((int) answer) == 0.0) {
                return (int) answer;
            } else {
                System.out.println("Invalid input. Please try again");
            }
        }
    }
    
    public static int askInt(String question, boolean positive) {
        while (true) {
            double answer = Tools.askDouble(question);
            if (answer - ((int) answer) == 0.0 && answer >= 0.0) {
                return (int) answer;
            } else {
                System.out.println("Invalid input. Please try again");
            }
        }
    }
}
