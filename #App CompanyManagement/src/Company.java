import java.io.*;
import java.util.*;


public class Company {

    Map<String, Employee> employeeMap = new LinkedHashMap<>();

    public StringBuilder databaseMenu() {
        StringBuilder sb1 = new StringBuilder();
        sb1.append("Dostępne opcje programu: " + "\n");
        sb1.append("1 - Dodanie nowego pracownika." + "\n");
        sb1.append("2 - Wyszukanie informacji o pracowniku na podstawie imienia i nazwiska." + "\n");
        sb1.append("3 - Usuwanie pracownika z bazy danych." + "\n");
        sb1.append("4 - Wyświetlenie ilości pracowników w bazie danych." + "\n");
        sb1.append("5 - Wyjście z programu.");
        return sb1;
    }

    public void databaseInteraction(Company company, Scanner sc1, StringBuilder sb1) {
        while (CompanyApp.option != CompanyApp.EXIT) {
            System.out.println(sb1);
            try {
                CompanyApp.option = sc1.nextInt();
                sc1.nextLine();
            } catch (InputMismatchException e) {
                sc1.nextLine();
                System.err.println("Proszę wprowadzić liczbę: ");
            }

            switch (CompanyApp.option) {
                case CompanyApp.ADD_EMPLOYEE:
                    try {
                        System.out.println("Podaj imię pracownika: ");
                        String firstName = sc1.next();
                        System.out.println("Podaj nazwisko pracownika: ");
                        String lastName = sc1.next();
                        System.out.println("Wprowadź wypłatę pracownika brutto, wartości dziesiętne muszą być po przecinku: ");
                        double salary = sc1.nextDouble();
                        sc1.nextLine();
                        String key = firstName.toLowerCase() + " " + lastName.toLowerCase();
                        if (company.employeeMap.containsKey(key.trim())) {
                            System.err.println("Pracownik jest juz w bazie danych");
                        } else {
                            company.employeeMap.put(key, new Employee(firstName, lastName, salary));
                            databaseWriter(key, firstName, lastName, salary);
                            System.err.println("Dodano pracownika do bazy danych.");
                        }
                    } catch (InputMismatchException e) {
                        sc1.nextLine();
                        System.err.println("Wprowadzono błędne dane spróbuj ponownie");
                    }
                    break;
                case CompanyApp.SEARCH_EMPLOYEE:
                    Set<String> keys = company.employeeMap.keySet();
                    if (keys.size() == 0) {
                        System.err.println("Baza danych jest pusta.");
                        break;
                    }
                    System.out.println("Podaj imię i nazwisko pracownika, oddzielając je spacją: ");
                    String nameSearch = sc1.nextLine().trim().toLowerCase();
                    try {
                        System.out.println("Wynik wyszukiwania pracownika: " + company.employeeMap.get(nameSearch).getFirstname() + " " + company.employeeMap.get(nameSearch).getLastname() + " " + company.employeeMap.get(nameSearch).getSalary());
                    } catch (NullPointerException e) {
                        System.err.println("Brak pracownika w bazie danych.");
                    }
                    System.out.println();
                    break;
                case CompanyApp.DELETE_EMPLOYEE:
                    Set<String> keys2 = company.employeeMap.keySet();
                    if (keys2.size() == 0) {
                        System.err.println("Baza danych jest pusta.");
                        break;
                    }
                    System.out.println("Podaj imię i nazwisko pracownika, oddzielając je spacją: ");
                    String nameSearch2 = sc1.nextLine().trim().toLowerCase();
                    if (company.employeeMap.get(nameSearch2) != null) {
                        System.out.println("Usuwam pracownika: " + nameSearch2.toUpperCase());
                        company.employeeMap.remove(nameSearch2);
                    } else
                        System.err.println("Brak pracownika w bazie danych.");
                    System.out.println("Ilość pracowników w bazie danych: " + company.employeeMap.size());
                    System.err.println("Wychodzę do głównego menu.");
                    System.out.println();

                    try (var fileWriter = new FileWriter(CompanyApp.EMPLOYEE_DATABASE); var writer = new BufferedWriter(fileWriter)) {
                        for (String tmp : keys2) {
                            writer.write(tmp);
                            writer.newLine();
                            writer.write(company.employeeMap.get(tmp).getFirstname());
                            writer.newLine();
                            writer.write(company.employeeMap.get(tmp).getLastname());
                            writer.newLine();
                            writer.write(Double.toString(company.employeeMap.get(tmp).getSalary()));
                            writer.newLine();
                        }
                    } catch (IOException e) {
                        System.err.println("Nie udało się zapisać pliku " + CompanyApp.EMPLOYEE_DATABASE);
                    }
                    break;
                case CompanyApp.COUNT_EMPLOYEES:
                    System.err.println("Ilość pracowników w bazie danych: " + company.employeeMap.size()+"\n");
                    break;
                case CompanyApp.EXIT:
                    System.out.println("Do zobaczenia!");
                    break;
                default:
                    try {
                        throw new IllegalStateException("Unexpected value: " + CompanyApp.option);
                    } catch (IllegalStateException e) {
                        System.out.println("Błędne dane.");
                    }
            }
        }
    }

    public static void databaseWriter(String key, String firstName, String lastName, double salary) {
        try (var fileWriter = new FileWriter(CompanyApp.EMPLOYEE_DATABASE, true); var writer = new BufferedWriter(fileWriter)) {
            writer.write(key.trim());
            writer.newLine();
            writer.write(firstName.trim());
            writer.newLine();
            writer.write(lastName.trim());
            writer.newLine();
            writer.write(Double.toString(salary).trim());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Nie udało się zapisać pliku " + CompanyApp.EMPLOYEE_DATABASE);
        }
    }

    public void dataBaseCreator(String newfile) {
        File file = new File(newfile);
        boolean fileExists = file.exists();
        if (!fileExists) {
            try {
                fileExists = file.createNewFile();
            } catch (IOException e) {
                System.out.println("Nie udało się utworzyć pliku");
            }
        }
        if (fileExists)
            System.out.println("Plik " + file + " gotowy do użytku.");
    }

    public void databaseReader(Company company) {
        try (var fileReader = new FileReader(CompanyApp.EMPLOYEE_DATABASE); var reader = new BufferedReader(fileReader)) {
            String key;
            while ((key = reader.readLine()) != null) {
                company.employeeMap.put(key, new Employee(reader.readLine(), reader.readLine(), Double.valueOf(reader.readLine())));
            }
            System.out.println("Ilość pracowników w bazie danych: " + company.employeeMap.size() + "\n");
        } catch (Exception e) {
            System.err.println("Błąd odczytu z pliku.");
            e.printStackTrace();
        }
    }
}

