package com.pluralsight;

import java.time.LocalDateTime;

public class Employee {
    // Backing variables
    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    private double startTime;  // час початку зміни

    // Constructor
    public Employee(int employeeId, String name, String department, double payRate, double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
        this.startTime = 0.0;
    }

    // Regular getters
    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getPayRate() {
        return payRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    // Derived getters
    public double getRegularHours() {
        if (hoursWorked <= 40) {
            return hoursWorked;
        }
        return 40.0;
    }

    public double getOvertimeHours() {
        if (hoursWorked > 40) {
            return hoursWorked - 40;
        }
        return 0.0;
    }

    public double getTotalPay() {
        double regularPay = getRegularHours() * payRate;
        double overtimePay = getOvertimeHours() * payRate * 1.5;
        return regularPay + overtimePay;
    }

    // === МЕТОДИ ДІЙ (DO) ===

    // 1. Punch In з вказаним часом
    public void punchIn(double time) {
        this.startTime = time;
        System.out.println(name + " punched in at " + time);
    }

    // 2. Punch In з поточним часом (OVERLOADED)
    public void punchIn() {
        // Отримуємо поточний час
        LocalDateTime now = LocalDateTime.now();
        int hour = now.getHour();
        int minute = now.getMinute();

        // Конвертуємо в decimal format (наприклад, 14:45 = 14.75)
        double time = hour + (minute / 60.0);

        this.startTime = time;
        System.out.println(name + " punched in at " + hour + ":" +
                String.format("%02d", minute) + " (" + time + ")");
    }

    // 3. Punch Out з вказаним часом
    public void punchOut(double time) {
        // Перевіряємо чи працівник пробив початок зміни
        if (startTime == 0.0) {
            System.out.println("ERROR: " + name + " has not punched in yet.");
            return;
        }

        // Розраховуємо відпрацьовані години
        double hoursThisShift = time - startTime;

        // Додаємо до загальної кількості годин
        this.hoursWorked += hoursThisShift;

        System.out.println(name + " punched out at " + time);
        System.out.println("Hours worked this shift");
    }
}