package tester;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import geometries.Plane;
import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

class assertPlane {

	@Test
	void normalTest() {
	Color c = Color.green;	
	Point3D p1= new Point3D(1,2,3);
	Point3D p2= new Point3D(2,3,6);
	Vector v1 = new Vector(p2);
	Material m = new Material();
	Plane p = new Plane(c,p2,v1,m);
	
	Vector n=p.getNormal(p1);
	
	assertEquals(n,v1);
	 
	 
	}
	
	@Test
	void intersectionsTest() {
		Material m = new Material();
	Point3D p = new Point3D(1,1,1);
	Point3D p1 = new Point3D(3,0,0);
	Vector v = new Vector(p1);
    Plane pl = new Plane(Color.green,p,v,m);
    
    Point3D p0 = new Point3D(2,1,2);
	Vector v1 = new Vector(new Point3D(3,0,0));
	Ray ray = new Ray(p0,v1);
		
	List<Point3D> list1 = new ArrayList<Point3D>();
	List<Point3D> list2 = new ArrayList<Point3D>();
	list1 = pl.findIntersections(ray);
	list2=null;
	
	assertEquals(list1,list2);
	}

	@Test
	void intersections1Test() {
		
	Point3D p = new Point3D(3,1,1);
	Point3D p1 = new Point3D(3,0,0);
	Material m = new Material();
	Vector v = new Vector(p1);
    Plane pl = new Plane(Color.green,p,v,m);
    
    Point3D p0 = new Point3D(2,1,2);
	Vector v1 = new Vector(new Point3D(3,0,0));
	Ray ray = new Ray(p0,v1);
		
	List<Point3D> list1 = new ArrayList<Point3D>();
	List<Point3D> list2 = new ArrayList<Point3D>();
	list1 = pl.findIntersections(ray);
	Point3D p2 = new Point3D(3,1,2);
	list2.add(p2);
	
	assertEquals(list1,list2);
	}
}
