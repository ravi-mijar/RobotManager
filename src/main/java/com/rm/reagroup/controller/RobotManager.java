package com.rm.reagroup.controller;

import java.io.IOException;

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

import asg.cliche.Command;
import asg.cliche.Shell;
import asg.cliche.ShellFactory;

public class RobotManager {
	
	//For this JVM instance we want to ensure the playfield doesn't change.
	private static final IShape playfield = new SquareTable(5);//can be modified to pick up from properties file.
	private static ToyRobot robot = null;
	
	@Command
	public void place(int x, int y, String facing) throws InvalidOperationException {
		Orientation orientation = null;
		if(facing.equalsIgnoreCase("north")) 
			orientation = Orientation.NORTH;
		else if(facing.equalsIgnoreCase("south"))
			orientation = Orientation.SOUTH;
		else if(facing.equalsIgnoreCase("west"))
			orientation = Orientation.WEST;
		else if(facing.equalsIgnoreCase("east"))
			orientation = Orientation.EAST;
		IOperation placeOperation = new Place(new Position(x, y), orientation, playfield);
		placeOperation.execute(robot);
	}
	
	@Command
	public void move() throws InvalidOperationException {
		if(robot.isPlacedCorrectly()) {
			IOperation moveOp = new Move(playfield);
			moveOp.execute(robot);
		}
		else {
			System.out.println("Robot isn't placed correctly. Try the place command first.");
		}
	}
	
	@Command(description="Rotate the robot in its place by 90 degrees to the left.")
	public void left() throws InvalidOperationException {
		
		if(robot.isPlacedCorrectly()) {
			IOperation rotateOp = new Rotate(RotateDirection.LEFT);
			rotateOp.execute(robot);
		}
		else {
			System.out.println("Robot isn't placed correctly. Try the place command first.");
		}
	}
	
	@Command(description="Rotate the robot in its place by 90 degrees to the right.")
	public void right() throws InvalidOperationException {
		
		if(robot.isPlacedCorrectly()) {
			IOperation rotateOp = new Rotate(RotateDirection.RIGHT);
			rotateOp.execute(robot);
		}
		else {
			System.out.println("Robot isn't placed correctly. Try the place command first.");
		}
	}
	
	@Command
	public void report() {
		System.out.println(robot);
	}
	
	public static void main(String[] args) {
		robot = ToyRobot.getRobotInstance();
		
		Shell sh = ShellFactory.createConsoleShell("RobotPrompt", "Robotmanager", new RobotManager());
		try {
			sh.commandLoop();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
