package tester;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import primitives.Point3D;

class assertPoint3DTest {

	@Test
	void addTest() {
		Point3D p1= new Point3D(2,3,3);
		Point3D p2= new Point3D(1,2,3);	
		Point3D p3= p1.add(p2);
		
		assertEquals(p3.getX().getCoordinate(),3,0.01);
		assertEquals(p3.getY().getCoordinate(),5,0.01);
		assertEquals(p3.getZ().getCoordinate(),6,0.01);
	
	}
	
	@Test
	void subTest() {
		Point3D p1= new Point3D(2,3,3);
		Point3D p2= new Point3D(1,2,3);	
		Point3D p3= p1.substrct(p2);
		
		assertEquals(p3.getX().getCoordinate(),1,0.01);
		assertEquals(p3.getY().getCoordinate(),1,0.01);
		assertEquals(p3.getZ().getCoordinate(),0,0.01);
	
	}
	
	@Test
	void distanceTest() {
		Point3D p1= new Point3D(2,3,3);
		Point3D p2= new Point3D(1,2,3);	
		double d= p1.distance(p2);
		
		assertEquals(d,Math.sqrt(2),0.1);
		
	
	}
	
	@Test
	void equalsTest() {
		Point3D p1= new Point3D(2,3,3);
		Point3D p2= new Point3D(2,3,3);
		Point3D p3= new Point3D(1,2,3);
		
		assertTrue(p1.equals(p2));
		assertFalse(p2.equals(p3));
		
	}
	
	@Test
	void addDoubleTest() {
		Point3D p1= new Point3D(2,3,3);
		Point3D p2= new Point3D(4,5,5);
		Point3D p3= new Point3D(p1.addDouble(2));
		
		assertTrue(p2.equals(p3));
		
	}

}
