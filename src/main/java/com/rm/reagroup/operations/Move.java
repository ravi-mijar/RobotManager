/**
 * 
 */
package com.rm.reagroup.operations;

import com.rm.reagroup.controller.RobotManager;
import com.rm.reagroup.playfield.IShape;
import com.rm.reagroup.playfield.Orientation;
import com.rm.reagroup.playfield.Position;
import com.rm.reagroup.robot.ToyRobot;
import com.rm.reagroup.utils.Constants;

/**
 * This class implements the move operation. 
 * It uses the Shape object passed, and moves the robot accordingly.
 * @author hawk
 *
 */
public class Move implements IOperation {
	
	//The shape on which this robot is supposed to be moved.
	private IShape playfield;
	
	public Move(IShape playfield) {
		this.playfield = playfield;
	}

	/* (non-Javadoc)
	 * @see com.rm.reagroup.operations.IOperation#execute()
	 */
	@Override
	public boolean execute(ToyRobot robot) {
		Position current = robot.getCurrentPosition();
		//first check whether the robot will fall off if this move is executed.
		if(playfield.willFallOff(current)) {
			RobotManager.getLogger().warning(Constants.ROBOT_WILL_FALL);
			return false;
		}
		else {
			//things look OK, let's move the robot.
			if(current.getOrientation() == Orientation.NORTH)
				current.setY(current.getY() + Constants.MOVEBY);
			else if(current.getOrientation() == Orientation.SOUTH)
				current.setY(current.getY() - Constants.MOVEBY);
			else if(current.getOrientation() == Orientation.EAST)
				current.setX(current.getX() + Constants.MOVEBY);
			else if(current.getOrientation() == Orientation.WEST)
				current.setX(current.getX() - Constants.MOVEBY);
			return true;
		}
	}

}
