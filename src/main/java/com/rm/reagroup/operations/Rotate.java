/**
 * 
 */
package com.rm.reagroup.operations;

import com.rm.reagroup.playfield.Position;
import com.rm.reagroup.robot.ToyRobot;

/**
 * This class provides implementation of the rotate operation, in which a robot is rotated 
 * to the left or right by 90 degrees in its current position.
 * @author hawk
 *
 */
public class Rotate implements IOperation {

	//Direction to rotate to
	private RotateDirection rotateDir;
	
	public Rotate(RotateDirection r) {
		this.rotateDir = r;
	}
	
	
	/* (non-Javadoc)
	 * @see com.rm.reagroup.operations.IOperation#execute(com.rm.reagroup.robot.ToyRobot)
	 */
	@Override
	public boolean execute(ToyRobot robot) {
		//Get the current position of the robot.
		Position current = robot.getCurrentPosition();
		if(this.rotateDir == RotateDirection.LEFT) {
			//if the new rotate direction was left, call appropriate method on the orientation enum
			current.setOrientation(current.getOrientation().left());
			return true;
		}
		else if(this.rotateDir == RotateDirection.RIGHT) {
			//if the new rotate direction was right, call appropriate method on the orientation enum
			current.setOrientation(current.getOrientation().right());
			return true;
		}
		// looks like invalid input
		else
			return false;
	}

}
