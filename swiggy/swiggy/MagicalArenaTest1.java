/**
 * 
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 */
public class MagicalArenaTest1 {

	
	 MagicalArena arena;
	    Player playerA;
	    Player playerB;

	    @Before
	   public void setUp() {
	        playerA = new Player(50, 5, 10);
	        playerB = new Player(100, 10, 5);
	        arena = new MagicalArena(playerA, playerB);
	    }

	    @Test
	   public void testInitialization() {
	        assertEquals(50, arena.getPlayerA().health);
	        assertEquals(5, arena.getPlayerA().strength);
	        assertEquals(10, arena.getPlayerA().attack);

	        assertEquals(100, arena.getPlayerB().health);
	        assertEquals(10, arena.getPlayerB().strength);
	        assertEquals(5, arena.getPlayerB().attack);
	    }

	    @Test
	   public void testDiceValueInRange() {
	        int diceValue = arena.getDiceValue();
	        assertTrue(diceValue >= 1 && diceValue <= 6);
	    }

	    @Test
	   public void testUpdatePlayer() {
	        arena.updatePlayer(3, 4, "PLAYER_A");
	        assertTrue(arena.getPlayerB().health <= 100);

	        arena.updatePlayer(2, 3, "PLAYER_B");
	        assertTrue(arena.getPlayerA().health <= 50);
	    }

	    @Test
	   public void testStartGame() {
	        arena.start();
	        assertTrue(arena.getPlayerA().health <= 0 || arena.getPlayerB().health <= 0);
	    }

}
