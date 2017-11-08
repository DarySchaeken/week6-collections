package be.pxl.collections.opdracht2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PrioBotTest {
	private PrioBot priobot;
	
	@Before
	public void Before() {
		priobot = new PrioBot("TestBot 3000");
		
		priobot.addCommand(Action.ATTACK, "KICK");
		priobot.addCommand(Action.MOVE, "This should exist", 15);
		priobot.addCommand(Action.TALK, "This is the second command.");
	}
	
	@Test
	public void executeHighestPriorityFirst(){
		assertEquals(Action.MOVE, priobot.execute().action());
	}
	
	@Test
	public void executeInInsertOrder(){
		priobot.execute();
		assertEquals(Action.ATTACK, priobot.execute().action());
		assertEquals(Action.TALK, priobot.execute().action());
	}
}
