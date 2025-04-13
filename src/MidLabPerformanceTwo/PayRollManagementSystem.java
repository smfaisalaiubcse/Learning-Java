package MidLabPerformanceTwo;

import java.util.*;
import java.util.stream.Collectors;

class Employee {
    String id;
    String name;
    String role;
    double baseSalary;
    int daysWorked;

    enum Role {
        tailor(500),
        checker(300),
        packager(200);

        private final double bonus;

        Role(double bonus) {
            this.bonus = bonus;
        }

        public double getBonus() {
            return bonus;
        }

        public static double getBonusForRole(Role role) {
            return role.getBonus();
        }
    }

    // PayrollProcessor Utility Class
    static class PayrollProcessor {
        public static double calculateFinalSalary(Employee employee) {
            double bonus = Role.valueOf(employee.role).getBonus();
            return (employee.baseSalary * employee.daysWorked) + bonus;
        }
    }

    public Employee(String id, String name, String role, double baseSalary, int daysWorked) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.baseSalary = baseSalary;
        this.daysWorked = daysWorked;
    }

    @Override
    public String toString() {
        double finalSalary = PayrollProcessor.calculateFinalSalary(this);
        return String.format("ID: %s | Name: %s | Role: %s | Days Worked: %d | Final Salary: $%.2f", id, name, role, daysWorked, finalSalary);
    }
}

public class PayRollManagementSystem {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("101", "Faisal", "tailor", 800, 22),
                new Employee("102", "Fahim", "checker", 900, 28),
                new Employee("103", "Samia", "packager", 600, 21),
                new Employee("104", "Asif", "tailor", 800, 19),
                new Employee("105", "Shakil", "checker", 1000, 19),
                new Employee("106", "Mansura", "packager", 600, 23)
        );

        // Filter, sort and group employee
        Map<String, List<Employee>> employeesByRole = employees.stream()
                .filter(e -> e.daysWorked >= 20)
                .sorted(Comparator.comparingDouble(Employee.PayrollProcessor::calculateFinalSalary).reversed())
                .collect(Collectors.groupingBy(e -> e.role));

        // Print employees who worked 20+ days
        System.out.println("Employees who worked 20+ days:");
        employees.stream()
                .filter(e -> e.daysWorked >= 20)
                .sorted(Comparator.comparingDouble(Employee.PayrollProcessor::calculateFinalSalary).reversed())
                .forEach(System.out::println);

        // Print grouped employees by role
        System.out.println("\nGrouped by Role:");
        employeesByRole.forEach((role, empList) -> {
            System.out.println(role + ":");
            empList.forEach(System.out::println);
        });

        // Calculate total payroll cost (only for employees who worked 20+ days)
        double totalPayroll = employees.stream()
                .filter(e -> e.daysWorked >= 20)
                .mapToDouble(Employee.PayrollProcessor::calculateFinalSalary)
                .sum();

        System.out.printf("\nTotal Payroll Cost (20+ days only): $%.2f\n", totalPayroll);

        // Bonus example via static method reference (optional display)
        System.out.println("\nRole Bonuses:");
        Arrays.stream(Employee.Role.values())
                .forEach(role -> System.out.println(role.name() + " Bonus: $" + Employee.Role.getBonusForRole(role)));
    }
}
