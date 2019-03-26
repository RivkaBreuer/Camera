package tester;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import primitives.Coordinate;

class assertCoordinateTest {

	@Test
	void addTest() {
		
		Coordinate c1= new Coordinate(6);
		Coordinate c2= new Coordinate(3.5);
		double sum = c1.add(c2).getCoordinate();
		
		assertEquals(9.5,sum,0.001);
	
	}
	
	@Test
	void subTest() {
		
		Coordinate c1= new Coordinate(6);
		Coordinate c2= new Coordinate(3.5);
		double sum = c1.substrct(c2).getCoordinate();
		
		assertEquals(2.5,sum,0.001);
	
	}
	
	
	@Test
	void equalTest() {
		
		Coordinate c1= new Coordinate(6);
		Coordinate c2= new Coordinate(6.0);
		Boolean b = c1.equals(c2);
		Boolean b1 = c1.equals(c1.substrct(c2));
		
		assertTrue(b);
		assertFalse(b1);
	
	}

}
