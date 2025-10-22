package com.pluralsight;

public class Hotel {
    // Backing variables
    private String name;
    private int numberOfSuites;
    private int numberOfRooms;
    private int bookedSuites;
    private int bookedBasicRooms;

    // Constructor 1: Без заброньованих кімнат (за замовчуванням 0)
    public Hotel(String name, int numberOfSuites, int numberOfRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = 0;
        this.bookedBasicRooms = 0;
    }

    // Constructor 2: З вказаною кількістю заброньованих кімнат
    public Hotel(String name, int numberOfSuites, int numberOfRooms,
                 int bookedSuites, int bookedBasicRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = bookedSuites;
        this.bookedBasicRooms = bookedBasicRooms;
    }

    // === GETTERS (тільки getters, БЕЗ setters!) ===

    public String getName() {
        return name;
    }

    public int getNumberOfSuites() {
        return numberOfSuites;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public int getBookedSuites() {
        return bookedSuites;
    }

    public int getBookedBasicRooms() {
        return bookedBasicRooms;
    }

    // === DERIVED GETTERS (розраховують значення) ===

    // Доступні суїти = загальна кількість - заброньовані
    public int getAvailableSuites() {
        return numberOfSuites - bookedSuites;
    }

    // Доступні звичайні кімнати = загальна кількість - заброньовані
    public int getAvailableRooms() {
        return numberOfRooms - bookedBasicRooms;
    }

    // === МЕТОДИ ДІЙ (DO) ===

    /**
     * Бронює кімнати в готелі
     * @param numberOfRooms скільки кімнат бронювати
     * @param isSuite true = suite, false = basic room
     * @return true якщо бронювання успішне, false якщо недостатньо кімнат
     */
    public boolean bookRoom(int numberOfRooms, boolean isSuite) {
        if (isSuite) {
            // Бронюємо суїти
            if (getAvailableSuites() >= numberOfRooms) {
                // Достатньо суїтів доступно
                bookedSuites += numberOfRooms;
                System.out.println("Successfully booked " + numberOfRooms + " suite(s).");
                return true;
            } else {
                // Недостатньо суїтів
                System.out.println("ERROR: Not enough suites available. " +
                        "Requested: " + numberOfRooms +
                        ", Available: " + getAvailableSuites());
                return false;
            }
        } else {
            // Бронюємо звичайні кімнати
            if (getAvailableRooms() >= numberOfRooms) {
                // Достатньо кімнат доступно
                bookedBasicRooms += numberOfRooms;
                System.out.println("Successfully booked " + numberOfRooms + " basic room(s).");
                return true;
            } else {
                // Недостатньо кімнат
                System.out.println("ERROR: Not enough basic rooms available. " +
                        "Requested: " + numberOfRooms +
                        ", Available: " + getAvailableRooms());
                return false;
            }
        }
    }

    // Додатковий метод для виводу інформації про готель
    public void printStatus() {
        System.out.println("\n========================================");
        System.out.println("Hotel: " + name);
        System.out.println("========================================");
        System.out.println("Suites - Total: " + numberOfSuites +
                ", Booked: " + bookedSuites +
                ", Available: " + getAvailableSuites());
        System.out.println("Basic Rooms - Total: " + numberOfRooms +
                ", Booked: " + bookedBasicRooms +
                ", Available: " + getAvailableRooms());
        System.out.println("========================================\n");
    }
}
