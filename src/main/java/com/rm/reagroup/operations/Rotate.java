/**
 * 
 */
package com.rm.reagroup.operations;

import java.util.Arrays;

import com.rm.reagroup.playfield.Orientation;
import com.rm.reagroup.robot.ToyRobot;

/**
 * @author hawk
 *
 */
public class Rotate implements IOperation {

	//Let's assume the default direction as left.
	private RotateDirection rotateDir;
	
	public Rotate(RotateDirection r) {
		this.rotateDir = r;
	}
	
	
	/* (non-Javadoc)
	 * @see com.rm.reagroup.operations.IOperation#execute(com.rm.reagroup.robot.ToyRobot)
	 */
	@Override
	public boolean execute(ToyRobot robot) throws InvalidOperationException {
		if(this.rotateDir == RotateDirection.LEFT) {
			robot.setOrientation(robot.getOrientation().left());
			return true;
		}
		else if(this.rotateDir == RotateDirection.RIGHT) {
			robot.setOrientation(robot.getOrientation().right());
			return true;
		}
		else
			return false;
	}

}
