package tester;

import java.awt.Color;

import geometries.Cylinder;
import geometries.Plane;
import geometries.Sphere;
import geometries.Triangle;
import primitives.Coordinate;
import primitives.Material;
import primitives.Point2D;
import primitives.Point3D;
import primitives.Vector;
import primitives.Ray;

public class Tester {

	public static void main(String[] args) {
		
		Coordinate c1 = new Coordinate(3);
		Coordinate c2 = new Coordinate(5);
		Coordinate c3 = new Coordinate(8);
		
		
		Point2D p1 = new Point2D(c1, c2);
		Point3D p2 = new Point3D(1,2,3);
		Point3D p3 = new Point3D(c3,c2,c1);
		Point2D p4 = new Point2D();
		Point3D p5 = new Point3D();
		Point3D p6 = new Point3D(4,5,6);
		Point3D p7 = new Point3D(1,2,3);
		
		Vector v0 = new Vector();
		Vector v1 = new Vector(p3);
		Vector v2 = new Vector(new Point3D(2,4,6));
		
		Ray r0= new Ray();
		Ray r1= new Ray(p2,v1);
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println(p4);
		System.out.println(p5);
		System.out.println(v0);
		System.out.println(r0);
		System.out.println(v1);
		System.out.println(v2);
		System.out.println(r1);

		
	
		if (p3.equals(p2))
			System.out.println("yes");
		else
			System.out.println("no");
		
		
		System.out.println(c1.add(c2));
		System.out.println(c3.substrct(c2));
	
		System.out.println(p2.add(p3));
		System.out.println(p3.substrct(p2));

		System.out.println(p3.distance(p2));

		System.out.println(v1.equals(v2));
		System.out.println(v1.length());
		System.out.println(v1.scalarMulti(v2));
		System.out.println(v1.add(v2));
		System.out.println(v1.move(5));
		System.out.println(v1.normalizationVector());
		System.out.println(v1.substrct(v2));
		
		
		Color c = Color.BLUE;
		Material m = new Material();
		Triangle t1= new Triangle(c,p2,p6,p7,m);
		Triangle t2= new Triangle(c,p2,p6,p7,m);
		Triangle t3= new Triangle();
		
		Plane n1= new Plane(c,p2, v1,m);
		Plane n2= new Plane(c,p2, v1,m);
		Plane n3= new Plane(c,p6, v2,m);
		Plane n4= new Plane();
		
		double d1= 2;
		double d2= 3;

		Sphere s1= new Sphere();
		Sphere s2= new Sphere(d1,p6);
		Sphere s3= new Sphere(d2,p6);
		Sphere s4= new Sphere(d2,p6);

		Cylinder l1= new Cylinder();
		Cylinder l2= new Cylinder(d1,p7,v1);
		Cylinder l3= new Cylinder(d2,p6,v2);
		Cylinder l4= new Cylinder(d1,p2,v1);
		
	
		
		System.out.println(t1);
		System.out.println(t2);
		System.out.println(t3);
		System.out.println(t1.equals(t2));
		
		System.out.println(n1);
		System.out.println(n2);
		System.out.println(n3);
		System.out.println(n4);
		System.out.println(n1.equals(n2));
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		System.out.println(s1.equals(s2));
		System.out.println(s4.equals(s3));
		
		System.out.println(l1);
		System.out.println(l2);
		System.out.println(l3);
		System.out.println(l4);
		System.out.println(l1.equals(l2));
		System.out.println(l4.equals(l2));
		
		

	}

}
