import java.util.InputMismatchException;
import java.util.Scanner;

import Shapes.*;

public class CalcDigits {//implements Patterns

    public static void main(String[] args) {
        double a = 0;
        int option = 99;
        double b = 0;
        double c = 0;
        boolean error = true;
        boolean error2 = true;
        boolean error3 = true;

        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Witam w aplikacji kalkulator v.04");

        while (option != 0) {
            System.out.println("Wybierz opcje kalkulatora: ");
            System.out.println("1 - Operacje matematyczne na liczbach.");
            System.out.println("2 - Operacje matematyczne na figurach geometrycznych.");
            System.out.println("0 - wyjście z programu.");

            try {
                option = scanner1.nextInt();
            } catch (InputMismatchException ex) {
                System.err.println("Nie podałes cyfry");
                scanner1.nextLine();
            }
            if (option == 1) {
                System.out.println("Podaj pierwszą liczbę:");
                a = MathCalculations.giveNumber(a, error, scanner1);
                System.out.println("Podaj drugą liczbę:");
                b = MathCalculations.giveNumber(b, error, scanner1);
                MathCalculations.mathOperands(a, b, error2, scanner1);
            } else if (option == 2) {
                scanner1.nextLine();
                String figure;
                Circle c1 = new Circle();
                Rectangle r1 = new Rectangle();
                Triangle t1 = new Triangle();
                do {
                    System.out.println("Wybierz opcje:");
                    System.out.println("t - Trójkąt. Oblicza pole i obwód trójkąta");
                    System.out.println("p - Prostokąt. Oblicza pole i obwód prostokąta");
                    System.out.println("k - Koło. Oblicza pole i obwód koła");
                    figure = scanner1.nextLine();
                    switch (figure) {
                        case "k":
                        case "K":
                            try {
                                System.out.println("Podaj promień koła jako liczbę:");
                                c1.setR(scanner1.nextDouble());
                                scanner1.nextLine();
                                System.out.println("Pole Twojego koła wynosi: " + c1.calculateArea());
                                System.out.println("Obwód Twojego koła wynosi: " + c1.calculatePerimeter() + "\n");
                                error = false;
                            } catch (InputMismatchException ex) {
                                scanner1.nextLine();
                                System.err.println("Wprowadzone dane nie są liczbą.");
                            }
                            continue;
                        case "p":
                        case "P":
                            try {
                                System.out.println("Podaj długość pierwszego boku prostokąta jako liczbę:");
                                r1.setA(scanner1.nextDouble());
                                scanner1.nextLine();
                                System.out.println("Podaj długość drugiego boku prostokąta jako liczbę:");
                                r1.setB(scanner1.nextDouble());
                                scanner1.nextLine();
                                System.out.println("Pole Twojego prostokąta wynosi: " + r1.calculateArea());
                                System.out.println("Obwód Twojego prostokąta wynosi: " + r1.calculatePerimeter() + "\n");
                                error = false;
                            } catch (InputMismatchException ex) {
                                scanner1.nextLine();
                                System.err.println("Wprowadzone dane nie są liczbą.");
                            }
                            continue;
                        case "t":
                        case "T":
                            try {
                                System.out.println("Podaj długość pierwszego boku trójkąta jako liczbę:");
                                t1.setA(scanner1.nextDouble());
                                scanner1.nextLine();
                                System.out.println("Podaj długość drugiego boku trójkąta jako liczbę:");
                                t1.setB(scanner1.nextDouble());
                                scanner1.nextLine();
                                System.out.println("Podaj długość trzeciego boku trójkąta jako liczbę:");
                                t1.setC(scanner1.nextDouble());
                                scanner1.nextLine();
                                System.out.println("Pole Twojego trójkata wynosi: " + t1.calculateArea());
                                System.out.println("Obwód Twojego trójkąta wynosi: " + t1.calculatePerimeter() + "\n");
                                error = false;
                            } catch (InputMismatchException ex) {
                                scanner1.nextLine();
                                System.err.println("Wprowadzone dane nie są liczbą.");
                            }
                        default:

                    }
                } while (error);

            }


        }
    }
}


