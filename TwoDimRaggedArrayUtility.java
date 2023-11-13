
/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: Reads files to create a ragged array that represents the earnings from each store.
 * Due: 11/13/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
* I have not copied the code from a student or any source.
* I have not given my code to any student.
* Print your Name here: Ema Gomez
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility {
	
	public TwoDimRaggedArrayUtility () {
		
	}
	
	public static double[][] readFile(File file) throws FileNotFoundException {
	    final int MAX_ROW = 10;
	    final int MAX_COLUMN = 10;
	    
	    String[][] numArray = new String[MAX_ROW][MAX_COLUMN];

	    try (Scanner scanner = new Scanner(file)) {
	        int numRow = 0;
	        while (scanner.hasNextLine() && numRow < MAX_ROW) {
	            String line = scanner.nextLine();
	            String[] arLine = line.split(" ");
	            int numCol = 0;
	            for (String num : arLine) {
	                if (numCol < MAX_COLUMN) {
	                    numArray[numRow][numCol] = num;
	                    numCol++;
	                }
	            }
	            numRow++;
	        }

	        if (numRow == 0) {
	            return null;
	        }

	        double[][] doubleArray = new double[numRow][];

	        for (int i = 0; i < numRow; i++) {
	            int numCol = 0;
	            while (numCol < MAX_COLUMN && numArray[i][numCol] != null) {
	                numCol++;
	            }

	            doubleArray[i] = new double[numCol];
	            for (int j = 0; j < numCol; j++) {
	                doubleArray[i][j] = Double.parseDouble(numArray[i][j]);
	            }
	        }
	        return doubleArray;
	    } catch (FileNotFoundException error) {
	        throw error;
	    }
	}
	
	public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
		try( PrintWriter writer = new PrintWriter( outputFile )){
			for ( int row = 0; row < data.length; row++ ) {
				for ( int col = 0; col < data[row].length; col++) {
					writer.print(data[row][col]);
					
					if ( col < data[row].length - 1 ) {
						writer.print(" ");
					}
				}
				writer.println();
			}
		}
		
	}
	
	public static double getTotal(double[][] data) {
		double total = 0.0;
		
		for ( int row = 0; row < data.length; row++ ) {
			for ( int col = 0; col < data[row].length; col++) {
				total += data[row][col];
			}
			
		}
		
		return total;
		
	}
	
	public static double getAverage(double[][] data) {
		double total = 0.0;
		double average = 0.0;
		double elements = 0.0;
		
		for ( int row = 0; row < data.length; row++ ) {
			for ( int col = 0; col < data[row].length; col++) {
				total += data[row][col];
				elements ++;
			}
		}
		
		average = total/elements;
		
		return average;
		
	}
	
	public static double getRowTotal(double[][] data, int row) {
		double rowTotal = 0.0;
		
		for ( int col = 0; col < data[row].length; col++ ) {
			rowTotal += data[row][col];
			
		}
		
		return rowTotal;
		
	}
	
	public static double getColumnTotal(double[][] data, int col) {
	    double columnTotal = 0.0;

	    for (int row = 0; row < data.length; row++) {
	        // Check if the column index is within bounds for the current row
	        if (col < data[row].length) {
	            columnTotal += data[row][col];
	        }
	    }

	    return columnTotal;
	}
	
	public static double getHighestInRow(double[][] data, int row) {
		double highestInRow = data[row][0];
		
		for ( int col = 1; col < data[row].length; col++ ) {
			if ( data[row][col] > highestInRow ) {
				highestInRow = data[row][col];
				
			}
		}
		return highestInRow;

	}
	
	public static int getHighestInRowIndex(double[][] data, int row) {
		double highestInRow = data[row][0];
		int highestInRowIndex = 0;
		
		for ( int col = 1; col < data[row].length; col++ ) {
			if ( data[row][col] > highestInRow ) {
				highestInRowIndex = col;
				
			}
		}
		return highestInRowIndex;

		
	}
	
	public static double getLowestInRow(double[][] data, int row) {
		double lowestInRow = data[row][0];
		
		for ( int col = 1; col < data[row].length; col++ ) {
			if ( data[row][col] < lowestInRow ) {
				lowestInRow = data[row][col];
				
			}
		}
		return lowestInRow;
		
	}
	
	public static int getLowestInRowIndex(double[][] data, int row) {
		double lowestInRow = data[row][0];
		int lowestInRowIndex = 0;
		
		for ( int col = 1; col < data[row].length; col++ ) {
			if ( data[row][col] < lowestInRow ) {
				lowestInRowIndex = col;
				
			}
		}
		return lowestInRowIndex;
		
	}
	
	public static double getHighestInColumn(double[][] data, int col) {
	    double highest = 0.0;
	    boolean valuePresent = false;

	    for (int i = 0; i < data.length; i++) {
	        if (col < data[i].length) {
	            if (!valuePresent || (data[i][col] > highest)) {
	                highest = data[i][col];
	                valuePresent = true;
	            }
	        }
	    }

	    if (valuePresent) {
	        return highest;
	    } else {
	        return 0;
	    }
	}
	
	public static int getHighestInColumnIndex(double[][] data, int col) {
		double highestInColumn = data[0][col];
		int highestInColumnIndex = 0;
		
		for ( int row = 1; row < data.length; row++ ) {
			if ( data[row][col] > highestInColumn ) {
				highestInColumnIndex = row;
				
			}
		}
		return highestInColumnIndex;
		
	}
	
	public static double getLowestInColumn(double[][] data, int col) {
	    double lowest = 0.0;
	    boolean valuePresent = false;

	    for (int i = 0; i < data.length; i++) {
	        if (col < data[i].length) {
	            if (!valuePresent || (data[i][col] < lowest)) {
	                lowest = data[i][col];
	                valuePresent = true;
	            }
	        }
	    }

	    if (valuePresent) {
	        return lowest;
	    } else {
	        return 0;
	    }
	}
	
	public static int getLowestInColumnIndex(double[][] data, int col) {
		double lowestInColumn = data[0][col];
		int lowestInColumnIndex = 0;
		
		for ( int row = 1; row < data.length; row++ ) {
			if ( data[row][col] < lowestInColumn ) {
				lowestInColumnIndex = row;
				
			}
		}
		return lowestInColumnIndex;
		
	}
	
	public static double getHighestInArray(double[][] data) {
		
		double highestInArray = data[0][0];
		
		for ( int row = 0; row < data.length; row++ ) {
			for ( int col = 0; col < data[row].length; col++) {
				if ( data[row][col] > highestInArray ) {
					highestInArray = data[row][col];
				}
			}
			
		}
		
		return highestInArray;
		
	}
	
	public static double getLowestInArray(double[][] data) {
		double lowestInArray = data[0][0];
		
		for ( int row = 0; row < data.length; row++ ) {
			for ( int col = 0; col < data[row].length; col++) {
				if ( data[row][col] < lowestInArray ) {
					lowestInArray = data[row][col];
				}
			}
			
		}
		
		return lowestInArray;
		
	}
	
}
