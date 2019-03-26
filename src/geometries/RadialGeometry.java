package geometries;

import java.awt.Color;
import java.util.List;

import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class RadialGeometry extends Geometry{

	protected double radius;
	protected Color color;

	// ***************** Constructors ********************** // 

	public RadialGeometry() {
		this.radius=0;
	}

	public RadialGeometry(double radius) {
		this.radius = radius;
	} 
	
	public RadialGeometry(RadialGeometry other) {
		this.radius = other.radius;
	}
	public RadialGeometry(double radius, Color c,Material m) {
        super(c,m);
		this.radius=radius;
        
}


	// ***************** Getters/Setters ********************** // 
	
	
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
		
	}


	public Color getC() {
		return color;
	}
	public void setC(Color c) {
		this.color = c;
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
		RadialGeometry other = (RadialGeometry) obj;
		if (Double.doubleToLongBits(radius) != Double.doubleToLongBits(other.radius))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "" + radius ;
}
		
		// ***************** Operations ******************** //		

	
	@Override
	public Vector getNormal (Point3D p) {
	
			return new Vector();
		}
	
	@Override
	public List<Point3D> findIntersections  (Ray r){
		return null;
	}
	
	
}


