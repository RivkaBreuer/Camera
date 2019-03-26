package tester;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import primitives.Point2D;

class assertPoint2DTest {

	@Test
	void equalsTest() {
		Point2D p1= new Point2D(2,3);
		Point2D p2= new Point2D(2,3);
		Point2D p3= new Point2D(1,2);
		
		assertTrue(p1.equals(p2));
		assertFalse(p2.equals(p3));
		
	}

}
