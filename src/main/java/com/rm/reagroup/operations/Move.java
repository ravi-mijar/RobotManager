/**
 * 
 */
package com.rm.reagroup.operations;

import com.rm.reagroup.playfield.IShape;
import com.rm.reagroup.playfield.Position;
import com.rm.reagroup.robot.ToyRobot;

/**
 * @author hawk
 *
 */
public class Move implements IOperation {
	
	private static final int MOVEBY = 1;//Can be filled by a system property as well.
	private IShape playfield;
	
	public Move(IShape playfield) {
		this.playfield = playfield;
	}

	/* (non-Javadoc)
	 * @see com.rm.reagroup.operations.IOperation#execute()
	 */
	@Override
	public boolean execute(ToyRobot robot) throws InvalidOperationException {
		Position current = robot.getCurrentPosition();
		if(playfield.willFallOff(current, robot.getOrientation()))
			return false;
		else {
			robot.setCurrentPosition(new Position(current.getX() + MOVEBY, current.getY() + MOVEBY));
			return true;
		}
	}

}
