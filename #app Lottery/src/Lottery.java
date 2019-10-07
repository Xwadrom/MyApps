import java.util.*;

public class Lottery {
    private static List<Integer> allNumbers = new ArrayList<>();
    private static int winNumbersCount;
    private static int chosenNumbers[]=new int[6];
    private static int[] winNumbers = new int[6];
    private static Scanner sc1 = new Scanner(System.in);
    private static final int EXIT=1;
    private static final int ADD_NUMBERS=2;
    private static int option;

    public static void main(String[] args) {

        while(option!=EXIT) {
            System.out.println("Witamy w progamie Lottery. Wybierz numer opcji:");
            System.out.println("1 - Wyjście z programu");
            System.out.println("2 - Dodaj liczby do losowania");
            try {
                option=sc1.nextInt();
            } catch (Exception e) {
                sc1.nextLine();
                System.err.println("Proszę podać odpowiedni numer opcji.");
            }
            switch(option) {
                case EXIT:
                    System.out.println("Wychodzę z programu.");
                    break;

                case ADD_NUMBERS:
                System.out.println("Podaj 1 liczbę: ");
                int numberOne = sc1.nextInt();
                if (numberOne > 0 && numberOne < 50) {
                    chosenNumbers[0] = numberOne;
                } else {
                    System.out.println("Podana liczba nie mieści się w przedziale od 1 do 49.");
                    break;
                }
                sc1.nextLine();
                System.out.println("Podaj drugą liczbę: ");
                    int numberTwo = sc1.nextInt();
                    if (numberTwo > 0 && numberTwo < 50) {
                        chosenNumbers[1] = numberTwo;
                    } else {
                        System.out.println("Podana liczba nie mieści się w przedziale od 1 do 49.");
                        break;
                    }
                sc1.nextLine();
                System.out.println("Podaj trzecią liczbę: ");
                    int numberThree = sc1.nextInt();
                    if (numberThree > 0 && numberThree < 50) {
                        chosenNumbers[2] = numberThree;
                    } else {
                        System.out.println("Podana liczba nie mieści się w przedziale od 1 do 49.");
                        break;
                    }
                sc1.nextLine();
                System.out.println("Podaj czwartą liczbę: ");
                    int numberFour = sc1.nextInt();
                    if (numberFour > 0 && numberFour < 50) {
                        chosenNumbers[3] = numberFour;
                    } else {
                        System.out.println("Podana liczba nie mieści się w przedziale od 1 do 49.");
                        break;
                    }
                sc1.nextLine();
                System.out.println("Podaj piątą liczbę: ");
                    int numberFive = sc1.nextInt();
                    if (numberFive > 0 && numberFive < 50) {
                        chosenNumbers[4] = numberFive;
                    } else {
                        System.out.println("Podana liczba nie mieści się w przedziale od 1 do 49.");
                        break;
                    }
                sc1.nextLine();
                System.out.println("Podaj szóstą liczbę: ");
                    int numberSix = sc1.nextInt();
                    if (numberSix > 0 && numberSix < 50) {
                        chosenNumbers[5] = numberSix;
                    } else {
                        System.out.println("Podana liczba nie mieści się w przedziale od 1 do 49.");
                        break;
                    }
                sc1.nextLine();
                    generate();
                    randomize();
                    checkResult();
                    break;
            }
        }


    }

    private static void checkResult() {
        System.out.println();
        for (int tmp : winNumbers) {
            for (int i = 0; i < chosenNumbers.length; i++) {
                if(chosenNumbers[i]==tmp){
                    System.out.println("Gratuluje trafiłes numer: " + tmp);
                    winNumbersCount++;
                }
            }
        }
        System.out.println("Ilość trafionych numerów to: " + winNumbersCount);
    }

    private static void randomize() {
        System.out.println("Rozpoczynam losowanie.");
        Collections.shuffle(allNumbers);
        for (int i = 0; i < winNumbers.length; i++) {
            winNumbers[i] = allNumbers.get(i);
        }
        System.out.print("Wylosowane numery to: ");
        for(int tmp:winNumbers){
            System.out.print(tmp+" ");
        }
        System.out.println();
    }

    private static void generate() {
        for(int i = 1; i<50; i++){
            allNumbers.add(i);
        }

    }


}
