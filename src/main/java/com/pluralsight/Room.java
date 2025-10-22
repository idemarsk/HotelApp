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

    // Derived getter
    public boolean isAvailable() {
        return !occupied && !dirty;
    }

    // === ДОДАТИ ЦІ SETTERS ===
    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public void setDirty(boolean dirty) {
        this.dirty = dirty;
    }

    // Методи дій
    public void checkIn() {
        if (!isAvailable()) {
            System.out.println("ERROR: Cannot check in. Room is not available.");
            return;
        }
        this.occupied = true;
        this.dirty = true;
        System.out.println("Guest checked in successfully.");
    }

    public void checkOut() {
        if (!occupied) {
            System.out.println("ERROR: Cannot check out. Room is not occupied.");
            return;
        }
        this.occupied = false;
        System.out.println("Guest checked out successfully. Room needs cleaning.");
    }

    public void cleanRoom() {
        if (occupied) {
            System.out.println("ERROR: Cannot clean room. Room is currently occupied.");
            return;
        }
        this.dirty = false;
        System.out.println("Room cleaned successfully. Room is now available.");
    }
}