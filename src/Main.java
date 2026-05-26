import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        EmployeeDAO employeeDAO = new EmployeeDAO();

        while (true) {

            System.out.println("\n=================🐣===============");
            System.out.println("     EMPLOYEE MANAGEMENT SYSTEM");
            System.out.println("          Developed by Parul Chauhan");
            System.out.println("====================================");

            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Delete Employee");
            System.out.println("4. Search Employee");
            System.out.println("5. Exit");

            System.out.print("\nEnter your choice: ");

            int choice = scanner.nextInt();

            scanner.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter employee name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter department: ");
                    String department = scanner.nextLine();

                    System.out.print("Enter salary: ");
                    double salary = scanner.nextDouble();

                    if (salary <= 0) {

                        System.out.println("Invalid salary amount");
                        break;
                    }

                    scanner.nextLine();

                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();

                    Employee employee =
                            new Employee(
                                    0,
                                    name,
                                    department,
                                    salary,
                                    email
                            );

                    employeeDAO.addEmployee(employee);

                    System.out.println("\u001B[32mEmployee added successfully\u001B[0m");

                    break;

                case 2:

                    employeeDAO.viewEmployees();

                    employeeDAO.totalEmployees();

                    break;

                case 3:

                    System.out.print("Enter employee ID to delete: ");

                    int id = scanner.nextInt();

                    employeeDAO.deleteEmployee(id);

                    System.out.println("\u001B[31mEmployee deleted successfully\u001B[0m");

                    break;

                case 4:

                    System.out.print("Enter employee ID to search: ");

                    int searchId = scanner.nextInt();

                    employeeDAO.searchEmployee(searchId);

                    break;

                case 5:

                    System.out.println("Application closed successfully");

                    System.exit(0);

                default:

                    System.out.println("Invalid option");
            }
        }
    }
}