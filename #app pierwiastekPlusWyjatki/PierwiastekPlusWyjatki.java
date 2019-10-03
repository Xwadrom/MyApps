import java.util.InputMismatchException;
import java.util.Scanner;

public class PierwiastekPlusWyjatki {
    public static void main(String[] args) {
        boolean result = true;
        Scanner scanner1 = new Scanner(System.in);
        operation(result, scanner1);
    }

    private static void operation(boolean result, Scanner scanner1) {
        while (result) {
            try {
                    System.out.println("Podaj liczbę: ");
                    double a = scanner1.nextDouble();
                if (a < 0) {
                    throw new IllegalArgumentException();
                } else
                    result = false;
                    System.out.println("Pierwiastek z Twojej liczby to: " + Math.sqrt(a));
            } catch (IllegalArgumentException ex) {
                    System.out.println("Liczba musi być dodatnia, spróbuj jeszcze raz.");
            }catch(InputMismatchException e){
                    System.out.println("Proszę podać liczbę, inne znaki nie są akceptowane.");
                    scanner1.nextLine();
            }
        }scanner1.close();
    }
}