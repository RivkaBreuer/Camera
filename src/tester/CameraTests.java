package tester;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import elements.Camera;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

class CameraTests {

	@Test
	void throughPixelTest() {
		Point3D p0 = new Point3D (1,1,1);
		Vector right = new Vector(new Point3D(1,2,3));
		Vector to=new Vector(new Point3D(2,1,2));
		Camera c= new Camera(p0,to,right);
		Ray r1=new Ray(p0,new Vector(new Point3D(11,21,5)));
		Ray r2= new Ray(c.constructRayThroughPixel(4,4,2,2,2,24,24));
		
		assertEquals(r1,r2);
	}

}
