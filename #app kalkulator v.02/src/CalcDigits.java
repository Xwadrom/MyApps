import java.util.InputMismatchException;
import java.util.Scanner;

public class CalcDigits {
    public static void main(String[] args) {
        double a=0;
        String operator="";
        double b=0;
        double result=0;
        boolean error=true;
        boolean error2=true;
        boolean error3=true;
        Scanner scanner1=new Scanner(System.in);
        System.out.println("Witam w aplikacji kalkulator v.02");

        System.out.println("Podaj pierwszą liczbę:");
        do{
            try{
                a = scanner1.nextDouble();
                error = false;
                System.out.println("Wczytana liczba to: "+ a);
            }catch(InputMismatchException ex){
                System.out.println("Nie podałes liczby spróbuj jeszcze raz:");
                scanner1.nextLine();
            }
        }while (error);


        System.out.println("Podaj drugą liczbę:");
        do{
            try{
                b = scanner1.nextDouble();
                error2 = false;
                System.out.println("Wczytana liczba to: "+ b);
                scanner1.nextLine();
            }catch(InputMismatchException ex){
                System.out.println("Nie podałes liczby spróbuj jeszcze raz:");
                scanner1.nextLine();
            }
        }while (error2);

        System.out.println("Podaj znak operacji matematycznej +, -, *, / :");
        operator=scanner1.nextLine();


        switch (operator) {

            case "+":
                double sum = a + b;
                System.out.println("Twoj wynik dodawania to: " + sum);
                break;
            case "-":
                double minus = a - b;
                System.out.println("Twoj wynik odejmowania to: " + minus);
                break;
            case "*":
                double mnozenie = a * b;
                System.out.println("Twoj wynik mnozenia to: " + mnozenie);
                break;
            case "/":
                try {
                    double dzielenie = a / b;
                    if (dzielenie == Double.POSITIVE_INFINITY ||
                            dzielenie == Double.NEGATIVE_INFINITY)
                        throw new ArithmeticException();
                    System.out.println("Twoj wynik dzielenia to: " + dzielenie);

                }catch (ArithmeticException ex){
                    System.out.println("Uwaga nie można dzielić przez 0.");

                }
                break;
            default:
                try {
                    if (operator != "+" || operator != "-" || operator != "*" || operator != "/") {
                        throw new UnknownOperatorException("UWAGA!!!!");
                    }
                }catch (UnknownOperatorException ex){
                    System.err.println("Wybrałeś zły znak działania, dostepnie znaki to: +, -, *, /");
                }

        }




    }
}
