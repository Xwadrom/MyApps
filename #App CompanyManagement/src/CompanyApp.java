import java.util.Scanner;

public class CompanyApp {

    public final static String EMPLOYEE_DATABASE_TXT = "EmployeeDatabase.txt";
    public static final int ADD_EMPLOYER = 1;
    public static final int SEARCH_EMPLOYER = 2;
    public static final int DELETE_EMPLOYER = 3;
    public static final int EXIT = 4;
    public static int option = 0;

    public static void main(String[] args) {

        Company company = new Company();
        Scanner sc1 = new Scanner(System.in);
        company.databaseReader(company);
        StringBuilder sb1 = company.databaseMenu();
        company.dataBaseCreator(EMPLOYEE_DATABASE_TXT);
        company.databaseInteraction(company, sc1, sb1);
        company.employeeMap.remove("marta suchecka");

        System.out.println("Ilość pracowników w bazie danych: " + company.employeeMap.size());
    }






}
