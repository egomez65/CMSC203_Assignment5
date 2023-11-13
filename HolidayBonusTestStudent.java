
/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: Tests the calculateHolidayBonus and calculateTotalHolidayBonus methods.
 * Due: 11/13/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
* I have not copied the code from a student or any source.
* I have not given my code to any student.
* Print your Name here: Ema Gomez
*/

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HolidayBonusTestStudent {

	@Test
	void testHolidayBonus() {
		
	}

	@Test
	void testCalculateHolidayBonus() {
		double[][] dataSet1 = { { 5, 3, 3 }, { 2, 8 }, { 9, 2, 6 } };
		
		try {
			double[] result = HolidayBonus.calculateHolidayBonus(dataSet1);
			assertEquals(5000.0, result[0], .001);
			assertEquals(6000.0, result[1], .001);
			assertEquals(11000.0, result[2], .001);
		} catch (Exception e) {
			fail("This should not have caused an Exception");
		}

	}

	@Test
	void testCalculateTotalHolidayBonus() {
		double[][] dataSet1 = { { 5, 3, 3 }, { 2, 8 }, { 9, 2, 6 } };
		assertEquals(22000.0, HolidayBonus.calculateTotalHolidayBonus(dataSet1), .001);
	
	}

}