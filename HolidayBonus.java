
/*
 * Class: CMSC203
 * Instructor:
 * Description: Calculates the holiday bonus for each store as well as the total holiday bonus for all stores.
 * Due: 11/13/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
* I have not copied the code from a student or any source.
* I have not given my code to any student.
* Print your Name here: Ema Gomez
*/

import java.lang.reflect.Array;
import java.util.Arrays;

public class HolidayBonus {
	
	final static double HIGHESTBONUS = 5000.00;
	final static double LOWESTBONUS = 1000.00;
	final static double OTHERBONUS = 2000.00;
	
	public HolidayBonus () {
		
		
	}
	
	public static double[] calculateHolidayBonus(double[][] data) {
		
        double[] holidayBonus = new double[ data.length ];
        
        for ( int i = 0; i < data.length; i++ ) {
        	for ( int j = 0; j < data[i].length; j++ ) {
        		double lowest = TwoDimRaggedArrayUtility.getLowestInColumn( data, j );
        		double highest = TwoDimRaggedArrayUtility.getHighestInColumn( data, j );
        		
        		if ( data[i][j] <= 0 ) {
        			holidayBonus[i] += 0.00;
        			
        		}
        		
        		else if ( data[i][j] == lowest ) {
        			holidayBonus[i] += LOWESTBONUS;
        			
        		}
        		
        		else if ( data[i][j] == highest ) {
        			holidayBonus[i] += HIGHESTBONUS;
        			
        		}
        		
        		else {
        			holidayBonus[i] += OTHERBONUS;
        			
        		}
        		
        	}
        	
        }
        
        return holidayBonus;
        
	}
	
	public static double calculateTotalHolidayBonus(double[][] data) {
		double[] bonuses = calculateHolidayBonus( data );
		double sum = 0;
		for ( int i = 0; i < bonuses.length; i++ ) {
			sum += bonuses[i];
		}
		return sum;
		
	}
	
}
