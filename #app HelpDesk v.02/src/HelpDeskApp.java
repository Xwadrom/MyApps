import java.util.InputMismatchException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class HelpDeskApp {
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static Scanner sc1 = new Scanner(System.in);
    private static Queue<Task> tasks= new PriorityQueue<>();
    private static Option userInput=null;

    // private static int userInput=0;  Druga wersja warunków składowych pętli while z opcjami do wyboru jako if oraz else if.

    public static void main(String[] args) {
        mainLoop();
    }
//        System.out.println(Option.values().length);
//        for(int i =0; i<Option.values().length; i++) {
//            System.out.println(Option.values()[i]);
//        }//Typ Enum i jego funkcja Option values() zawiera tablice wszystkich pól Enum, czyli do pierwszego Pola można się odwołać wpisując Option.values()[0]; itd. więc można wydrukować te wszystkie pola w pętli jakot poszczególne elementy tablicy.
        //            userInput=sc1.nextInt();          Druga wersja warunków składowych pętli z opcjami.
//            if(Option.ADD_TASK.ordinal()==userInput){
//                System.out.println(ANSI_BLUE + "Dodaje nowe zadanie..." + ANSI_RESET);
//            }else if(Option.TAKE_TASK.ordinal()==userInput){
//                System.out.println(ANSI_BLUE + "Biorę kolejne zadanie..."+ ANSI_RESET);
//            }else if(Option.CHECK_NEXT_TASK.ordinal()==userInput){
//                System.out.println(ANSI_BLUE + "Sprawdzam jakie jest kolejne zadanie, ale nie obsługuje jeszcze...."+ ANSI_RESET);
//            }
    private static void mainLoop() {

        while (userInput != Option.EXIT) {
            printOption();
            try {
                userInput = Option.values()[sc1.nextInt()]; //odwołanie do tablicy Option.values()[] - czyli Option.values()[0]=ADD_TASK, Option.values()[1]=TAKE_TASK, Option.values()[2]=CHECK_NEXT_TASK, Option.values()[3]=EXIT.
            }catch (ArrayIndexOutOfBoundsException | NullPointerException | InputMismatchException e){ //tutaj mogą wystąpiź, aż 3 wyjątki, wszystkie obsługuje jednym blokiem try catch.
                sc1.nextLine();
                System.err.println("Błąd!. Dostępne opcje to 0, 1, 2, 3.");
                continue;
            }
            switch (userInput) {
                case ADD_TASK:
                    sc1.nextLine();
                    System.out.println(ANSI_BLUE +"Podaje nazwę zgłoszenia: "+ ANSI_RESET);
                    String name=sc1.nextLine();
                    System.out.println(ANSI_BLUE +"Podaj opis zgłoszenia: "+ ANSI_RESET);
                    String descritpion=sc1.nextLine();
                    System.out.println(ANSI_BLUE +"Zadeklaruj priorytet zgłoszenia do wyboru: High, Moderate, Low."+ ANSI_RESET);
                    String priority= sc1.next().toUpperCase();
                    try {
                        tasks.offer(new Task(name,descritpion, Priority.valueOf(priority)));
                        System.out.println(ANSI_BLUE +"Dodano do systemu HelpDesk ---> " + tasks.peek()+ ANSI_RESET);
                    } catch (IllegalArgumentException e) {
                        System.err.println("Proszę wprowadzić poprawną nazwę priorytetu, do wyboru: High, Moderate oraz Low.");
                    }break;
                case TAKE_TASK:
                    if(tasks.isEmpty()){
                        System.out.println(ANSI_BLUE+"Obecnie nie ma zadań do wykonania."+ANSI_RESET);
                    }else
                    System.out.println(ANSI_BLUE+ "Pobrano ---> "+ tasks.poll() +ANSI_RESET);
                    break;
                case CHECK_NEXT_TASK:
                    if(tasks.isEmpty()){
                        System.out.println(ANSI_BLUE+"Obecnie nie ma zadań do wykonania."+ANSI_RESET);
                    }else
                    System.out.println(ANSI_BLUE+"Pierwsze w kolejce ---> " + tasks.peek()+ANSI_RESET);
                    break;
            }
        }
    }

    public static void printOption(){
    for(Option tmp: Option.values()){ //iteruję pętlą foreach po całej tablicy typu Enum Option.values()
        System.out.println(tmp.option+" "+tmp.description); //drukuję pola option + description dla każdego elementu tablicy Option.values().
    }
}
}

enum Option{
    ADD_TASK(0, "Dodaj nowe zadanie."), TAKE_TASK(1,"Pobierz kolejne zadanie w kolejce do obsłużenia."), CHECK_NEXT_TASK(2,"Sprawdź jak jest następne zadanie w kolejce."), EXIT(3,"Wyjdź z programu.");

    int option;
    String description;

    Option(int option, String description) {
        this.option = option;
        this.description = description;
    }
}