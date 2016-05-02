package com.rm.reagroup.utils;

import com.rm.reagroup.playfield.SquareTable;
import com.rm.reagroup.robot.Orientation;

/**
 * This class will declare all the constant strings.
 * @author hawk
 *
 */
public final class Constants {
	
	//We have everything static here. Subdue the default constructor.
	private Constants() {}
	
	public static final String LOG_FILE = "./robotManager.log";
	
	public static final int MOVEBY = 1;
	
	//User visible message constants
	public static final String INCORRECTLY_PLACED_ROBOT = "Robot isn't placed correctly. Try the place command first.";
	public static final String ROBOT_WILL_FALL = "The robot will fall off the playfield with this move. Ignoring command.";
	public static final String INVALID_DIRECTION = "The entered direction was invalid. Only these words are allowed: "+Orientation.NORTH+
			","+Orientation.SOUTH+","+Orientation.WEST+","+Orientation.EAST;
	public static final String INVALID_ROTATE_DIRECTION = "The entered direction was invalid.";
	public static final String POSITION_OUT_OF_BOUNDS = "Entered position is out of bounds. Only values between 0-"+(SquareTable.SQUARE_TABLE_SIZE-1)
			+ " (both inclusive) are allowed.";
}
