package be.pxl.collections.opdracht2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RobotTest {
	private Robot robot;
	
	@Before
	public void Before() {
		robot = new Robot("TestBot 3000");
		
		robot.addCommand(Action.ATTACK, "KICK");
		robot.addCommand(Action.ATTACK, "This shouldn't exist", 15);
		robot.addCommand(Action.TALK, "This is the second command.");
	}
	
	@Test
	public void addCommandIncreasesCommandListSize() {
		assertEquals(2, robot.countCommands());
	}
	
	@Test
	public void oldestCommandExecutedFirst(){
		assertEquals("ATTACK > KICK", robot.execute().display());
	}
	
	@Test
	public void commandRemovedAfterExecuted(){
		robot.execute();
		assertEquals(1, robot.countCommands());
	}
	
	@Test
	public void noneCommandIfCommandsEmpty(){
		robot.runCommands();
		assertEquals(Action.NONE, robot.execute().action());
	}
	
	// TODO	implementeer andere tests

}
