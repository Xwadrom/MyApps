import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class TaskManager {

    private Scanner sc = new Scanner(System.in);
    private Queue<Task> taskQueue = new PriorityQueue<>();

    private static void printOptions() {
        for (Option o : Option.values()) {
            System.out.println(o);
        }
    }

    public  void mainLoop() {
        Option next = null;
        while (next == null || next != Option.EXIT) {
            printOptions();
            next = Option.createFromInt(sc.nextInt());
            sc.nextLine();
            switch (next) {
                case ADD:
                    taskQueue.offer(readAndCreateTask());
                    break;
                case TAKE:
                    takeTask();
                    break;
                case EXIT:
                    System.out.println("Papa!");
            }
        }
    }

    private Task readAndCreateTask() {
        System.out.println("Podaj nazwę zadania: ");
        String name = sc.nextLine();
        System.out.println("Podaj opis zadania: ");
        String desc = sc.nextLine();
        System.out.println("Podaj priorytet (LOW, MODERATE, HIGH): ");
        Task.Priority priority = Task.Priority.valueOf(sc.nextLine().toUpperCase());
        System.out.println("Zadanie zostało dodane\n");

        return new Task(name, desc, priority);
    }

    private void takeTask() {
        if(taskQueue.isEmpty()) {
            System.out.println("Brak zadań do wykonania!");
        } else {
            Task nextTask = taskQueue.poll();
            System.out.println("Zadanie do wykonania: ");
            System.out.println(nextTask);
        }
    }

    private enum Option {
        ADD(0, "Dodaj zadanie"), TAKE(1, "Zrób kolejne zadanie"), EXIT(2, "Wyjdź");

        int option;
        String desc;

        Option(int opt, String desc) {
            this.option = opt;
            this.desc = desc;
        }

        static Option createFromInt(int option) {
            return Option.values()[option];
        }

        @Override
        public String toString() {
            return option + " - " + desc;
        }
    }
}