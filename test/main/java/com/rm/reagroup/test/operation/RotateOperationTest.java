/**
 * 
 */
package com.rm.reagroup.test.operation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rm.reagroup.operations.IOperation;
import com.rm.reagroup.operations.Place;
import com.rm.reagroup.operations.Rotate;
import com.rm.reagroup.operations.RotateDirection;
import com.rm.reagroup.playfield.IShape;
import com.rm.reagroup.playfield.Orientation;
import com.rm.reagroup.playfield.Position;
import com.rm.reagroup.playfield.SquareTable;
import com.rm.reagroup.robot.ToyRobot;

/**
 * This class will test the rotation operations on the robot.
 * @author hawk
 *
 */
public class RotateOperationTest {

	private static ToyRobot robot = ToyRobot.getRobotInstance();
	private static IShape playfield = new SquareTable(15);
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("setting up.");
		robot = ToyRobot.getRobotInstance();
		playfield = new SquareTable(5);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		robot.setCurrentPosition(null);
		robot = null;
		System.out.println("tearing down");
	}

	@Test
	public void testRotateLeft() {
		System.out.println("testRotateLeft");
		//place it within the table
		Place p = new Place(new Position(3, 3, Orientation.EAST), playfield);

		p.execute(robot);
		IOperation rLeft = new Rotate(RotateDirection.LEFT);
		rLeft.execute(robot);
		System.out.println(robot);
		rLeft.execute(robot);
		System.out.println(robot);
		rLeft.execute(robot);
		System.out.println(robot);
		rLeft.execute(robot);
		System.out.println(robot);
		rLeft.execute(robot);
		System.out.println(robot);
	}
	@Test
	public void testRotateRight() {
		System.out.println("testRotateRight");
		//place it within the table
		Place p = new Place(new Position(3, 3, Orientation.EAST), playfield);

		p.execute(robot);
		System.out.println("Original situation: " + robot);
		Rotate rRight = new Rotate(RotateDirection.RIGHT);
		rRight.execute(robot);
		System.out.println(robot);
		rRight.execute(robot);
		System.out.println(robot);
		rRight.execute(robot);
		System.out.println(robot);
		rRight.execute(robot);
		System.out.println(robot);
		rRight.execute(robot);
		System.out.println(robot);
	}
	
	@Test
	public void testMixitUp() {
		System.out.println("testMixitUp");
		//place it within the table
		Place p = new Place(new Position(3, 3, Orientation.EAST), playfield);

		p.execute(robot);
		System.out.println("Original situation: " + robot + " + right");
		Rotate rRight = new Rotate(RotateDirection.RIGHT);
		Rotate rLeft = new Rotate(RotateDirection.LEFT);
		rRight.execute(robot);
		System.out.println(robot + " + left");
		rLeft.execute(robot);
		System.out.println(robot + " + right");
		rRight.execute(robot);
		System.out.println(robot + " + right");
		rRight.execute(robot);
		System.out.println(robot + " + left");
		rLeft.execute(robot);
		System.out.println(robot);
	}
}
