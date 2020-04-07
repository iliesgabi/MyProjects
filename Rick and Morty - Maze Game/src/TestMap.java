import junit.framework.TestCase;

public class TestMap extends TestCase{
	public Map map=new Map();
	public void testSetMap() {
		map.setMap('a', 1, 1);
		assertEquals("a",map.getMap(1, 1));
		
		map.setMap('a', 2, 2);
		assertEquals("a",map.getMap(2, 2));
	}
	
	public void testGetMap() {
		assertEquals("w",map.getMap(0, 0));
	}
}
