import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest1 {

	
	Player player;

    @Before
   public void setUp() {
        player = new Player(50, 5, 10);
    }

    @Test
    public void testPlayerInitialization() {
        assertEquals(50, player.health);
        assertEquals(5, player.strength);
        assertEquals(10, player.attack);
    }

}
