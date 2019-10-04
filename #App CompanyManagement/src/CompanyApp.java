import java.util.Scanner;

public class CompanyApp {

    public static final String EMPLOYEE_DATABASE = "EmployeeDatabase.txt";
    public static final int ADD_EMPLOYEE = 1;
    public static final int SEARCH_EMPLOYEE = 2;
    public static final int DELETE_EMPLOYEE = 3;
    public static final int COUNT_EMPLOYEES = 4;
    public static final int EXIT = 5;
    public static int option = 0;

    public static void main(String[] args) {

        Company company = new Company();
        Scanner sc1 = new Scanner(System.in);
        company.dataBaseCreator(EMPLOYEE_DATABASE);
        company.databaseReader(company);
        StringBuilder sb1 = company.databaseMenu();
        company.databaseInteraction(company, sc1, sb1);

    }


}
