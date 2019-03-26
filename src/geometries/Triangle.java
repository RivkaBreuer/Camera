package geometries;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import primitives.Material;
import primitives.Point3D;
 import primitives.Ray;
 import primitives.Vector;


public class Triangle extends Geometry implements FlatGeometry  {
	
	private Point3D  p1;
	private Point3D  p2;
	private Point3D  p3;

	//***************** Constructors ********************** // 
	
	public Triangle(Color color, Point3D p1, Point3D p2, Point3D p3,Material m) {
		super(color,m);
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}
	
	public Triangle( Point3D p1, Point3D p2, Point3D p3) {
		
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}

	public Triangle() {
		super();
		this.p1 = new Point3D();
		this.p2 = new Point3D();
		this.p3 = new Point3D();
		
	}

	public Triangle(Triangle other) {
		this.p1 = other.p1;
		this.p2 = other.p2;
		this.p3 = other.p3;

	}

// ***************** Getters/Setters ********************** // 
	
	public Point3D getP1() {
		return p1;
	}

	public void setP1(Point3D p1) {
		this.p1 = p1;
	}

	public Point3D getP2() {
		return p2;
	}

	public void setP2(Point3D p2) {
		this.p2 = p2;
	}

	public Point3D getP3() {
		return p3;
	}

	public void setP3(Point3D p3) {
		this.p3 = p3;
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
		Triangle other = (Triangle) obj;
		if (p1 == null) {
			if (other.p1 != null)
				return false;
		} else if (!p1.equals(other.p1))
			return false;
		if (p2 == null) {
			if (other.p2 != null)
				return false;
		} else if (!p2.equals(other.p2))
			return false;
		if (p3 == null) {
			if (other.p3 != null)
				return false;
		} else if (!p3.equals(other.p3))
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		return p1.toString() +" "+p2.toString() +" " + p3.toString();
}
// ***************** Operations ******************** //		
@Override
	public Vector getNormal(Point3D p) {
	     
            Vector v1= new Vector(p2.substrct(p1));
            Vector v2= new Vector(p3.substrct(p1));  
            Vector v3= new Vector(v1.vectorProduct(v2));
			//return v3;
			return v3.normalizationVector();
		}


@Override
public List<Point3D> findIntersections(Ray r){
	Vector v1= new Vector(this.p1.substrct(r.getPoo()));
	Vector v2= new Vector(this.p2.substrct(r.getPoo()));
	Vector v3= new Vector(this.p3.substrct(r.getPoo()));
	
	Vector N1= new Vector(v2.vectorProduct(v1).normalizationVector());
	Vector N2= new Vector(v3.vectorProduct(v2).normalizationVector());
	Vector N3= new Vector(v1.vectorProduct(v3).normalizationVector());
	
	double a= (new Vector(r.getDirection().getHead().substrct(r.getPoo()))).scalarMulti(N1);
	double b= (new Vector(r.getDirection().getHead().substrct(r.getPoo()))).scalarMulti(N2);
	double c= (new Vector(r.getDirection().getHead().substrct(r.getPoo()))).scalarMulti(N3);
	
	List<Point3D> list = new ArrayList<Point3D>();
	
	
	if((a<0 && b<0 && c<0)||(a>=0 && b>=0 &&c>=0))
		{
		list.add(r.getDirection().getHead());
		return list;
		}
	return null;

}
/*
public List<Point3D> findIntersections(Ray p)
{
Vector v0=new Vector();
Plane pl = new Plane(new Color(0), p3, this.getNormal(p3),new Material());//build plane from the triangle
if (pl.findIntersections(p)==null)
return null;
    v0 = new Vector(new Point3D(pl.findIntersections(p).get(0)).substrct(p.getPoo()));

   Vector v1 = new Vector(new Point3D(p1.substrct(p.getPoo())));
Vector v2 = new Vector(new Point3D(p2.substrct(p.getPoo())));
Vector v3 = new Vector(new Point3D(p3.substrct(p.getPoo())));
Vector N1 = (v1.vectorProduct(v2)).normalizationVector();
Vector N3 = (v3.vectorProduct(v1)).normalizationVector();
Vector N2 = (v2.vectorProduct(v3)).normalizationVector();
List<Point3D> lst = new ArrayList<Point3D>();
double e1=v0.scalarMulti(N1);
double e2=v0.scalarMulti(N2);
double e3=v0.scalarMulti(N3);
       if(sigh(e1)==sigh(e2)&&sigh(e2)==sigh(e3))
       {
       lst.add(pl.findIntersections(p).get(0));
   }
else
return null;
return lst;
}
private int sigh(double d)
{
if(d<0)
return 1;
return 0;
   
}
	*/
}	
	
	




	
