package com.pluralsight;

public class Reservation {
    // Backing variables
    private String roomType;      // "king" або "double"
    private int numberOfNights;
    private boolean weekend;

    // Constructor
    public Reservation(String roomType, int numberOfNights, boolean weekend) {
        this.roomType = roomType;
        this.numberOfNights = numberOfNights;
        this.weekend = weekend;
    }

    // Getters and setters
    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public boolean isWeekend() {
        return weekend;
    }

    public void setWeekend(boolean weekend) {
        this.weekend = weekend;
    }

    // Derived getter - розраховує ціну за ніч
    public double getPrice() {
        double basePrice;

        // Визначаємо базову ціну залежно від типу кімнати
        if (roomType.equalsIgnoreCase("king")) {
            basePrice = 139.00;
        } else if (roomType.equalsIgnoreCase("double")) {
            basePrice = 124.00;
        } else {
            basePrice = 0.0; // якщо тип невідомий
        }

        // Якщо викенд, додаємо 10%
        if (weekend) {
            basePrice = basePrice * 1.10;
        }

        return basePrice;
    }

    // Derived getter - розраховує загальну вартість бронювання
    public double getReservationTotal() {
        return getPrice() * numberOfNights;
    }
}
