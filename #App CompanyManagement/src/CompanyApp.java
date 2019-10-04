import java.util.Scanner;

public class CompanyApp {

    public static final String EMPLOYEE_DATABASE = "EmployeeDatabase.txt";
    public static final int ADD_EMPLOYER = 1;
    public static final int SEARCH_EMPLOYER = 2;
    public static final int DELETE_EMPLOYER = 3;
    public static final int EXIT = 4;
    public static int option = 0;

    public static void main(String[] args) {

        Company company = new Company();
        Scanner sc1 = new Scanner(System.in);
        company.dataBaseCreator(EMPLOYEE_DATABASE);
        company.databaseReader(company);
        StringBuilder sb1 = company.databaseMenu();
        company.databaseInteraction(company, sc1, sb1);

        System.out.println("Ilość pracowników w bazie danych: " + company.employeeMap.size());
    }


}
