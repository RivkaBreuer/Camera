package geometries;

import java.awt.Color;
import java.util.List;

import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public abstract class Geometry {
	
 private Color color;
 private Material material;
 private Color emmission;

 
//***************** Constructors ********************** // 
public Geometry() {
	this.color= Color.white;
	this.material=new Material();
	emmission = Color.white;
	
	} 
 public Geometry(Color color,Material material,Color emmission) {
	this.color = color;
	this.emmission= emmission;
	this.material= material;
}
 
 public Geometry(Color color, Material m) {
	this.emmission = color;
	this.material= m;
	
}

 
public Geometry(Geometry other) {
	this.color = other.color;
	this.emmission= other.emmission;
	this.material= other.material;
}
 


// ***************** Getters/Setters ********************** // 

public Color getColor() {
	return color;
}

public void setColor(Color color) {
	this.color = color;
}

public Material getMaterial() {
	return material;
}

public void setMaterial(Material material) {
	this.material = material;
}
public Color getEmmission() {
	return emmission;
}
public void setEmmission(Color emmission) {
	this.emmission = emmission;
}

//***************** Administration  ******************** // 


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Geometry other = (Geometry) obj;
	if (color == null) {
		if (other.color != null)
			return false;
	} else if (!color.equals(other.color))
		return false;
	if (emmission == null) {
		if (other.emmission != null)
			return false;
	} else if (!emmission.equals(other.emmission))
		return false;
	if (material == null) {
		if (other.material != null)
			return false;
	} else if (!material.equals(other.material))
		return false;
	return true;
}

@Override
public String toString() 
{
	return "("+ "color" + this.color + "material" + this.material + "emmission" + this.emmission + ")";

}

// ***************** Operations ******************** //

public abstract Vector getNormal (Point3D p); 

public abstract List<Point3D> findIntersections  (Ray r);


 
}
