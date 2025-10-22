package com.pluralsight;

public class Main {
    public static void main(String[] args) {
        //  Constructor без заброньованих кімнат =====
        System.out.println("===== TEST 1: Default Constructor =====");
        Hotel hotel1 = new Hotel("Grand Plaza Hotel", 10, 50);
        hotel1.printStatus();

        // ===== TEST 2: Бронювання суїтів =====
        System.out.println("===== TEST 2: Booking Suites =====");
        boolean result1 = hotel1.bookRoom(3, true);  // Бронюємо 3 суїти
        System.out.println("Booking result: " + result1);
        hotel1.printStatus();

        // ===== TEST 3: Бронювання звичайних кімнат =====
        System.out.println("===== TEST 3: Booking Basic Rooms =====");
        boolean result2 = hotel1.bookRoom(20, false);  // Бронюємо 20 кімнат
        System.out.println("Booking result: " + result2);
        hotel1.printStatus();

        // ===== TEST 4: Спроба забронювати більше ніж доступно =====
        System.out.println("===== TEST 4: Overbooking Suites =====");
        boolean result3 = hotel1.bookRoom(10, true);  // Бронюємо 10, але є лише 7
        System.out.println("Booking result: " + result3);
        hotel1.printStatus();

        // ===== TEST 5: Спроба забронювати більше basic rooms ніж доступно =====
        System.out.println("===== TEST 5: Overbooking Basic Rooms =====");
        boolean result4 = hotel1.bookRoom(40, false);  // Бронюємо 40, але є лише 30
        System.out.println("Booking result: " + result4);
        hotel1.printStatus();

        // ===== TEST 6: Constructor з заброньованими кімнатами =====
        System.out.println("\n===== TEST 6: Constructor with Booked Rooms =====");
        Hotel hotel2 = new Hotel("Seaside Resort", 15, 60, 5, 25);
        hotel2.printStatus();

        // ===== TEST 7: Бронювання в готелі з існуючими бронюваннями =====
        System.out.println("===== TEST 7: Booking in Pre-booked Hotel =====");
        System.out.println("Trying to book 8 suites (10 available):");
        boolean result5 = hotel2.bookRoom(8, true);
        System.out.println("Result: " + result5);

        System.out.println("\nTrying to book 30 basic rooms (35 available):");
        boolean result6 = hotel2.bookRoom(30, false);
        System.out.println("Result: " + result6);

        hotel2.printStatus();

        // ===== TEST 8: Повне бронювання =====
        System.out.println("===== TEST 8: Fully Booking a Hotel =====");
        Hotel hotel3 = new Hotel("Budget Inn", 5, 20);

        hotel3.bookRoom(5, true);   // Бронюємо всі суїти
        hotel3.bookRoom(20, false); // Бронюємо всі кімнати
        hotel3.printStatus();

        // Спроба забронювати ще
        System.out.println("Trying to book 1 more suite:");
        hotel3.bookRoom(1, true);

        System.out.println("\nTrying to book 1 more basic room:");
        hotel3.bookRoom(1, false);

        // ===== TEST 9: Множинні бронювання =====
        System.out.println("\n===== TEST 9: Multiple Bookings =====");
        Hotel hotel4 = new Hotel("Mountain Lodge", 8, 30);

        hotel4.bookRoom(2, true);
        hotel4.bookRoom(5, false);
        hotel4.bookRoom(1, true);
        hotel4.bookRoom(10, false);
        hotel4.bookRoom(3, true);

        hotel4.printStatus();

        // ===== TEST 10: Edge case - бронювання 0 кімнат =====
        System.out.println("===== TEST 10: Edge Case - Booking 0 Rooms =====");
        boolean result7 = hotel4.bookRoom(0, true);
        System.out.println("Booking 0 suites result: " + result7);
    }
}