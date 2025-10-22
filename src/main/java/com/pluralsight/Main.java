package com.pluralsight;

public class Main {
    public static void main(String[] args) {
        //testing our room
        Room hotelRoom = new Room(2, 100.00, false, false);
        //is it available?
        System.out.println("is the room available:" + hotelRoom.isAvailable());
        //if statement similar to above
        if(hotelRoom.isAvailable()){
            System.out.println("The room is available");
        }else{
            System.out.println("no room available");
        }
        //change property to make the room not available
       hotelRoom.setDirty(true);  //  Тепер працює
        //is it available?
        System.out.println("is the room available:" + hotelRoom.isAvailable());

        //testing the reservation
        Reservation pototaReservation = new Reservation("king", 1, false);
        //check the price
        System.out.println(pototaReservation.getPrice());
        //check the reservation total
        System.out.println(pototaReservation.getReservationTotal());
        //change to a weekend
        pototaReservation.setWeekend(true);
        //check the price
        System.out.println(pototaReservation.getPrice());
        //check the reservation total
        System.out.println(pototaReservation.getReservationTotal());
        //change number of nights
        pototaReservation.setNumberOfNights(2);
        //check the reservation total
        System.out.println(pototaReservation.getReservationTotal());

        //test the employee
        Employee hotelEmployee = new Employee(1, "iryna", "Front Desk", 10.00, 40);
        //print out regular hours
        System.out.println(hotelEmployee.getHoursWorked());
        //print out OT hours
        System.out.println(hotelEmployee.getOvertimeHours());
        //print total pay
        System.out.println(hotelEmployee.getTotalPay());
        //add another hour so there is overtime
        hotelEmployee.setHoursWorked(41);  // ✅ Тепер працює
        //print out regular hours
        System.out.println(hotelEmployee.getHoursWorked());
        //print out OT hours
        System.out.println(hotelEmployee.getOvertimeHours());
        //print total pay
        System.out.println(hotelEmployee.getTotalPay());
        //test punch in/out methods
        hotelEmployee.punchIn(13);
        hotelEmployee.punchOut(14);
        System.out.println(hotelEmployee.getHoursWorked());
        //test punch time card method
        hotelEmployee.punchTimeCard(13, 14);  // ✅ Тепер працює
        System.out.println(hotelEmployee.getHoursWorked());
    }
}