package com.pluralsight;

import java.time.LocalDateTime;

public class Employee {
    // Backing variables
    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    private double startTime;

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

    // === ДОДАТИ ЦЕЙ SETTER ===
    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
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

    // Punch In/Out методи (з параметром)
    public void punchIn(double time) {
        this.startTime = time;
        System.out.println(name + " punched in at " + time);
    }

    public void punchOut(double time) {
        if (startTime == 0.0) {
            System.out.println("ERROR: " + name + " has not punched in yet.");
            return;
        }
        double hoursThisShift = time - startTime;
        this.hoursWorked += hoursThisShift;
        System.out.println(name + " punched out at " + time);
        System.out.println("Hours worked this shift: " + String.format("%.2f", hoursThisShift));
        System.out.println("Total hours worked: " + String.format("%.2f", hoursWorked));
        this.startTime = 0.0;
    }

    // Overloaded методи (без параметрів)
    public void punchIn() {
        LocalDateTime now = LocalDateTime.now();
        int hour = now.getHour();
        int minute = now.getMinute();
        double time = hour + (minute / 60.0);
        this.startTime = time;
        System.out.println(name + " punched in at " + hour + ":" +
                String.format("%02d", minute) + " (" + time + ")");
    }

    public void punchOut() {
        if (startTime == 0.0) {
            System.out.println("ERROR: " + name + " has not punched in yet.");
            return;
        }
        LocalDateTime now = LocalDateTime.now();
        int hour = now.getHour();
        int minute = now.getMinute();
        double time = hour + (minute / 60.0);
        double hoursThisShift = time - startTime;
        this.hoursWorked += hoursThisShift;
        System.out.println(name + " punched out at " + hour + ":" +
                String.format("%02d", minute) + " (" + time + ")");
        System.out.println("Hours worked this shift: " + String.format("%.2f", hoursThisShift));
        System.out.println("Total hours worked: " + String.format("%.2f", hoursWorked));
        this.startTime = 0.0;
    }

    // === ДОДАТИ ЦЕЙ НОВИЙ МЕТОД ===
    // Метод punchTimeCard з двома параметрами
    public void punchTimeCard(double startTime, double endTime) {
        double hoursThisShift = endTime - startTime;
        this.hoursWorked += hoursThisShift;
        System.out.println(name + " worked from " + startTime + " to " + endTime);
        System.out.println("Hours worked this shift: " + String.format("%.2f", hoursThisShift));
        System.out.println("Total hours worked: " + String.format("%.2f", hoursWorked));
    }
}