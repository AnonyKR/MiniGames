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

    public static boolean askYesOrNo(String question, String error) {
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
                    System.out.println(error);
            }
        }
    }
    
    public static double askDouble(String question) {
        while(true) {
            try {
                System.out.print(question);
                double temp = sc.nextDouble();
                sc.nextLine();
                return temp;
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again");
            }
        }
    }

    public static double askDouble(String question, String error) {
        while(true) {
            try {
                System.out.print(question);
                double temp = sc.nextDouble();
                sc.nextLine();
                return temp;
            } catch (Exception e) {
                System.out.println(error);
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

    public static int askInt(String question, String error) {
        while (true) {
            double answer = Tools.askDouble(question);
            if (answer - ((int) answer) == 0.0) {
                return (int) answer;
            } else {
                System.out.println(error);
            }
        }
    }
    
    public static int askInt(String question, boolean positive) {
        while (true) {
            double answer = Tools.askDouble(question);
            if (answer - ((int) answer) == 0.0 && (answer > 0.0) == positive) {
                return (int) answer;
            } else {
                System.out.println("Invalid input. Please try again");
            }
        }
    }

    public static int askInt(String question, boolean positive, String error) {
        while (true) {
            double answer = Tools.askDouble(question);
            if (answer - ((int) answer) == 0.0 && (answer > 0.0) == positive) {
                return (int) answer;
            } else {
                System.out.println(error);
            }
        }
    }

    public static int askInt(String question, int max) {
        while (true) {
            double answer = Tools.askDouble(question);
            if (answer - ((int) answer) == 0.0 && answer < max) {
                return (int) answer;
            } else {
                System.out.println("Invalid input. Please try again");
            }
        }
    }

    public static int askOptions(String introQuestion, String[] questions) {
        while (true) { 
            try {
                System.out.println(introQuestion);
                for(int i = 0; i < questions.length; i++) {
                    System.out.println((i + 1)  + ": " + questions[i]);
                    System.err.print(">> ");
                    int response = sc.nextInt();
                    if (response > 0 && response < questions.length + 1) {
                        return response;
                    }
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again");
            }
        }
    }

    public static int askOptions(String introQuestion, String[] questions, String error) {
        while (true) { 
            try {
                System.out.println(introQuestion);
                for(int i = 0; i < questions.length; i++) {
                    System.out.println((i + 1)  + ": " + questions[i]);
                    System.err.print(">> ");
                    int response = sc.nextInt();
                    if (response > 0 && response < questions.length + 1) {
                        return response;
                    }
                }
            } catch (Exception e) {
                System.out.println(error);
            }
        }
    }
}
