/**
 * 
 */
package com.rm.reagroup.test.operation;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rm.reagroup.operations.InvalidOperationException;
import com.rm.reagroup.operations.Move;
import com.rm.reagroup.operations.Place;
import com.rm.reagroup.playfield.IShape;
import com.rm.reagroup.playfield.Orientation;
import com.rm.reagroup.playfield.Position;
import com.rm.reagroup.playfield.SquareTable;
import com.rm.reagroup.robot.ToyRobot;

/**
 * @author hawk
 *
 */
public class MoveOperationTest {

	private static ToyRobot robot = ToyRobot.getRobotInstance();
	private static IShape playfield = new SquareTable(5);
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testValidMove() {
		Place p = new Place(new Position(3, 3), Orientation.EAST, playfield);
		
		try {
			p.execute(robot);
			new Move(playfield).execute(robot);
			assert(true);
		}
		catch(InvalidOperationException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testInvalidMove() {
		
	}
	
}
