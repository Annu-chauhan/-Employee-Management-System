import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeDAO {

    public void addEmployee(Employee employee) {

        try {

            Connection connection = DBConnection.connect();

            String sql =
                    "INSERT INTO employees(name, department, salary, email) VALUES (?, ?, ?, ?)";

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setString(1, employee.getName());
            statement.setString(2, employee.getDepartment());
            statement.setDouble(3, employee.getSalary());
            statement.setString(4, employee.getEmail());

            int rows = statement.executeUpdate();

            if (rows > 0) {

                System.out.println("\u001B[32mEmployee added successfully\u001B[0m");
            }

        } catch (Exception e) {

            System.out.println("Unable to add employee");
            e.printStackTrace();
        }
    }

    public void viewEmployees() {

        try {

            Connection connection = DBConnection.connect();

            String sql = "SELECT * FROM employees";

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            ResultSet result = statement.executeQuery();

            System.out.println("\n========== Employee Records ==========");

            while (result.next()) {

                System.out.println(
                        result.getInt("id") + " | " +
                        result.getString("name") + " | " +
                        result.getString("department") + " | " +
                        result.getDouble("salary") + " | " +
                        result.getString("email")
                );
            }

        } catch (Exception e) {

            System.out.println("Unable to fetch employees");
            e.printStackTrace();
        }
    }

    public void deleteEmployee(int employeeId) {

        try {

            Connection connection = DBConnection.connect();

            String sql =
                    "DELETE FROM employees WHERE id = ?";

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setInt(1, employeeId);

            int rows = statement.executeUpdate();

            if (rows > 0) {

                System.out.println("\u001B[31mEmployee deleted successfully\u001B[0m");

            } else {

                System.out.println("Employee not found");
            }

        } catch (Exception e) {

            System.out.println("Unable to delete employee");
            e.printStackTrace();
        }
    }

    public void searchEmployee(int id) {

        try {

            Connection con = DBConnection.connect();

            String query = "SELECT * FROM employees WHERE id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("\nEmployee Found");

                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Department: " + rs.getString("department"));
                System.out.println("Salary: " + rs.getDouble("salary"));
                System.out.println("Email: " + rs.getString("email"));

            } else {

                System.out.println("Employee not found");
            }

        } catch (Exception e) {

            System.out.println("Search failed");
        }
    }

    public void totalEmployees() {

        try {

            Connection con = DBConnection.connect();

            String query = "SELECT COUNT(*) FROM employees";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("\nTotal Employees: " + rs.getInt(1));
            }

        } catch (Exception e) {

            System.out.println("Unable to count employees");
        }
    }
}