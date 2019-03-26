package primitives;

public class Vector {
	
	private Point3D head;

	
	// ***************** Constructors ********************** // 
	public Vector() {
		this.head = new Point3D();
	}	
	
		
	public Vector(Point3D head) {
		this.head = new Point3D(head);
	}
	
	public Vector(Vector other) {
		this.head = new Point3D(other.head);
	}
	


	// ***************** Getters/Setters ********************** // 
	
	public Point3D getHead() {
		return head;
	}



	public void setHead(Point3D head) {
		this.head = head;
	}
	
	// ***************** Administration  ******************** // 
	
	@Override
	public boolean equals(Object obj) {
	
		if (getClass() != obj.getClass())
			return false;
		Vector other = (Vector) obj;
		
		if (head == null){
			if (other.head != null)
				return false;
		}
		return (head.equals(other.head));
		
	}

	
	@Override
	public String toString() {
		return  head.toString();
	}
	
	// ***************** Operations ******************** // 
	
	public Vector add(Vector v){
		
		Point3D p= this.head.add(v.head);
		return new Vector(p);
		
	}
	
	public Vector substrct(Vector v){
		
		Vector s = new Vector();
		s.head.x=this.head.x.substrct(v.head.x);
		s.head.y=this.head.y.substrct(v.head.y);
		s.head.setZ(this.head.getZ().substrct(v.head.getZ()));
		
		return s;
	}
	
	public double scalarMulti(Vector v) {
	
		double x,y,z;
		x= this.head.getX().getCoordinate()*v.head.getX().getCoordinate();
		y= this.head.getY().getCoordinate()*v.head.getY().getCoordinate();
		z= this.head.getZ().getCoordinate()*v.head.getZ().getCoordinate();
		
		return x+y+z;
	
	}
	
	
	 public Vector multiInScalar(double s) {
	
		double x,y,z;
		x= this.head.getX().getCoordinate()*s;
		y= this.head.getY().getCoordinate()*s;
		z= this.head.getZ().getCoordinate()*s;
		return new Vector(new Point3D(x,y,z));
		
	
	}
	
	 
	
	public Vector move(double s) {
		
		double x,y,z;
		x= this.head.getX().getCoordinate()+s;
		y= this.head.getY().getCoordinate()+s;
		z= this.head.getZ().getCoordinate()+s;
		return new Vector(new Point3D(x,y,z));
		}
	
	public double length() {
		
		double x,y,z;
		x= this.head.getX().getCoordinate();
		y= this.head.getY().getCoordinate();
		z= this.head.getZ().getCoordinate();
		return Math.sqrt(x*x + y*y + z*z);
		}
	
	public Vector normalizationVector() {
		
		double x,y,z;
		x= this.head.getX().getCoordinate()/length();
		y= this.head.getY().getCoordinate()/length();
		z= this.head.getZ().getCoordinate()/length();
		return new Vector(new Point3D(x,y,z));
		}
	
	public Vector vectorProduct (Vector v) {
		double v1,v2,v3,u1,u2,u3;
		
		u1=this.head.getX().getCoordinate();
		u2=this.head.getY().getCoordinate();
		u3=this.head.getZ().getCoordinate();
		v1=v.head.getX().getCoordinate();
		v2=v.head.getY().getCoordinate();
		v3=v.head.getZ().getCoordinate();
		
		return new Vector(new Point3D(u2*v3-u3*v2,u3*v1-u1*v3,u1*v2-u2*v1));
		

	}
	
	
	
	
	
	
	
	
}
