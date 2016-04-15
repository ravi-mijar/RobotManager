package com.rm.reagroup.operations;

import com.rm.reagroup.robot.ToyRobot;

public interface IOperation {
	public boolean execute(ToyRobot robot) throws InvalidOperationException;
}
