package MidLabPerformanceOne;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import static java.time.temporal.TemporalAdjusters.lastDayOfYear;

enum LeaveType {
    SICK,
    VACATION
}

abstract class Employee {
    public String employee_type;
    public String employee_id;
    public String employee_name;
    LocalDate date_of_birth;
    LocalDate joining_date;

    abstract int calculateLeaveBalance(LocalDate joining_date, LeaveType type);
}

class Officer extends Employee {
    public String designation;
    public String department;
    public int sick_leave_balance = 10;
    public int vacation_balance = 15;
    LocalDate today = LocalDate.now();
    LocalDate lastDay = today.with(lastDayOfYear());

    @Override
    public int calculateLeaveBalance(LocalDate joining_date, LeaveType type) {
        long days = ChronoUnit.DAYS.between(joining_date, lastDay) + 1;
        int balance = 0;

        switch (type) {
            case SICK:
                balance = sick_leave_balance * (int) days;
                break;
            case VACATION:
                balance = vacation_balance * (int) days;
                break;
        }

        return balance / 365;
    }
}

class Staff extends Employee {
    public String designation;
    public String department;
    public int sick_leave_balance = 7;
    public int vacation_balance = 10;
    LocalDate today = LocalDate.now();
    LocalDate lastDay = today.with(lastDayOfYear());

    @Override
    public int calculateLeaveBalance(LocalDate joining_date, LeaveType type) {
        long days = ChronoUnit.DAYS.between(joining_date, lastDay) + 1;
        int balance = 0;

        switch (type) {
            case SICK:
                balance = sick_leave_balance * (int) days;
                break;
            case VACATION:
                balance = vacation_balance * (int) days;
                break;
        }

        return Math.round((float) balance / 365);
    }
}

class LeaveCalculation<T extends Employee> {
    public void process(T employee) {
        int sick = employee.calculateLeaveBalance(employee.joining_date, LeaveType.SICK);
        int vacation = employee.calculateLeaveBalance(employee.joining_date, LeaveType.VACATION);

        System.out.println("\n--- Leave Balance Report ---");
        System.out.println("Employee Name: " + employee.employee_name);
        System.out.println("Employee Type: " + employee.employee_type);
        System.out.println("Sick Leave Balance: " + sick);
        System.out.println("Vacation Leave Balance: " + vacation);
    }
}

public class LeaveCalculationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter employee type (officer/staff):");
        String type = sc.nextLine();

        System.out.println("Enter Employee ID:");
        String id = sc.nextLine();

        System.out.println("Enter Employee Name:");
        String name = sc.nextLine();

        System.out.println("Enter Joining Year (e.g. 2020):");
        int year = sc.nextInt();

        System.out.println("Enter Joining Month (1-12):");
        int month = sc.nextInt();

        System.out.println("Enter Joining Day (1-31):");
        int day = sc.nextInt();

        LocalDate joiningDate = LocalDate.of(year, month, day);

        if (type.equalsIgnoreCase("officer")) {
            Officer officer = new Officer();
            officer.employee_type = "Officer";
            officer.employee_id = id;
            officer.employee_name = name;
            officer.joining_date = joiningDate;

            LeaveCalculation<Officer> calc = new LeaveCalculation<>();
            calc.process(officer);
        } else if (type.equalsIgnoreCase("staff")) {
            Staff staff = new Staff();
            staff.employee_type = "Staff";
            staff.employee_id = id;
            staff.employee_name = name;
            staff.joining_date = joiningDate;

            LeaveCalculation<Staff> calc = new LeaveCalculation<>();
            calc.process(staff);
        } else {
            System.out.println("Invalid employee type!");
        }

        sc.close();
    }
}
