package tester;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import geometries.Sphere;
import primitives.Coordinate;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

class assertSphere {

	@Test
	void normalTest() {
	Point3D p1= new Point3D(1,2,3);
	Point3D p2= new Point3D(2,3,4);
	double x=0.5773502691896258;
	Point3D p3= new Point3D(x,x,x);
	double r = 1;
	Sphere s = new Sphere(r,p1);
	Vector v=new Vector(p3);
	Vector n=s.getNormal(p2);
	
	assertEquals(n,v);
	 
	 
	}
	
	@Test
	void intersectionsTest() {
	double r  = 3.0;
	Point3D center = new Point3D(1,3,4);
	Sphere s = new Sphere(r,center);
	Point3D p0 = new Point3D(0,0,0);
	Vector v = new Vector(new Point3D(3,3,3));
	Ray ray = new Ray(p0,v);
		
	List<Point3D> list1 = new ArrayList<Point3D>();
	List<Point3D> list2 = new ArrayList<Point3D>();
	list1 = s.findIntersections(ray);
	Coordinate c1= new Coordinate(1.464816241512003);
	Coordinate c2= new Coordinate(3.8685170918213303);

	Point3D p1 = new Point3D(c1,c1,c1);
	Point3D p2= new Point3D(c2,c2,c2);
	list2.add(p1);
	list2.add(p2);
	
	assertEquals(list1,list2);
	}


/*
@Test
void intersections1Test() {
double r  = 1;
Point3D center = new Point3D(0,0,0);
Sphere s = new Sphere(r,center);
Point3D p0 = new Point3D(2,1,2);
Vector v = new Vector(new Point3D(3,0,0));
Ray ray = new Ray(p0,v);
	
List<Point3D> list1 = new ArrayList<Point3D>();
List<Point3D> list2 = new ArrayList<Point3D>();
list1 = s.findIntersections(ray);
Point3D p1 = new Point3D(4,1,2);
Point3D p2= new Point3D(6,1,2);
list2.add(p1);
list2.add(p2);

assertEquals(list1,list2);
}
*/
}
