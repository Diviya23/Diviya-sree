public class EmployeeManagement {
    private Employee[] employees;
    private int size;

    public EmployeeManagement(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    // Add new employee
    public void addEmployee(Employee emp) {
        if (size < employees.length) {
            employees[size++] = emp;
            System.out.println("Employee added successfully.");
        } else {
            System.out.println("Array is full. Cannot add more employees.");
        }
    }

    // Search employee by ID
    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    // Traverse and print all employees
    public void traverseEmployees() {
        if (size == 0) {
            System.out.println("No employees to display.");
        } else {
            for (int i = 0; i < size; i++) {
                employees[i].printEmployee();
            }
        }
    }

    // Delete employee by ID
    public void deleteEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                // Shift remaining elements left
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--size] = null;
                System.out.println("Employee deleted successfully.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    // Main method
    public static void main(String[] args) {
        EmployeeManagement ems = new EmployeeManagement(5);

        Employee e1 = new Employee(101, "Alice", "Manager", 75000);
        Employee e2 = new Employee(102, "Bob", "Developer", 55000);
        Employee e3 = new Employee(103, "Charlie", "Tester", 45000);

        // Adding
        ems.addEmployee(e1);
        ems.addEmployee(e2);
        ems.addEmployee(e3);

        System.out.println("\nAll Employees:");
        ems.traverseEmployees();

        // Searching
        System.out.println("\nSearching for Employee with ID 102:");
        Employee found = ems.searchEmployee(102);
        if (found != null) {
            found.printEmployee();
        } else {
            System.out.println("Employee not found.");
        }

        // Deletion
        System.out.println("\nDeleting Employee with ID 101:");
        ems.deleteEmployee(101);

        System.out.println("\nAll Employees after deletion:");
        ems.traverseEmployees();
    }
}
