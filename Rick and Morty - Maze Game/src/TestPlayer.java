import junit.framework.TestCase;

public class TestPlayer extends TestCase{
	public Player player=new Player();
	public void testMove()
	{
		player.move(2,3);
		assertEquals(3,player.getTileX());
		assertEquals(4,player.getTileY());
		
		player.move(-1,-1);
		assertEquals(2,player.getTileX());
		assertEquals(3,player.getTileY());
	}
	
	public void testSetTileX() {
		player.setTileX(4);
		assertEquals(4,player.getTileX());
		player.setTileX(5);
		assertEquals(5,player.getTileX());
	}

	public void testSetTileY() {
		player.setTileY(4);
		assertEquals(4,player.getTileY());
		player.setTileY(5);
		assertEquals(5,player.getTileY());
	}
	
	public void testGetCastraveti() {
		assertEquals(0, player.getCastraveti());
	}

	public void testSetCastraveti() {
		player.setCastraveti(5);
		assertEquals(5, player.getCastraveti());
		player.setCastraveti(3);
		assertEquals(3, player.getCastraveti());
	}
}
