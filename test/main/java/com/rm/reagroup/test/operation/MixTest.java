/**
 * 
 */
package com.rm.reagroup.test.operation;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rm.reagroup.operations.Move;
import com.rm.reagroup.operations.Place;
import com.rm.reagroup.operations.Rotate;
import com.rm.reagroup.operations.RotateDirection;
import com.rm.reagroup.playfield.IShape;
import com.rm.reagroup.playfield.Orientation;
import com.rm.reagroup.playfield.Position;
import com.rm.reagroup.playfield.SquareTable;
import com.rm.reagroup.robot.ToyRobot;

/**
 * This test will fire operations on the robot in a seemingly 
 * random order. 
 * @author hawk
 *
 */
public class MixTest {

	private static ToyRobot robot = ToyRobot.getRobotInstance();
	private static IShape playfield = new SquareTable(15);
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("setting up.");
		robot = ToyRobot.getRobotInstance();
		playfield = new SquareTable(15);
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
	public void test() {
		System.out.println("mixTest");
		//place it within the table
		Place p = new Place(new Position(0, 0, Orientation.EAST), playfield);

		p.execute(robot);
		System.out.println("Original situation: " + robot);
		Move m = new Move(playfield);
		Rotate rLeft = new Rotate(RotateDirection.LEFT);
		Rotate rRight = new Rotate(RotateDirection.RIGHT);
		for (int i= 0; i<15;i++) {
			System.out.println("#"+i);
			m.execute(robot);
			System.out.println(robot);
			if(i%3 == 0) {
				rRight.execute(robot);
				System.out.println(robot);
			}
			if(i%4 == 0) {
				rLeft.execute(robot);
				System.out.println(robot);
			}
		}
		assertTrue(robot.isPlacedCorrectly());
	}

}
