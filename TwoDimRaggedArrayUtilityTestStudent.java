
/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: Tests all the methods from the TwoDimRaggedArrayUtility class.
 * Due: 11/13/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
* I have not copied the code from a student or any source.
* I have not given my code to any student.
* Print your Name here: Ema Gomez
*/

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

class TwoDimRaggedArrayUtilityTestStudent {

	@Test
	void testTwoDimRaggedArrayUtility() {

	}

	@Test
	void testReadFile() {
		try {
            double[][] dataSet1 = {{1, 2, 3}, {4, 5}, {6, 7, 8}};
            File file = new File("dataSet1.txt");
            double[][] result = TwoDimRaggedArrayUtility.readFile(file);

            assertArrayEquals(dataSet1, result);

        } catch (FileNotFoundException e) {

        }
	}

	@Test
	void testWriteToFile() {
		try {
            double[][] blank = {{1, 2, 3}, {4, 5}, {6, 7, 8}};
            File file = new File("\"I:\\Users\\ema\\Downloads\\UMD\\CMSC203\\Assignment 5\\blank.txt\"");
            TwoDimRaggedArrayUtility.writeToFile( blank, file );
            
            
            assertArrayEquals( blank, TwoDimRaggedArrayUtility.readFile(file));

        } catch (FileNotFoundException e) {

        }
	}

	@Test
	void testGetTotal() {
		double[][] dataSet1 = {{1,2,3},{4,5},{6,7,8,9}};
		assertEquals(45.0,TwoDimRaggedArrayUtility.getTotal(dataSet1),.001);
	}

	@Test
	void testGetAverage() {
		double[][] dataSet1 = {{1,2,3},{4,5},{6,7,8,9}};
		assertEquals(5.0,TwoDimRaggedArrayUtility.getAverage(dataSet1),.001);
	}

	@Test
	void testGetRowTotal() {
		double[][] dataSet1 = {{1,2,3},{4,5},{6,7,8,9}};
		assertEquals(9.0,TwoDimRaggedArrayUtility.getRowTotal(dataSet1,1),.001);
	}

	@Test
	void testGetColumnTotal() {
		double[][] dataSet1 = {{1,2,3},{4,5},{6,7,8,9}};
		assertEquals(11.0,TwoDimRaggedArrayUtility.getColumnTotal(dataSet1,0),.001);
	}

	@Test
	void testGetHighestInRow() {
		double[][] dataSet1 = {{1,2,3},{4,5},{6,7,8,9}};
		assertEquals( 3.0 ,TwoDimRaggedArrayUtility.getHighestInRow(dataSet1,0),.001);
	}

	@Test
	void testGetHighestInRowIndex() {
		double[][] dataSet1 = {{1,2,3},{4,5},{6,7,8,9}};
		assertEquals( 2 ,TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet1,0),.001);
	}

	@Test
	void testGetLowestInRow() {
		double[][] dataSet1 = {{1,2,3},{4,5},{6,7,8,9}};
		assertEquals( 1.0 ,TwoDimRaggedArrayUtility.getLowestInRow(dataSet1,0),.001);
	}

	@Test
	void testGetLowestInRowIndex() {
		double[][] dataSet1 = {{1,2,3},{4,5},{6,7,8,9}};
		assertEquals( 0 ,TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet1,0),.001);
	}

	@Test
	void testGetHighestInColumn() {
		double[][] dataSet1 = {{9,5,3},{6,8},{3,2,5,4}};
		assertEquals( 9.0 ,TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1,0),.001);
	}

	@Test
	void testGetHighestInColumnIndex() {
		double[][] dataSet1 = {{9,5,3},{6,8},{3,2,5,4}};
		assertEquals( 1 ,TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet1,1),.001);
	}

	@Test
	void testGetLowestInColumn() {
		double[][] dataSet1 = {{9,5,3},{6,8},{3,2,5,4}};
		assertEquals( 3.0 ,TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1,0),.001);
	}

	@Test
	void testGetLowestInColumnIndex() {
		double[][] dataSet1 = {{9,5,3},{6,8},{3,2,5,4}};
		assertEquals( 2 ,TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1,0),.001);
	}

	@Test
	void testGetHighestInArray() {
		double[][] dataSet1 = {{9,5,3},{6,8},{3,2,5,4}};
		assertEquals( 9 ,TwoDimRaggedArrayUtility.getHighestInArray(dataSet1),.001);
	}

	@Test
	void testGetLowestInArray() {
		double[][] dataSet1 = {{9,5,3},{6,8},{3,2,5,4}};
		assertEquals( 2 ,TwoDimRaggedArrayUtility.getLowestInArray(dataSet1),.001);
	}

}
