package com.company;

import java.security.SecureRandom;
import java.util.Scanner;

public class Main {
    private static Scanner scnr = new Scanner(System.in);
    private static SecureRandom random = new SecureRandom();

    public static void main(String[] args) {
        while(true) {
            System.out.printf("Enter 0 in either of the following prompts to exit.%nWe have four (4) difficulty levels: " +
                    "%n1: One (1) digit%n2: Two (2) digits%n3: Three (3) digits%n4: Four (4) digits%n");
            System.out.printf("Enter the level you want to do: ");
            int difficultyLevel = scnr.nextInt();
            if (difficultyLevel == 0) {
                break;
            }
            System.out.printf(
                    "You can choose from the following problem types:%n 1: addition" +
                            " problems only%n 2: subtraction problems only%n 3: multiplication problems" +
                            " only%n 4: division problems only%n 5: random mixture%n");
            System.out.printf("Enter the problem type you want to do: ");
            int problemType = scnr.nextInt();
            System.out.println("");
            if (problemType == 0) {
                break;
            }
            float percentageCorrect = tenProblems(difficultyLevel, problemType);
            if (percentageCorrect >= 0.75) {
                System.out.println("Congratulations, you are ready to go to the next level!");
            } else {
                System.out.println();
                System.out.println("Please ask your teacher for extra help.");
            }
            System.out.println("");
        }
    }

    public static float tenProblems(int difficultyLevel, int problemType) {
        int first, second, problemTypeInstance;
        boolean result;
        int totalCorrect = 0;
        for (int i = 0; i < 10; i++){
            first = getRandom(difficultyLevel);
            second = getRandom(difficultyLevel);
            if (problemType == 5){
                problemTypeInstance = random.nextInt(3) + 1;
            } else {
                problemTypeInstance = problemType;
            }
            result = printGetAndCompare(first, second, problemTypeInstance);
            if (result) {
                totalCorrect += 1;
            }
            while(result == false) {
                result = printGetAndCompare(first, second, problemTypeInstance);
            }
        }
        return totalCorrect / 10.0f;
    }

    public static int getRandom(int difficulty) {
        String limitString = "";
        for (int i = 0; i < difficulty; i++) {
            limitString += "9";
        }
        return random.nextInt(Integer.parseInt(limitString)) + 1;
    }

    public static boolean printGetAndCompare(int first, int second, int
            problemTypeInstance){
        int correctAnswer, userAnswer;
        boolean result;
        correctAnswer = printProblem(first, second, problemTypeInstance);
        userAnswer = scnr.nextInt();
        result = compareAnswer(userAnswer, correctAnswer);
        System.out.println(generateComment(result));
        System.out.println("");
        return result;
    }

    public static int printProblem(int first, int second, int problemType) {
        int correctAnswer;
        if (problemType == 1) {
            System.out.printf("%d plus %d= ", first, second);
            correctAnswer = addition(first, second);
        } else if (problemType == 2) {
            System.out.printf("%d minus %d = ", first, second);
            correctAnswer = subtraction(first, second);
        } else if (problemType == 3) {
            System.out.printf("%d multiplied by %d= ", first, second);
            correctAnswer = multiplication(first, second);
        } else {
            System.out.printf("%d divided by %d = ", first, second);
            correctAnswer = division(first, second);
        }
        return correctAnswer;
    }

    public static String generateComment(boolean answerCorrect){
        int numAnswer = random.nextInt(3);
        String[] correctResponses = {"Very good!","Excellent!","Nice work!", "Keep up the " +
                "good work!"};
        String[] wrongResponses = { "No. Please try again.", "Wrong. Try once more.",
                "Don't give up!", "No. Keep trying."};
        if (answerCorrect){
            return correctResponses[numAnswer];
        } else {
            return wrongResponses[numAnswer];
        }
    }

    public static int multiplication(int first, int second) {
        return first * second;
    }

    public static int subtraction(int first, int second) {
        return first - second;
    }

    public static int addition(int first, int second) {
        return first + second;
    }

    public static int division(int first, int second) {
        return first / second;
    }

    public static boolean compareAnswer(int userAnswer, int correctAnswer) {
        if (correctAnswer == userAnswer) {
            return true;
        } else {
            return false;
        }
    }
}
