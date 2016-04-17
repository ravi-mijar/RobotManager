/**
 * 
 */
package com.rm.reagroup.utils;

/**
 * This interface will declare all the constant strings.
 * @author hawk
 *
 */
public class Constants {
	
	private Constants() {}
	
	public static final String NORTH = "north";
	public static final String SOUTH = "south";
	public static final String WEST = "west";
	public static final String EAST = "east";
	
	public static final String LOG_FILE = "./robotManager.log";
	
	public static final int MOVEBY = 1;//Can be filled by a system property as well.
	public static final int SQUARE_TABLE_SIZE = 5;
	
	//User visible message constants
	public static final String INCORRECTLY_PLACED_ROBOT = "Robot isn't placed correctly. Try the place command first.";
	public static final String ROBOT_WILL_FALL = "The robot will fall off the playfield with this move. Ignoring command.";
	public static final String INVALID_DIRECTION = "The entered direction was invalid. Only these words are allowed: "+NORTH+
			","+SOUTH+","+WEST+","+EAST;
	public static final String POSITION_OUT_OF_BOUNDS = "Entered position is out of bounds. Only values between 0-"+(SQUARE_TABLE_SIZE-1)
			+ " (both inclusive) are allowed.";
}
