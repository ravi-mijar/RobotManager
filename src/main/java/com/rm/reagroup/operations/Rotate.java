/**
 * 
 */
package com.rm.reagroup.operations;

import com.rm.reagroup.robot.ToyRobot;

/**
 * @author hawk
 *
 */
public class Rotate implements IOperation {

	//Let's assume we the default direction as left.
	private RotateDirection rotateDir = RotateDirection.LEFT;
	
	
	/* (non-Javadoc)
	 * @see com.rm.reagroup.operations.IOperation#execute(com.rm.reagroup.robot.ToyRobot)
	 */
	@Override
	public boolean execute(ToyRobot robot) throws InvalidOperationException {
		// TODO Auto-generated method stub
		robot.getOrientation();
		//robot.setOrientation(orientation);
		
		return false;
	}

}
