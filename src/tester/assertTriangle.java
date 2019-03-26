package tester;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;


import geometries.Triangle;
import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

class assertTriangle {

	

	@Test
	void normalTest() {
	Color c= Color.blue;
	Point3D p1= new Point3D(1,2,3);
	Point3D p2= new Point3D(2,3,4);
	Point3D p3= new Point3D(4,5,8);
	Material m = new Material();
	Triangle t = new Triangle(c,p1,p2,p3,m);
	Point3D p4= new Point3D(2/Math.sqrt(8),-2/Math.sqrt(8),0);
	Vector v=new Vector(p4);
	Vector n=t.getNormal(p1);
	
	assertEquals(n,v);
	 
	 
	}
	
	@Test
	void intersectionsTest() {
	Point3D p1= new Point3D(1,2,3);
	Point3D p2= new Point3D(2,2,3);
	Point3D p3= new Point3D(1,2,1);
	Point3D p4= new Point3D(0,1,2);
	Vector v = new Vector(new Point3D(4,2,3));
	Ray r = new Ray(p4,v);
	Material m = new Material();
	
    Triangle t = new Triangle(Color.green,p1,p2,p3,m);
    t.findIntersections(r);
    
    List<Point3D> list1 = new ArrayList<Point3D>();
	List<Point3D> list2 = new ArrayList<Point3D>();
	list1 = t.findIntersections(r);
	list2=null;
	
	assertEquals(list1,list2);
	}
	
	@Test
	void intersections1Test() {
	Point3D p1= new Point3D(1,1,1);
	Point3D p2= new Point3D(2,1,0);
	Point3D p3= new Point3D(1,2,2);
	Point3D p4= new Point3D(0,1,0);
	Vector v = new Vector(new Point3D(4,2,3));
	Ray r = new Ray(p4,v);
	Material m = new Material();
	
    Triangle t = new Triangle(Color.green,p1,p2,p3,m);
    t.findIntersections(r);
    
    List<Point3D> list1 = new ArrayList<Point3D>();
	List<Point3D> list2 = new ArrayList<Point3D>();
	list1 = t.findIntersections(r);
	list2.add(new Point3D(4,2,3));
	
	assertEquals(list1,list2);
	}
	
}
