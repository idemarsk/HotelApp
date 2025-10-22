package com.pluralsight;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void punchOut_afterPunchIn_updatesHoursWorkedCorrectly() {
        Employee employee = new Employee(101, "Alice", "Sales", 20.0, 0.0);

        double startTime = 9.0;   // 9:00 AM
        double endTime = 17.0;    // 5:00 PM
        double expectedShiftHours = endTime - startTime;

        employee.punchIn(startTime);
        employee.punchOut(endTime);

        assertEquals(expectedShiftHours, employee.getHoursWorked(), 0.01);
    }

    @Test
    void punchOut_withoutPunchIn_doesNotUpdateHoursWorked() {
        Employee employee = new Employee(102, "Eric", "Marketing", 22.0, 0.0);

        double endTime = 17.0; // trying to punch out without punching in
        employee.punchOut(endTime);

        assertEquals(0.0, employee.getHoursWorked(), 0.01);
    }

    @Test
    void multiplePunchInOut_accumulatesHoursWorked() {
        Employee employee = new Employee(103, "Iryna", "Support", 18.0, 0.0);

        employee.punchIn(8.0);
        employee.punchOut(12.0); // 4 hours

        employee.punchIn(13.0);
        employee.punchOut(17.0); // 4 hours

        assertEquals(8.0, employee.getHoursWorked(), 0.01);
    }
}
