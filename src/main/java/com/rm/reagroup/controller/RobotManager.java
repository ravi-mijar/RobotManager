package com.rm.reagroup.controller;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import com.rm.reagroup.operations.IOperation;
import com.rm.reagroup.operations.InvalidOperationException;
import com.rm.reagroup.operations.Move;
import com.rm.reagroup.operations.Place;
import com.rm.reagroup.operations.Rotate;
import com.rm.reagroup.operations.RotateDirection;
import com.rm.reagroup.playfield.IShape;
import com.rm.reagroup.playfield.Orientation;
import com.rm.reagroup.playfield.Position;
import com.rm.reagroup.playfield.SquareTable;
import com.rm.reagroup.robot.ToyRobot;
import com.rm.reagroup.utils.Constants;

import asg.cliche.Command;
import asg.cliche.Param;
import asg.cliche.Shell;
import asg.cliche.ShellFactory;

public class RobotManager {
	
	//For this JVM instance we want to ensure the playfield doesn't change.
	private static final IShape playfield = new SquareTable(5);//can be modified to pick up from properties file.
	private static ToyRobot robot = null;
	
	private static final Logger LOG = Logger.getLogger("RobotManager");
	private static Handler fileHandler = null;
	
	public RobotManager() {
		try {
			//Get the basics in place.
			fileHandler = new FileHandler(Constants.LOG_FILE);
			Formatter simpleFormatter = new SimpleFormatter();

			fileHandler.setFormatter(simpleFormatter);
			LOG.addHandler(fileHandler);
			
			//initiate robot
			robot = ToyRobot.getRobotInstance();
		}
		catch (IOException e) {
			System.err.println("Couldn't initialize log file." + e.getMessage());
		}
	}
	
	@Command(description = "This command places the robot on the playfield in a particular position and orientation."
			+ " Placements outside the playfield are ignored.", abbrev="pl")
	public void place(@Param(description = "X coordinate of robot's position. (0-4)", name="x")int x,
					  @Param(description = "Y coordinate of robot's position. (0-4)", name="y")int y,
					  @Param(description = "Direction the robot should face. (NORTH, SOUTH, EAST, WEST)", name="facing")String facing) throws InvalidOperationException {
		LOG.entering(this.getClass().getName(), "place", report());
		Orientation orientation = null;
		if(Constants.NORTH.equalsIgnoreCase(facing)) 
			orientation = Orientation.NORTH;
		else if(Constants.SOUTH.equalsIgnoreCase(facing))
			orientation = Orientation.SOUTH;
		else if(Constants.WEST.equalsIgnoreCase(facing))
			orientation = Orientation.WEST;
		else if(Constants.EAST.equalsIgnoreCase(facing))
			orientation = Orientation.EAST;
		IOperation placeOperation = new Place(new Position(x, y, orientation), playfield);
		if(placeOperation.execute(robot))
			report();
	}
	
	@Command(description="This command moves the robot 1 unit in the direction it is facing. Movements"
			+ " resulting in the robot falling off the playfield are ignored.", abbrev="mv")
	public void move() throws InvalidOperationException {
		LOG.entering(this.getClass().getName(), "move", report());
		if(robot.isPlacedCorrectly()) {
			IOperation moveOp = new Move(playfield);
			if(moveOp.execute(robot))
				report();
		}
		else {
			LOG.warning(Constants.INCORRECTLY_PLACED_ROBOT);
		}
	}
	
	@Command(description="Rotate the robot in its place by 90 degrees to the left.", abbrev="l")
	public void left() throws InvalidOperationException {
		LOG.entering(this.getClass().getName(), "left", report());
		if(robot.isPlacedCorrectly()) {
			IOperation rotateOp = new Rotate(RotateDirection.LEFT);
			if(rotateOp.execute(robot)) 
				report();
		}
		else {
			LOG.warning(Constants.INCORRECTLY_PLACED_ROBOT);
		}
	}
	
	@Command(description="Rotate the robot in its place by 90 degrees to the right.", abbrev="r")
	public void right() throws InvalidOperationException {
		LOG.entering(this.getClass().getName(), "right", report());
		if(robot.isPlacedCorrectly()) {
			IOperation rotateOp = new Rotate(RotateDirection.RIGHT);
			if(rotateOp.execute(robot))
				report();
		}
		else {
			LOG.warning(Constants.INCORRECTLY_PLACED_ROBOT);
		}
	}
	
	@Command(description="Returns the current position of the robot.", abbrev="re")
	public String report() {
		
		if(robot != null && robot.isPlacedCorrectly()) {
			LOG.info(robot.toString());
			return robot.toString();
		}
		else {
			LOG.info(Constants.INCORRECTLY_PLACED_ROBOT);
			return Constants.INCORRECTLY_PLACED_ROBOT;
		}
	}
	
	public static Logger getLogger() {
		return LOG;
	}
	
	public static void main(String[] args) {
		try {
			Shell sh = ShellFactory.createConsoleShell("RobotPrompt", "Robotmanager", new RobotManager());

			sh.commandLoop();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
