package geometries;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Plane extends Geometry implements FlatGeometry{
	
	private Point3D p;
	private Vector v;

	// ***************** Constructors ********************** // 
	
	public Plane(Color color, Point3D p, Vector v, Material m) {
		super(color, m);
		this.p = p;
		this.v = v;
		
		
	}

	public Plane() {
		super();
		this.p =new Point3D();
		this.v =new Vector() ;
		
	}
	
	public Plane(Plane other) {
		this.p = other.p;
		this.v= other.v;
	

	}


	
	// ***************** Getters/Setters ********************** // 
	
		public Point3D getP() {
		return p;
	}

	public void setP(Point3D p) {
		this.p = p;
	}

	public Vector getV() {
		return v;
	}

	public void setV(Vector v) {
		this.v = v;
	}

	
	
	// ***************** Administration  ******************** // 

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plane other = (Plane) obj;
		if (p == null) {
			if (other.p != null)
				return false;
		} else if (!p.equals(other.p))
			return false;
		if (v == null) {
			if (other.v != null)
				return false;
		} else if (!v.equals(other.v))
			return false;
		return true;
	}
		
		@Override
		public String toString() {
			return p.toString() +" "+ v.toString() ;
	}
	
		



	// ***************** Operations ******************** //		
	@Override
		public Vector getNormal (Point3D np) {
			return v;
	
	}
	
	@Override
	public List<Point3D> findIntersections  (Ray r){
		Vector vn =new Vector(r.getDirection().normalizationVector());
        double s = v.scalarMulti(vn);
        double s1 = 1/s;
		Vector v1 = new Vector(new Point3D(r.getPoo().substrct(p))).multiInScalar(s1);
		double t = -v.scalarMulti(v1);
		
		 List<Point3D> list = new ArrayList<Point3D>();
		 Point3D p1 = new Point3D();
		 p1= r.getPoo().addPointVector(vn.multiInScalar(t));
		  if (v.scalarMulti(new Vector(new Point3D(r.getPoo().addPointVector(vn)).substrct(p)))==0)
		  {
			  list.add(p1);
		  return list;
		  }
		
		return null;

	

}

		

	
	

}
