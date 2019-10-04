import java.util.Locale;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        VariablesContainer variablesContainer1 = new VariablesContainer();

        Scanner scanner1 = new Scanner(System.in);
        scanner1.useLocale(Locale.US);

        System.out.println("Witam w programie kalkulator");

        System.out.println("Podaj pierwszą liczbę:");
        variablesContainer1.setA(scanner1.nextDouble());
        scanner1.nextLine();

        System.out.println("Jakie działanie chcesz wykonać? podaj w formie znaku: +  -  *  /");
        variablesContainer1.setDzialanie(scanner1.nextLine());


        System.out.println("Podaj drugą liczbę:");
        variablesContainer1.setB(scanner1.nextDouble());


        CalcMethod.CheckCalculations(variablesContainer1.getA(), variablesContainer1.getDzialanie(), variablesContainer1.getB());

        scanner1.close();
    }

}

