package com.pluralsight;

public class Main {
    public static void main(String[] args) {
        // ===== TESTING ROOM =====
        System.out.println("===== TESTING ROOM =====");
        Room room1 = new Room(2, 150.00, false, false);
        System.out.println("Number of Beds: " + room1.getNumberOfBeds());
        System.out.println("Price: $" + room1.getPrice());
        System.out.println("Is Occupied: " + room1.isOccupied());
        System.out.println("Is Dirty: " + room1.isDirty());
        System.out.println("Is Available: " + room1.isAvailable());

        Room room2 = new Room(1, 120.00, true, false);
        System.out.println("\nRoom 2 - Is Available: " + room2.isAvailable() + " (occupied)");

        Room room3 = new Room(2, 150.00, false, true);
        System.out.println("Room 3 - Is Available: " + room3.isAvailable() + " (dirty)");

        // Reservation
        System.out.println("\n TESTING RESERVATION ");
        Reservation res1 = new Reservation("king", 3, false);
        System.out.println("Room Type: " + res1.getRoomType());
        System.out.println("Number of Nights: " + res1.getNumberOfNights());
        System.out.println("Is Weekend: " + res1.isWeekend());
        System.out.println("Price per Night: $" + res1.getPrice());
        System.out.println("Reservation Total: $" + res1.getReservationTotal());

        System.out.println("\n--- Weekend King Room ---");
        Reservation res2 = new Reservation("king", 2, true);
        System.out.println("Room Type: " + res2.getRoomType());
        System.out.println("Is Weekend: " + res2.isWeekend());
        System.out.println("Price per Night: $" + res2.getPrice() + " (with 10% weekend fee)");
        System.out.println("Reservation Total: $" + res2.getReservationTotal());

        System.out.println("\n--- Double Room Weekday ---");
        Reservation res3 = new Reservation("double", 4, false);
        System.out.println("Room Type: " + res3.getRoomType());
        System.out.println("Price per Night: $" + res3.getPrice());
        System.out.println("Reservation Total: $" + res3.getReservationTotal());

        // Тестуємо setters
        System.out.println("\n--- Changing Reservation ---");
        res3.setRoomType("king");
        res3.setNumberOfNights(5);
        res3.setWeekend(true);
        System.out.println("New Room Type: " + res3.getRoomType());
        System.out.println("New Nights: " + res3.getNumberOfNights());
        System.out.println("New Price per Night: $" + res3.getPrice());
        System.out.println("New Reservation Total: $" + res3.getReservationTotal());

        // TESTING EMPLOYEE
        System.out.println("\n TESTING EMPLOYEE");
        Employee emp1 = new Employee(101, "John Smith", "Housekeeping", 15.00, 35);
        System.out.println("Employee ID: " + emp1.getEmployeeId());
        System.out.println("Name: " + emp1.getName());
        System.out.println("Department: " + emp1.getDepartment());
        System.out.println("Pay Rate: $" + emp1.getPayRate());
        System.out.println("Hours Worked: " + emp1.getHoursWorked());
        System.out.println("Regular Hours: " + emp1.getRegularHours());
        System.out.println("Overtime Hours: " + emp1.getOvertimeHours());
        System.out.println("Total Pay: $" + emp1.getTotalPay());

        System.out.println("\n--- Employee with Overtime ---");
        Employee emp2 = new Employee(102, "Jane Doe", "Front Desk", 18.00, 48);
        System.out.println("Name: " + emp2.getName());
        System.out.println("Hours Worked: " + emp2.getHoursWorked());
        System.out.println("Regular Hours: " + emp2.getRegularHours());
        System.out.println("Overtime Hours: " + emp2.getOvertimeHours());
        System.out.println("Total Pay: $" + emp2.getTotalPay());

        // Розрахунок для перевірки:
        // Regular: 40 * 18 = 720
        // Overtime: 8 * 18 * 1.5 = 216
        // Total: 720 + 216 = 936
        System.out.println("(40 hrs * $18) + (8 hrs * $18 * 1.5) = $936.00");
    }
}