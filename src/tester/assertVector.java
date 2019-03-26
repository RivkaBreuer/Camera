package tester;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import primitives.Point3D;
import primitives.Vector;

class assertVector {

	@Test
	void addTest() {
		
		Point3D p1 = new Point3D(1,2,4);
		Point3D p2 = new Point3D(2,4,8);

		Vector v1 = new Vector(p1);
		Vector v2 = new Vector(p2);
		Vector v3 = new Vector(v1.add(v1));
		
		assertEquals(v3,v2);
		
		
	}
	
	@Test
	void subTest() {
		
		Point3D p1 = new Point3D(1,2,4);
		Point3D p2 = new Point3D(2,4,8);

		Vector v1 = new Vector(p1);
		Vector v2 = new Vector(p2);
		Vector v3 = new Vector(v2.substrct(v1));
		
		assertEquals(v3,v1);
		
		
	}
	
	@Test
	void scalarMultiTest() {
		
		Point3D p1 = new Point3D(1,2,4);
		Point3D p2 = new Point3D(2,4,8);

		Vector v1 = new Vector(p1);
		Vector v2 = new Vector(p2);
        double d= v1.scalarMulti(v2);		
		assertEquals(d,42,0.001);
		
		
	}

	@Test
	void moveTest() {
		
		Point3D p1 = new Point3D(1,2,4);
		Point3D p2 = new Point3D(3,4,6);

		Vector v1 = new Vector(p1);
		Vector v2 = new Vector(v1.move(2));
		Vector v3 = new Vector(p2);
 		
		assertEquals(v2,v3);
		
		
	}
	
	
	@Test
	void lengthTest() {
		
		Point3D p1 = new Point3D(1,2,2);

		Vector v1 = new Vector(p1);
		double d = v1.length();
 		
		assertEquals(d,3,0.01);
		
		
	}

	@Test
	void normalizationTest() {
		
		Point3D p1 = new Point3D(1,2,2);
		double x = 0.3333333333333333;
		double y = 0.6666666666666666;
		double z = 0.6666666666666666;

		Point3D p2 = new Point3D(x,y,z);

		Vector v1 = new Vector(p1);
		Vector v2 = new Vector(v1.normalizationVector());
		Vector v3 = new Vector(p2);
 		
		assertEquals(v2,v3);
		
		
	}
	
	
	@Test
	void vectorProductTest() {
		Point3D p1 = new Point3D(2,1,2);
		Point3D p2 = new Point3D(1,2,3);
		Point3D p3 = new Point3D(-1,-4,3);

		Vector v1 = new Vector(p1);
		Vector v2 = new Vector(p2);
		Vector v3 = new Vector(v1.vectorProduct(v2));
		Vector v4 = new Vector(p3);

		assertEquals(v3,v4);

		
	}
	
	@Test
	void addVectorPointTest() {
		
		Point3D p1 = new Point3D(1,2,3);
		Point3D p2 = new Point3D(2,1,0);

		Vector v1 = new Vector(p2);
		
		Point3D p=p1.addPointVector(v1);
		Point3D p3 = new Point3D(3,3,3);

		assertEquals(p3,p);

		
	}
	
	@Test
	void multiInScalarTest() {
		
		Point3D p1 = new Point3D(1,2,3);
		Point3D p2 = new Point3D(2,4,6);

		Vector v1 = new Vector(p1);
		
		Vector v2= new Vector(v1.multiInScalar(2));
		Vector v3= new Vector(p2);

		assertEquals(v2,v3);

		
	}

}
