package com.pluralsight;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void testCheckInSuccess() {
        Room room = new Room(2, 100.0, false, false);
        room.checkIn();
        assertTrue(room.isOccupied());
        assertTrue(room.isDirty());
    }

    @Test
    void testCheckInFailsIfOccupied() {
        Room room = new Room(2, 100.0, true, false);
        room.checkIn();
        assertTrue(room.isOccupied()); // still occupied
        assertFalse(room.isAvailable());
    }

    @Test
    void testCheckInFailsIfDirty() {
        Room room = new Room(2, 100.0, false, true);
        room.checkIn();
        assertFalse(room.isAvailable());
        assertFalse(room.isOccupied()); // should remain unoccupied
    }

    @Test
    void testCheckOutSuccess() {
        Room room = new Room(2, 100.0, true, false);
        room.checkOut();
        assertFalse(room.isOccupied());
        assertTrue(room.isDirty()); // room should still be dirty
    }

    @Test
    void testCheckOutFailsIfNotOccupied() {
        Room room = new Room(2, 100.0, true, false);
        room.checkOut();
        assertFalse(room.isOccupied()); // still unoccupied
    }

    @Test
    void testCleanRoomSuccess() {
        Room room = new Room(2, 100.0, false, true);
        room.cleanRoom();
        assertFalse(room.isDirty());
        assertTrue(room.isAvailable());
    }

    @Test
    void testCleanRoomFailsIfOccupied() {
        Room room = new Room(2, 100.0, true, true);
        room.cleanRoom();
        assertTrue(room.isDirty()); // still dirty
    }
}
