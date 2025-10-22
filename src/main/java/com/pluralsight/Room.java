package com.pluralsight;

public class Room {
    // Backing variables
    private int numberOfBeds;
    private double price;
    private boolean occupied;
    private boolean dirty;

    // Constructor
    public Room(int numberOfBeds, double price, boolean occupied, boolean dirty) {
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.occupied = occupied;
        this.dirty = dirty;
    }

    // Regular getters
    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public double getPrice() {
        return price;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public boolean isDirty() {
        return dirty;
    }

    // Derived getter - кімната доступна тільки якщо чиста І не зайнята
    public boolean isAvailable() {
        return !occupied && !dirty;
    }

    // === МЕТОДИ ДІЙ (DO) ===

    // Check in - гість заселяється
    public void checkIn() {
        // Перевіряємо чи кімната доступна
        if (!isAvailable()) {
            System.out.println("ERROR: Cannot check in. Room is not available.");
            return;
        }

        // Заселяємо гостя
        this.occupied = true;
        this.dirty = true;  // після заселення кімната стає брудною
        System.out.println("Guest checked in successfully.");
    }

    // Check out - гість виселяється
    public void checkOut() {
        // Перевіряємо чи кімната зайнята
        if (!occupied) {
            System.out.println("ERROR: Cannot check out. Room is not occupied.");
            return;
        }

        // Виселяємо гостя
        this.occupied = false;
        // dirty залишається true - кімната потребує прибирання!
        System.out.println("Guest checked out successfully. Room needs cleaning.");
    }

    // Clean room - покоївка прибирає кімнату
    public void cleanRoom() {
        // Перевіряємо чи кімната зайнята
        if (occupied) {
            System.out.println("ERROR: Cannot clean room. Room is currently occupied.");
            return;
        }

        // Прибираємо кімнату
        this.dirty = false;
        System.out.println("Room cleaned successfully. Room is now available.");
    }
}