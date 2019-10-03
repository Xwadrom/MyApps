public class CalcMethod {
    public static void CheckCalculations(double a, String dzialanie, double b) {

        switch (dzialanie) {

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
                double dzielenie = a / b;
                System.out.println("Twoj wynik dzielenia to: " + dzielenie);
                break;
            default:
                System.out.println("Wybrałeś zły znak działania, dostepnie znaki to: +, -, *, /");
        }
    }
}
