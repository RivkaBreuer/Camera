package geometries;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Sphere extends RadialGeometry {
	
	private Point3D center;

//***************** Constructors ********************** // 
	public Sphere() {
		super();
		this.center = new Point3D();
	}

	public Sphere(double radius , Point3D center) {
		super(radius);
		this.center = new Point3D(center);
	}
	
	public Sphere(double radius , Point3D center, Color c,Material m) {
		super(radius,c,m);
		this.center = new Point3D(center);
	}
	


	public Sphere(Sphere other) {
		this.center=other.center;
		this.radius=other.radius;
		
	}


	
	// ***************** Getters/Setters ********************** // 

		public Point3D getCenter() {
		return center;
	}

	public void setCenter(Point3D center) {
		this.center = center;
	}

	
	//***************** Administration  ******************** // 

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sphere other = (Sphere) obj;
		if (center == null) {
			if (other.center != null)
				return false;
		} else if (!center.equals(other.center))
			return false;
		return true;
		
	}
	
	@Override
	public String toString() {
		return "" + getRadius() + " " + center;
}
	

	// ***************** Operations ******************** //		
	@Override
		public Vector getNormal (Point3D p) {
		
		Vector v1= new Vector(p.substrct(center));
		//return v1;
				return v1.normalizationVector();
	
	}
	
	@Override
	public List<Point3D> findIntersections  (Ray r){
    
		Vector l = new Vector(this.center.substrct(r.getPoo()));
		Vector v = new Vector(r.getDirection().normalizationVector());
		double tm = l.scalarMulti(v);
		double d= Math.sqrt(l.length()*l.length()-tm*tm);
		double th = Math.sqrt(radius*radius - d*d);
		double t1= tm-th;
		double t2= tm+th;
	
	
	   List<Point3D> list = new ArrayList<Point3D>();
	   Point3D p1= new Point3D();
	   Point3D p2= new Point3D();

	   		if (t1>0)
	   			p1=r.getPoo().addPointVector(v.multiInScalar(t1));
	   		if (t2>0) 
	   		    p2= r.getPoo().addPointVector(v.multiInScalar(t2));
	   
	   if (d>radius)
		 return null;

	   else if (d==radius) 
	     list.add(p1);
		
	   else
	   {
		   list.add(p1);
	   	   list.add(p2);
	   }
	   
	   return list;
	   			   

}
	


	
	

}

