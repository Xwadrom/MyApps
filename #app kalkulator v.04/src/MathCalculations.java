import java.util.InputMismatchException;
import java.util.Scanner;

public class MathCalculations {
    public static double giveNumber(double digit, boolean error, Scanner scanner1) {
        do {
            try {
                digit = scanner1.nextDouble();
                error = false;
                System.out.println("Wczytana liczba to: " + digit);
                scanner1.nextLine();
            } catch (InputMismatchException ex) {
                System.err.println("Nie podałes liczby spróbuj jeszcze raz:");
                scanner1.nextLine();
            }
        } while (error);
        return digit;
    }

    static void mathOperands(double a, double b, boolean error2, Scanner scanner1) {
        String operator;
        do {
            System.out.println("Podaj znak operacji matematycznej +, -, *, / :");
            operator = scanner1.nextLine();
            switch (operator) {

                case "+":
                    double sum = a + b;
                    System.out.println("Twoj wynik dodawania to: " + sum);
                    System.out.println();
                    error2 = false;
                    break;
                case "-":
                    double minus = a - b;
                    System.out.println("Twoj wynik odejmowania to: " + minus);
                    System.out.println();
                    error2 = false;
                    break;
                case "*":
                    double mnozenie = a * b;
                    System.out.println("Twoj wynik mnozenia to: " + mnozenie);
                    System.out.println();
                    error2 = false;
                    break;
                case "/":
                    try {
                        double dzielenie = a / b;
                        if (dzielenie == Double.POSITIVE_INFINITY ||
                                dzielenie == Double.NEGATIVE_INFINITY)
                            throw new ArithmeticException();
                        System.out.println("Twoj wynik dzielenia to: " + dzielenie);
                        System.out.println();
                        error2 = false;
                    } catch (ArithmeticException ex) {
                        System.err.println("Uwaga nie można dzielić przez 0.");

                    }
                    break;
                default:
                    try {
                        throw new UnknownOperatorException("Nieznana operacja");

                    } catch (UnknownOperatorException ex) {
                        System.out.println();
                        System.err.println("Wybrałeś zły znak działania, dostepne znaki to: +, -, *, /.");
                    }
            }
        } while (error2);
    }
}
